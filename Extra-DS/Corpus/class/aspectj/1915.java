/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.aspectj.org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class AfterReturningAdviceDeclaration extends AfterAdviceDeclaration {

    public static final ChildPropertyDescriptor returningJAVADOC_PROPERTY = internalJavadocPropertyFactory(AfterReturningAdviceDeclaration.class);

    public static final ChildListPropertyDescriptor returningPARAMETERS_PROPERTY = //$NON-NLS-1$
    new ChildListPropertyDescriptor(AfterReturningAdviceDeclaration.class, "parameters", SingleVariableDeclaration.class, CYCLE_RISK);

    public static final ChildPropertyDescriptor returningPOINTCUT_PROPERTY = //$NON-NLS-1$
    new ChildPropertyDescriptor(AfterReturningAdviceDeclaration.class, "pointcut", PointcutDesignator.class, MANDATORY, NO_CYCLE_RISK);

    public static final ChildListPropertyDescriptor returningTHROWN_EXCEPTIONS_PROPERTY = //$NON-NLS-1$
    new ChildListPropertyDescriptor(AfterReturningAdviceDeclaration.class, "thrownExceptions", Name.class, NO_CYCLE_RISK);

    public static final ChildPropertyDescriptor returningBODY_PROPERTY = //$NON-NLS-1$
    new ChildPropertyDescriptor(AfterReturningAdviceDeclaration.class, "body", Block.class, OPTIONAL, CYCLE_RISK);

    protected static List returningPROPERTY_DESCRIPTORS_2_0;

    protected static List returningPROPERTY_DESCRIPTORS_3_0;

    public static final ChildPropertyDescriptor returningRETURNING_PROPERTY = //$NON-NLS-1$
    new ChildPropertyDescriptor(AfterReturningAdviceDeclaration.class, "returning", SingleVariableDeclaration.class, OPTIONAL, NO_CYCLE_RISK);

    public static List propertyDescriptors(int apiLevel) {
        if (apiLevel == AST.JLS2_INTERNAL) {
            return returningPROPERTY_DESCRIPTORS_2_0;
        } else {
            return returningPROPERTY_DESCRIPTORS_3_0;
        }
    }

    static {
        List propertyList = new ArrayList(6);
        createPropertyList(AfterReturningAdviceDeclaration.class, propertyList);
        addProperty(returningJAVADOC_PROPERTY, propertyList);
        addProperty(returningPARAMETERS_PROPERTY, propertyList);
        addProperty(returningTHROWN_EXCEPTIONS_PROPERTY, propertyList);
        addProperty(returningPOINTCUT_PROPERTY, propertyList);
        addProperty(returningRETURNING_PROPERTY, propertyList);
        addProperty(returningBODY_PROPERTY, propertyList);
        returningPROPERTY_DESCRIPTORS_2_0 = reapPropertyList(propertyList);
        propertyList = new ArrayList(6);
        createPropertyList(AfterReturningAdviceDeclaration.class, propertyList);
        addProperty(returningJAVADOC_PROPERTY, propertyList);
        addProperty(returningPARAMETERS_PROPERTY, propertyList);
        addProperty(returningTHROWN_EXCEPTIONS_PROPERTY, propertyList);
        addProperty(returningPOINTCUT_PROPERTY, propertyList);
        addProperty(returningRETURNING_PROPERTY, propertyList);
        addProperty(returningBODY_PROPERTY, propertyList);
        returningPROPERTY_DESCRIPTORS_3_0 = reapPropertyList(propertyList);
    }

    private SingleVariableDeclaration returning = null;

     AfterReturningAdviceDeclaration(AST ast) {
        super(ast);
    }

    final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
        if (property == returningRETURNING_PROPERTY) {
            if (get) {
                return getReturning();
            } else {
                setReturning((SingleVariableDeclaration) child);
                return null;
            }
        }
        return super.internalGetSetChildProperty(property, get, child);
    }

    public SingleVariableDeclaration getReturning() {
        return returning;
    }

    public void setReturning(SingleVariableDeclaration returning) {
        this.returning = returning;
    }

    ASTNode clone0(AST target) {
        AfterReturningAdviceDeclaration result = new AfterReturningAdviceDeclaration(target);
        result.setSourceRange(this.getStartPosition(), this.getLength());
        result.setJavadoc((Javadoc) ASTNode.copySubtree(target, getJavadoc()));
        result.parameters().addAll(ASTNode.copySubtrees(target, parameters()));
        result.setPointcut(getPointcut());
        result.setReturning(returning);
        result.thrownExceptions().addAll(ASTNode.copySubtrees(target, thrownExceptions()));
        result.setBody((Block) ASTNode.copySubtree(target, getBody()));
        return result;
    }

    int treeSize() {
        return super.treeSize() + (this.returning == null ? 0 : this.returning.treeSize());
    }

    void accept0(ASTVisitor visitor) {
        if (visitor instanceof AjASTVisitor) {
            boolean visitChildren = ((AjASTVisitor) visitor).visit(this);
            if (visitChildren) {
                // visit children in normal left to right reading order
                acceptChild(visitor, getJavadoc());
                acceptChildren(visitor, this.parameters);
                acceptChild(visitor, getPointcut());
                acceptChild(visitor, getReturning());
                acceptChildren(visitor, this.thrownExceptions);
                acceptChild(visitor, getBody());
            }
            ((AjASTVisitor) visitor).endVisit(this);
        }
    }
}
