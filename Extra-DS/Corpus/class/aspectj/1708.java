/* *******************************************************************
 * Copyright (c) 2002 Palo Alto Research Center, Incorporated (PARC).
 * All rights reserved.
 * This program and the accompanying materials are made available
 * under the terms of the Common Public License v1.0
 * which accompanies this distribution and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *     PARC     initial implementation
 *     Alexandre Vasseur    support for @AJ aspects
 * ******************************************************************/
package org.aspectj.weaver.bcel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionHandle;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.bridge.Message;
import org.aspectj.weaver.Advice;
import org.aspectj.weaver.AdviceKind;
import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.BCException;
import org.aspectj.weaver.ISourceContext;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.ResolvedMember;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.ShadowMunger;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.WeaverMessages;
import org.aspectj.weaver.World;
import org.aspectj.weaver.ast.Literal;
import org.aspectj.weaver.ast.Test;
import org.aspectj.weaver.patterns.ExactTypePattern;
import org.aspectj.weaver.patterns.ExposedState;
import org.aspectj.weaver.patterns.PerClause;
import org.aspectj.weaver.patterns.Pointcut;

/**
 * Advice implemented for bcel.
 * 
 * @author Erik Hilsdale
 * @author Jim Hugunin
 */
public class BcelAdvice extends Advice {

    private Test pointcutTest;

    private ExposedState exposedState;

    private boolean hasMatchedAtLeastOnce = false;

    public  BcelAdvice(AjAttribute.AdviceAttribute attribute, Pointcut pointcut, Member signature, ResolvedType concreteAspect) {
        super(attribute, pointcut, signature);
        this.concreteAspect = concreteAspect;
    }

    // !!! must only be used for testing
    public  BcelAdvice(AdviceKind kind, Pointcut pointcut, Member signature, int extraArgumentFlags, int start, int end, ISourceContext sourceContext, ResolvedType concreteAspect) {
        this(new AjAttribute.AdviceAttribute(kind, pointcut, extraArgumentFlags, start, end, sourceContext), pointcut, signature, concreteAspect);
        //!!! interaction with unit tests
        thrownExceptions = Collections.EMPTY_LIST;
    }

    // ---- implementations of ShadowMunger's methods
    public ShadowMunger concretize(ResolvedType fromType, World world, PerClause clause) {
        suppressLintWarnings(world);
        ShadowMunger ret = super.concretize(fromType, world, clause);
        clearLintSuppressions(world, this.suppressedLintKinds);
        return ret;
    }

    public ShadowMunger parameterizeWith(ResolvedType declaringType, Map typeVariableMap) {
        Pointcut pc = getPointcut().parameterizeWith(typeVariableMap);
        BcelAdvice ret = null;
        Member adviceSignature = signature;
        // allows for around advice where the return value is a type variable (see pr115250)
        if (signature instanceof ResolvedMember && signature.getDeclaringType().isGenericType()) {
            adviceSignature = ((ResolvedMember) signature).parameterizedWith(declaringType.getTypeParameters(), declaringType, declaringType.isParameterizedType());
        }
        ret = new BcelAdvice(this.attribute, pc, adviceSignature, this.concreteAspect);
        return ret;
    }

    public boolean match(Shadow shadow, World world) {
        suppressLintWarnings(world);
        boolean ret = super.match(shadow, world);
        clearLintSuppressions(world, this.suppressedLintKinds);
        return ret;
    }

    public void specializeOn(Shadow shadow) {
        if (getKind() == AdviceKind.Around) {
            ((BcelShadow) shadow).initializeForAroundClosure();
        }
        //XXX this case is just here for supporting lazy test code
        if (getKind() == null) {
            exposedState = new ExposedState(0);
            return;
        }
        if (getKind().isPerEntry()) {
            exposedState = new ExposedState(0);
        } else if (getKind().isCflow()) {
            exposedState = new ExposedState(nFreeVars);
        } else if (getSignature() != null) {
            exposedState = new ExposedState(getSignature());
        } else {
            exposedState = new ExposedState(0);
            //XXX this case is just here for supporting lazy test code
            return;
        }
        World world = shadow.getIWorld();
        suppressLintWarnings(world);
        pointcutTest = getPointcut().findResidue(shadow, exposedState);
        clearLintSuppressions(world, this.suppressedLintKinds);
        // so that the joinpoint is primed for weaving
        if (getKind() == AdviceKind.PerThisEntry) {
            shadow.getThisVar();
        } else if (getKind() == AdviceKind.PerTargetEntry) {
            shadow.getTargetVar();
        }
        // make sure thisJoinPoint parameters are initialized
        if ((getExtraParameterFlags() & ThisJoinPointStaticPart) != 0) {
            ((BcelShadow) shadow).getThisJoinPointStaticPartVar();
            ((BcelShadow) shadow).getEnclosingClass().warnOnAddedStaticInitializer(shadow, getSourceLocation());
        }
        if ((getExtraParameterFlags() & ThisJoinPoint) != 0) {
            boolean hasGuardTest = pointcutTest != Literal.TRUE && getKind() != AdviceKind.Around;
            boolean isAround = getKind() == AdviceKind.Around;
            ((BcelShadow) shadow).requireThisJoinPoint(hasGuardTest, isAround);
            ((BcelShadow) shadow).getEnclosingClass().warnOnAddedStaticInitializer(shadow, getSourceLocation());
            if (!hasGuardTest && world.getLint().multipleAdviceStoppingLazyTjp.isEnabled()) {
                // collect up the problematic advice
                ((BcelShadow) shadow).addAdvicePreventingLazyTjp(this);
            }
            if (!isAround && !hasGuardTest && world.getLint().noGuardForLazyTjp.isEnabled()) {
                // can't build tjp lazily, no suitable test...
                world.getLint().noGuardForLazyTjp.signal(new String[] { shadow.toString() }, getSourceLocation(), new ISourceLocation[] { ((BcelShadow) shadow).getSourceLocation() });
            }
        }
        if ((getExtraParameterFlags() & ThisEnclosingJoinPointStaticPart) != 0) {
            ((BcelShadow) shadow).getThisEnclosingJoinPointStaticPartVar();
            ((BcelShadow) shadow).getEnclosingClass().warnOnAddedStaticInitializer(shadow, getSourceLocation());
        }
    }

    private boolean canInline(Shadow s) {
        if (attribute.isProceedInInners())
            return false;
        //XXX this guard seems to only be needed for bad test cases
        if (concreteAspect == null || concreteAspect.isMissing())
            return false;
        if (concreteAspect.getWorld().isXnoInline())
            return false;
        //System.err.println("isWoven? " + ((BcelObjectType)concreteAspect).getLazyClassGen().getWeaverState());
        return BcelWorld.getBcelObjectType(concreteAspect).getLazyClassGen().isWoven();
    }

    public void implementOn(Shadow s) {
        hasMatchedAtLeastOnce = true;
        BcelShadow shadow = (BcelShadow) s;
        if (getKind() == AdviceKind.Before) {
            shadow.weaveBefore(this);
        } else if (getKind() == AdviceKind.AfterReturning) {
            shadow.weaveAfterReturning(this);
        } else if (getKind() == AdviceKind.AfterThrowing) {
            UnresolvedType catchType = hasExtraParameter() ? getExtraParameterType() : UnresolvedType.THROWABLE;
            shadow.weaveAfterThrowing(this, catchType);
        } else if (getKind() == AdviceKind.After) {
            shadow.weaveAfter(this);
        } else if (getKind() == AdviceKind.Around) {
            // One solution would be to flag @AJ aspect with an annotation as "prepared" and query that one.
            if (!canInline(s)) {
                shadow.weaveAroundClosure(this, hasDynamicTests());
            } else {
                shadow.weaveAroundInline(this, hasDynamicTests());
            }
        } else if (getKind() == AdviceKind.InterInitializer) {
            shadow.weaveAfterReturning(this);
        } else if (getKind().isCflow()) {
            shadow.weaveCflowEntry(this, getSignature());
        } else if (getKind() == AdviceKind.PerThisEntry) {
            shadow.weavePerObjectEntry(this, (BcelVar) shadow.getThisVar());
        } else if (getKind() == AdviceKind.PerTargetEntry) {
            shadow.weavePerObjectEntry(this, (BcelVar) shadow.getTargetVar());
        } else if (getKind() == AdviceKind.Softener) {
            shadow.weaveSoftener(this, ((ExactTypePattern) exceptionType).getType());
        } else if (getKind() == AdviceKind.PerTypeWithinEntry) {
            // PTWIMPL Entry to ptw is the static initialization of a type that matched the ptw type pattern
            shadow.weavePerTypeWithinAspectInitialization(this, shadow.getEnclosingType());
        } else {
            throw new BCException("unimplemented kind: " + getKind());
        }
    }

    // ---- implementations
    private Collection collectCheckedExceptions(UnresolvedType[] excs) {
        if (excs == null || excs.length == 0)
            return Collections.EMPTY_LIST;
        Collection ret = new ArrayList();
        World world = concreteAspect.getWorld();
        ResolvedType runtimeException = world.getCoreType(UnresolvedType.RUNTIME_EXCEPTION);
        ResolvedType error = world.getCoreType(UnresolvedType.ERROR);
        for (int i = 0, len = excs.length; i < len; i++) {
            ResolvedType t = world.resolve(excs[i], true);
            if (t.isMissing()) {
                world.getLint().cantFindType.signal(WeaverMessages.format(WeaverMessages.CANT_FIND_TYPE_EXCEPTION_TYPE, excs[i].getName()), getSourceLocation());
            //                IMessage msg = new Message(
            //                  WeaverMessages.format(WeaverMessages.CANT_FIND_TYPE_EXCEPTION_TYPE,excs[i].getName()),
            //                  "",IMessage.ERROR,getSourceLocation(),null,null);
            //                world.getMessageHandler().handleMessage(msg);
            }
            if (!(runtimeException.isAssignableFrom(t) || error.isAssignableFrom(t))) {
                ret.add(t);
            }
        }
        return ret;
    }

    private Collection thrownExceptions = null;

    public Collection getThrownExceptions() {
        if (thrownExceptions == null) {
            //??? can we really lump in Around here, how does this interact with Throwable
            if (// null tests for test harness
            concreteAspect != null && concreteAspect.getWorld() != null && (getKind().isAfter() || getKind() == AdviceKind.Before || getKind() == AdviceKind.Around)) {
                World world = concreteAspect.getWorld();
                ResolvedMember m = world.resolve(signature);
                if (m == null) {
                    thrownExceptions = Collections.EMPTY_LIST;
                } else {
                    thrownExceptions = collectCheckedExceptions(m.getExceptions());
                }
            } else {
                thrownExceptions = Collections.EMPTY_LIST;
            }
        }
        return thrownExceptions;
    }

    /**
     * The munger must not check for the advice exceptions to be declared by the shadow in the case
     * of @AJ aspects so that around can throws Throwable
     *
     * @return
     */
    public boolean mustCheckExceptions() {
        if (getConcreteAspect() == null) {
            return true;
        }
        return !getConcreteAspect().isAnnotationStyleAspect();
    }

    // only call me after prepare has been called
    public boolean hasDynamicTests() {
        return pointcutTest != null && // || pointcutTest == Literal.NO_TEST);
        !(pointcutTest == Literal.TRUE);
    }

    /**
	 * get the instruction list for the really simple version of this advice.  
	 * Is broken apart
	 * for other advice, but if you want it in one block, this is the method to call.
	 * 
	 * @param s The shadow around which these instructions will eventually live.
	 * @param extraArgVar The var that will hold the return value or thrown exception 
	 * 			for afterX advice
	 * @param ifNoAdvice The instructionHandle to jump to if the dynamic 
	 * 			tests for this munger fails.
	 */
    InstructionList getAdviceInstructions(BcelShadow s, BcelVar extraArgVar, InstructionHandle ifNoAdvice) {
        BcelShadow shadow = (BcelShadow) s;
        InstructionFactory fact = shadow.getFactory();
        BcelWorld world = shadow.getWorld();
        InstructionList il = new InstructionList();
        // after throwing does this just by the exception mechanism.
        if (hasExtraParameter() && getKind() == AdviceKind.AfterReturning) {
            UnresolvedType extraParameterType = getExtraParameterType();
            if (!extraParameterType.equals(UnresolvedType.OBJECT) && !extraParameterType.isPrimitiveType()) {
                il.append(BcelRenderer.renderTest(fact, world, Test.makeInstanceof(extraArgVar, getExtraParameterType().resolve(world)), null, ifNoAdvice, null));
            }
        }
        il.append(getAdviceArgSetup(shadow, extraArgVar, null));
        il.append(getNonTestAdviceInstructions(shadow));
        InstructionHandle ifYesAdvice = il.getStart();
        il.insert(getTestInstructions(shadow, ifYesAdvice, ifNoAdvice, ifYesAdvice));
        return il;
    }

    public InstructionList getAdviceArgSetup(BcelShadow shadow, BcelVar extraVar, InstructionList closureInstantiation) {
        InstructionFactory fact = shadow.getFactory();
        BcelWorld world = shadow.getWorld();
        InstructionList il = new InstructionList();
        if (exposedState.getAspectInstance() != null) {
            il.append(BcelRenderer.renderExpr(fact, world, exposedState.getAspectInstance()));
        }
        // pr121385
        boolean x = this.getDeclaringAspect().resolve(world).isAnnotationStyleAspect();
        final boolean isAnnotationStyleAspect = getConcreteAspect() != null && getConcreteAspect().isAnnotationStyleAspect() && x;
        boolean previousIsClosure = false;
        for (int i = 0, len = exposedState.size(); i < len; i++) {
            // Erroneous vars have already had error msgs reported!
            if (exposedState.isErroneousVar(i))
                continue;
            BcelVar v = (BcelVar) exposedState.get(i);
            if (v == null) {
                // if not @AJ aspect, go on with the regular binding handling
                if (!isAnnotationStyleAspect) {
                    ;
                } else {
                    //    il.append(closureInstantiation);
                    if ("Lorg/aspectj/lang/ProceedingJoinPoint;".equals(getSignature().getParameterTypes()[i].getSignature())) {
                        //make sure we are in an around, since we deal with the closure, not the arg here
                        if (getKind() != AdviceKind.Around) {
                            previousIsClosure = false;
                            getConcreteAspect().getWorld().getMessageHandler().handleMessage(new Message("use of ProceedingJoinPoint is allowed only on around advice (" + "arg " + i + " in " + toString() + ")", this.getSourceLocation(), true));
                            // try to avoid verify error and pass in null
                            il.append(InstructionConstants.ACONST_NULL);
                        } else {
                            if (previousIsClosure) {
                                il.append(InstructionConstants.DUP);
                            } else {
                                previousIsClosure = true;
                                il.append(closureInstantiation.copy());
                            }
                        }
                    } else if ("Lorg/aspectj/lang/JoinPoint$StaticPart;".equals(getSignature().getParameterTypes()[i].getSignature())) {
                        previousIsClosure = false;
                        if ((getExtraParameterFlags() & ThisJoinPointStaticPart) != 0) {
                            shadow.getThisJoinPointStaticPartBcelVar().appendLoad(il, fact);
                        }
                    } else if ("Lorg/aspectj/lang/JoinPoint;".equals(getSignature().getParameterTypes()[i].getSignature())) {
                        previousIsClosure = false;
                        if ((getExtraParameterFlags() & ThisJoinPoint) != 0) {
                            il.append(shadow.loadThisJoinPoint());
                        }
                    } else if ("Lorg/aspectj/lang/JoinPoint$EnclosingStaticPart;".equals(getSignature().getParameterTypes()[i].getSignature())) {
                        previousIsClosure = false;
                        if ((getExtraParameterFlags() & ThisEnclosingJoinPointStaticPart) != 0) {
                            shadow.getThisEnclosingJoinPointStaticPartBcelVar().appendLoad(il, fact);
                        }
                    } else if (hasExtraParameter()) {
                        previousIsClosure = false;
                        extraVar.appendLoadAndConvert(il, fact, getExtraParameterType().resolve(world));
                    } else {
                        previousIsClosure = false;
                        getConcreteAspect().getWorld().getMessageHandler().handleMessage(new Message("use of ProceedingJoinPoint is allowed only on around advice (" + "arg " + i + " in " + toString() + ")", this.getSourceLocation(), true));
                        // try to avoid verify error and pass in null
                        il.append(InstructionConstants.ACONST_NULL);
                    }
                }
            } else {
                UnresolvedType desiredTy = getBindingParameterTypes()[i];
                v.appendLoadAndConvert(il, fact, desiredTy.resolve(world));
            }
        }
        // in the middle of the formal bindings but at the end, in a rock solid ordering
        if (!isAnnotationStyleAspect) {
            if (getKind() == AdviceKind.Around) {
                il.append(closureInstantiation);
            } else if (hasExtraParameter()) {
                extraVar.appendLoadAndConvert(il, fact, getExtraParameterType().resolve(world));
            }
            // org.aspectj.ajdt.internal.compiler.ast.AdviceDeclaration
            if ((getExtraParameterFlags() & ThisJoinPointStaticPart) != 0) {
                shadow.getThisJoinPointStaticPartBcelVar().appendLoad(il, fact);
            }
            if ((getExtraParameterFlags() & ThisJoinPoint) != 0) {
                il.append(shadow.loadThisJoinPoint());
            }
            if ((getExtraParameterFlags() & ThisEnclosingJoinPointStaticPart) != 0) {
                shadow.getThisEnclosingJoinPointStaticPartBcelVar().appendLoad(il, fact);
            }
        }
        return il;
    }

    public InstructionList getNonTestAdviceInstructions(BcelShadow shadow) {
        return new InstructionList(Utility.createInvoke(shadow.getFactory(), shadow.getWorld(), getOriginalSignature()));
    }

    public Member getOriginalSignature() {
        Member sig = getSignature();
        if (sig instanceof ResolvedMember) {
            ResolvedMember rsig = (ResolvedMember) sig;
            if (rsig.hasBackingGenericMember())
                return rsig.getBackingGenericMember();
        }
        return sig;
    }

    public InstructionList getTestInstructions(BcelShadow shadow, InstructionHandle sk, InstructionHandle fk, InstructionHandle next) {
        //System.err.println("test: " + pointcutTest);
        return BcelRenderer.renderTest(shadow.getFactory(), shadow.getWorld(), pointcutTest, sk, fk, next);
    }

    public int compareTo(Object other) {
        if (!(other instanceof BcelAdvice))
            return 0;
        BcelAdvice o = (BcelAdvice) other;
        //System.err.println("compareTo: " + this + ", " + o);
        if (kind.getPrecedence() != o.kind.getPrecedence()) {
            if (kind.getPrecedence() > o.kind.getPrecedence())
                return +1;
            else
                return -1;
        }
        if (kind.isCflow()) {
            //			System.err.println("sort: " + this + " innerCflowEntries " + innerCflowEntries);
            //			System.err.println("      " + o + " innerCflowEntries " + o.innerCflowEntries);
            boolean isBelow = (kind == AdviceKind.CflowBelowEntry);
            if (this.innerCflowEntries.contains(o))
                return isBelow ? +1 : -1;
            else if (o.innerCflowEntries.contains(this))
                return isBelow ? -1 : +1;
            else
                return 0;
        }
        if (kind.isPerEntry() || kind == AdviceKind.Softener) {
            return 0;
        }
        //System.out.println("compare: " + this + " with " + other);
        World world = concreteAspect.getWorld();
        int ret = concreteAspect.getWorld().compareByPrecedence(concreteAspect, o.concreteAspect);
        if (ret != 0)
            return ret;
        ResolvedType declaringAspect = getDeclaringAspect().resolve(world);
        ResolvedType o_declaringAspect = o.getDeclaringAspect().resolve(world);
        if (declaringAspect == o_declaringAspect) {
            if (kind.isAfter() || o.kind.isAfter()) {
                return this.getStart() < o.getStart() ? -1 : +1;
            } else {
                return this.getStart() < o.getStart() ? +1 : -1;
            }
        } else if (declaringAspect.isAssignableFrom(o_declaringAspect)) {
            return -1;
        } else if (o_declaringAspect.isAssignableFrom(declaringAspect)) {
            return +1;
        } else {
            return 0;
        }
    }

    public BcelVar[] getExposedStateAsBcelVars(boolean isAround) {
        // ATAJ aspect
        if (isAround) {
            // the closure instantiation has the same mapping as the extracted method from wich it is called
            if (getConcreteAspect() != null && getConcreteAspect().isAnnotationStyleAspect()) {
                return BcelVar.NONE;
            }
        }
        //System.out.println("vars: " + Arrays.asList(exposedState.vars));
        if (exposedState == null)
            return BcelVar.NONE;
        int len = exposedState.vars.length;
        BcelVar[] ret = new BcelVar[len];
        for (int i = 0; i < len; i++) {
            ret[i] = (BcelVar) exposedState.vars[i];
        }
        //(BcelVar[]) exposedState.vars;
        return ret;
    }

    public boolean hasMatchedSomething() {
        return hasMatchedAtLeastOnce;
    }

    protected void suppressLintWarnings(World inWorld) {
        if (suppressedLintKinds == null) {
            if (signature instanceof BcelMethod) {
                this.suppressedLintKinds = Utility.getSuppressedWarnings(signature.getAnnotations(), inWorld.getLint());
            } else {
                this.suppressedLintKinds = Collections.EMPTY_LIST;
            }
        }
        inWorld.getLint().suppressKinds(suppressedLintKinds);
    }

    protected void clearLintSuppressions(World inWorld, Collection toClear) {
        inWorld.getLint().clearSuppressions(toClear);
    }
}