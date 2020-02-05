/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.aspectj.tools.ajc;

import java.util.HashMap;
import junit.framework.TestCase;
import org.aspectj.org.eclipse.jdt.core.dom.AST;
import org.aspectj.org.eclipse.jdt.core.dom.ASTParser;
import org.aspectj.org.eclipse.jdt.core.dom.AfterAdviceDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.AfterReturningAdviceDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.AfterThrowingAdviceDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.AjASTVisitor;
import org.aspectj.org.eclipse.jdt.core.dom.AjTypeDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.AroundAdviceDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.AspectDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.Assignment;
import org.aspectj.org.eclipse.jdt.core.dom.BeforeAdviceDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.Block;
import org.aspectj.org.eclipse.jdt.core.dom.BlockComment;
import org.aspectj.org.eclipse.jdt.core.dom.BodyDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.CompilationUnit;
import org.aspectj.org.eclipse.jdt.core.dom.DeclareAtConstructorDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.DeclareAtFieldDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.DeclareAtMethodDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.DeclareAtTypeDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.DeclareErrorDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.DeclareParentsDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.DeclarePrecedenceDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.DeclareSoftDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.DeclareWarningDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.DefaultTypePattern;
import org.aspectj.org.eclipse.jdt.core.dom.ExpressionStatement;
import org.aspectj.org.eclipse.jdt.core.dom.FieldAccess;
import org.aspectj.org.eclipse.jdt.core.dom.FieldDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.InfixExpression;
import org.aspectj.org.eclipse.jdt.core.dom.Initializer;
import org.aspectj.org.eclipse.jdt.core.dom.InterTypeFieldDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.InterTypeMethodDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.MethodDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.MethodInvocation;
import org.aspectj.org.eclipse.jdt.core.dom.NumberLiteral;
import org.aspectj.org.eclipse.jdt.core.dom.PerCflow;
import org.aspectj.org.eclipse.jdt.core.dom.PerObject;
import org.aspectj.org.eclipse.jdt.core.dom.PerTypeWithin;
import org.aspectj.org.eclipse.jdt.core.dom.PointcutDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.PrimitiveType;
import org.aspectj.org.eclipse.jdt.core.dom.QualifiedName;
import org.aspectj.org.eclipse.jdt.core.dom.ReferencePointcut;
import org.aspectj.org.eclipse.jdt.core.dom.SignaturePattern;
import org.aspectj.org.eclipse.jdt.core.dom.SimpleName;
import org.aspectj.org.eclipse.jdt.core.dom.StringLiteral;
import org.aspectj.org.eclipse.jdt.core.dom.TypeDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.VariableDeclaration;
import org.aspectj.org.eclipse.jdt.core.dom.VariableDeclarationStatement;

public class ASTVisitorTest extends TestCase {

    // from bug 110465 - will currently break because of casts
    public void testAspectWithITD() {
        check("aspect A{ public void B.x(){} }", "(compilationUnit(aspect(simpleName)(methodITD(primitiveType)(simpleName)(block))))");
    }

    public void testAspectWithCommentThenITD() {
        check("aspect A{ /** */ public void B.x(){} }", "(compilationUnit(aspect(simpleName)(methodITD(primitiveType)(simpleName)(block))))");
    }

    public void testAspectWithCommentThenPointcut() {
        check("aspect A{ /** */ pointcut x(); }", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testAPrivilegedAspect() {
        check("privileged aspect AnAspect{}", "(compilationUnit(privileged(aspect(simpleName))))");
    }

    // original tests
    public void testAnInterface() {
        check("interface AnInterface{}", "(compilationUnit(interface(simpleName)))");
    }

    public void testAnAspect() {
        check("aspect AnAspect{}", "(compilationUnit(aspect(simpleName)))");
    }

    public void testPointcutInClass() {
        check("class A {pointcut a();}", "(compilationUnit(class(simpleName)(pointcut(simpleName))))");
    }

    public void testPointcutInAspect() {
        check("aspect A {pointcut a();}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testAroundAdvice() {
        check("aspect A {pointcut a();void around():a(){}}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(aroundAdvice(primitiveType)(referencePointcut(simpleName))(block))))");
    }

    public void testAroundAdviceWithProceed() {
        // ajh02: currently proceed calls are just normal method calls
        // could add a special AST node for them if anyone would like
        check("aspect A {pointcut a();void around():a(){proceed();}}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(aroundAdvice(primitiveType)(referencePointcut(simpleName))(block(expressionStatement(methodInvocation(simpleName)))))))");
    }

    public void testBeforeAdvice() {
        check("aspect A {pointcut a();before():a(){}}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(beforeAdvice(referencePointcut(simpleName))(block))))");
    }

    public void testAfterAdvice() {
        check("aspect A {pointcut a();after():a(){}}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(afterAdvice(referencePointcut(simpleName))(block))))");
    }

    public void testAfterThrowingAdviceWithNoArgument() {
        check("aspect A {pointcut a();after()throwing:a(){} }", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(afterThrowingAdvice(referencePointcut(simpleName))(block))))");
    }

    public void testAfterThrowingAdvice() {
        check("aspect A {pointcut a();after()throwing(Exception e):a(){} }", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(afterThrowingAdvice(referencePointcut(simpleName))(simpleName)(simpleName)(block))))");
    }

    public void testAfterReturningAdviceWithNoArgument() {
        check("aspect A {pointcut a();after()returning:a(){}}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(afterReturningAdvice(referencePointcut(simpleName))(block))))");
    }

    public void testAfterReturningAdvice() {
        check("aspect A {pointcut a();after()returning(Object o):a(){}}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(afterReturningAdvice(referencePointcut(simpleName))(simpleName)(simpleName)(block))))");
    }

    public void testMethodWithStatements() {
        check("class A {void a(){System.out.println(\"a\");}}", "(compilationUnit(class(simpleName)(method(primitiveType)(simpleName)(block(expressionStatement(methodInvocation(qualifiedName(simpleName)(simpleName))(simpleName)(stringLiteral)))))))");
    }

    public void testAdviceWithStatements() {
        check("aspect A {pointcut a();before():a(){System.out.println(\"a\");}}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(beforeAdvice(referencePointcut(simpleName))(block(expressionStatement(methodInvocation(qualifiedName(simpleName)(simpleName))(simpleName)(stringLiteral)))))))");
    }

    public void testPointcutInAPointcut() {
        check("aspect A {pointcut a();pointcut b();pointcut c(): a() && b();}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(pointcut(simpleName))(pointcut(simpleName)(referencePointcut(simpleName))(referencePointcut(simpleName)))))");
    }

    public void testCallPointcut() {
        check("aspect A {pointcut a(): call(* *.*(..));}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testExecutionPointcut() {
        check("aspect A {pointcut a(): execution(* *.*(..));}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testGetPointcut() {
        check("aspect A {pointcut a(): get(* *.*);}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testSetPointcut() {
        check("aspect A {pointcut a(): set(* *.*);}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testHandlerPointcut() {
        check("aspect A {pointcut a(): handler(Exception+);}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testStaticInitializationPointcut() {
        check("aspect A {pointcut a(): staticinitialization(Object+);}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testInitializationPointcut() {
        check("aspect A {pointcut a(): initialization(public Object+.new());}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testPreInitializationPointcut() {
        check("aspect A {pointcut a(): preinitialization(public Object+.new());}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testAdviceExecutionPointcut() {
        check("aspect A {pointcut a(): adviceexecution();}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testPointcutWithoutArguments() {
        check("aspect A {pointcut a(): adviceexecution();}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))))");
    }

    public void testPointcutWithOnePrimitiveArgument() {
        check("aspect A {pointcut a(int a): adviceexecution();}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName)(primitiveType)(simpleName))))");
    }

    public void testPointcutWithTwoPrimitiveArguments() {
        check("aspect A {pointcut a(int a, double b): adviceexecution();}", "(compilationUnit(aspect(simpleName)(pointcut" + "(simpleName)(primitiveType)(simpleName)(primitiveType)" + "(simpleName))))");
    }

    public void testPointcutWithOneTypedArgument() {
        check("aspect A {pointcut a(A a): adviceexecution();}", "(compilationUnit(aspect(simpleName)(pointcut" + "(simpleName)(simpleName)" + "(simpleName))))");
    }

    public void testPointcutWithTwoTypedArgument() {
        check("aspect A {pointcut a(A a, B b): adviceexecution();}", "(compilationUnit(aspect(simpleName)(pointcut" + "(simpleName)(simpleName)" + "(simpleName)(simpleName)" + "(simpleName))))");
    }

    public void testFieldITD() {
        check("class A {}aspect B {int A.a;}", "(compilationUnit(class(simpleName))(aspect(simpleName)(fieldITD(primitiveType)(simpleName))))");
    }

    public void testMethodITD() {
        check("class A {}aspect B {void A.a(){}}", "(compilationUnit(class(simpleName))(aspect(simpleName)(methodITD(primitiveType)(simpleName)(block))))");
    }

    public void testConstructorITD() {
        check("class A {}aspect B {A.new(){}}", "(compilationUnit(class(simpleName))(aspect(simpleName)(constructorITD(primitiveType)(simpleName)(block))))");
    }

    public void testInitializedField() {
        check("class A{int a = 1;}", "(compilationUnit(class(simpleName)(field(primitiveType)(simpleName)(numberLiteral))))");
    }

    public void testMethodITDWithStatements() {
        check("class A {}aspect B {void A.a(){System.out.println(\"a\");}}", "(compilationUnit(class(simpleName))(aspect(simpleName)(methodITD(primitiveType)(simpleName)(block(expressionStatement(methodInvocation(qualifiedName(simpleName)(simpleName))(simpleName)(stringLiteral)))))))");
    }

    public void testConstructorITDWithStatements() {
        check("class A {}aspect B {A.new(){System.out.println(\"a\");}}", "(compilationUnit(class(simpleName))(aspect(simpleName)(constructorITD(primitiveType)(simpleName)(block(expressionStatement(methodInvocation(qualifiedName(simpleName)(simpleName))(simpleName)(stringLiteral)))))))");
    }

    public void testInitializedFieldITD() {
        check("class A {}aspect B {int A.a = 1;}", "(compilationUnit(class(simpleName))(aspect(simpleName)(fieldITD(primitiveType)(simpleName)(numberLiteral))))");
    }

    public void testMethodBeingCalled() {
        check("class A {void a(){}void b(){a();}}", "(compilationUnit(class(simpleName)(method(primitiveType)(simpleName)(block))(method(primitiveType)(simpleName)(block(expressionStatement(methodInvocation(simpleName)))))))");
    }

    public void testFieldBeingCalled() {
        check("class A {int a;void b(){int c = a;a = c;}}", "(compilationUnit(class(simpleName)(field(primitiveType)(simpleName))(method(primitiveType)(simpleName)(block(variableDeclarationStatement(primitiveType)(simpleName)(simpleName))(expressionStatement(assignment(simpleName)(simpleName)))))))");
    }

    public void testConstructorBeingCalled() {
        check("class A {A(){}void b(){A();}}", "(compilationUnit(class(simpleName)(constructor(primitiveType)(simpleName)(block))(method(primitiveType)(simpleName)(block(expressionStatement(methodInvocation(simpleName)))))))");
    }

    public void testMethodITDBeingCalled() {
        check("class A {void b(){a();}}aspect B {void A.a(){}}", "(compilationUnit(class(simpleName)(method(primitiveType)(simpleName)(block(expressionStatement(methodInvocation(simpleName))))))(aspect(simpleName)(methodITD(primitiveType)(simpleName)(block))))");
    }

    public void testFieldITDBeingCalled() {
        check("class A {void b(){int c = a;a = c;}}aspect B {int A.a;}", "(compilationUnit(class(simpleName)(method(primitiveType)(simpleName)(block(variableDeclarationStatement(primitiveType)(simpleName)(simpleName))(expressionStatement(assignment(simpleName)(simpleName))))))(aspect(simpleName)(fieldITD(primitiveType)(simpleName))))");
    }

    public void testConstructorITDBeingCalled() {
        check("class A {void b(){A();}}aspect B {A.new(){}}", "(compilationUnit(class(simpleName)(method(primitiveType)(simpleName)(block(expressionStatement(methodInvocation(simpleName))))))(aspect(simpleName)(constructorITD(primitiveType)(simpleName)(block))))");
    }

    public void testDeclareParents() {
        check("class A{}class B{}aspect C {declare parents : A extends B;}", "(compilationUnit(class(simpleName))(class(simpleName))(aspect(simpleName)(declareParents(defaultTypePattern)(defaultTypePattern))))");
    }

    public void testDeclareWarning() {
        check("aspect A {pointcut a();declare warning: a(): \"warning\";}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(declareWarning(referencePointcut(simpleName))(stringLiteral))))");
    }

    public void testDeclareError() {
        check("aspect A {pointcut a();declare error: a(): \"error\";}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(declareError(referencePointcut(simpleName))(stringLiteral))))");
    }

    public void testDeclareSoft() {
        check("aspect A {pointcut a();declare soft: Exception+: a();}", "(compilationUnit(aspect(simpleName)(pointcut(simpleName))(declareSoft(referencePointcut(simpleName))(defaultTypePattern))))");
    }

    public void testDeclarePrecedence() {
        check("aspect A{}aspect B{declare precedence: B,A;}", "(compilationUnit(aspect(simpleName))(aspect(simpleName)(declarePrecedence(defaultTypePattern)(defaultTypePattern))))");
    }

    public void testDeclareAnnotationType() {
        checkJLS3("@interface MyAnnotation{}class C{}aspect A{declare @type: C : @MyAnnotation;}", "(compilationUnit(simpleName)(class(simpleName))(aspect(simpleName)(declareAtType(defaultTypePattern)(simpleName))))");
    }

    public void testDeclareAnnotationMethod() {
        checkJLS3("@interface MyAnnotation{}class C{}aspect A{declare @method:public * C.*(..) : @MyAnnotation;}", "(compilationUnit(simpleName)(class(simpleName))(aspect(simpleName)(declareAtMethod(signaturePattern)(simpleName))))");
    }

    public void testDeclareAnnotationField() {
        checkJLS3("@interface MyAnnotation{}class C{}aspect A{declare @field: * C+.* : @MyAnnotation;}", "(compilationUnit(simpleName)(class(simpleName))(aspect(simpleName)(declareAtField(signaturePattern)(simpleName))))");
    }

    public void testDeclareAnnotationConstructor() {
        checkJLS3("@interface MyAnnotation{}class C{}aspect A{declare @constructor: C+.new(..) : @MyAnnotation;}", "(compilationUnit(simpleName)(class(simpleName))(aspect(simpleName)(declareAtConstructor(signaturePattern)(simpleName))))");
    }

    public void testPerThis() {
        check("aspect A perthis(a()) {pointcut a();}", "(compilationUnit(aspect(simpleName)(perObject(referencePointcut(simpleName)))(pointcut(simpleName)))))");
    }

    public void testPerTarget() {
        check("aspect A pertarget(a()) {pointcut a();}", "(compilationUnit(aspect(simpleName)(perObject(referencePointcut(simpleName)))(pointcut(simpleName)))))");
    }

    public void testPerCFlow() {
        check("aspect A percflow(a()) {pointcut a();}", "(compilationUnit(aspect(simpleName)(perCflow(referencePointcut(simpleName)))(pointcut(simpleName)))))");
    }

    public void testPerCFlowBelow() {
        check("aspect A percflowbelow(a()) {pointcut a();}", "(compilationUnit(aspect(simpleName)(perCflow(referencePointcut(simpleName)))(pointcut(simpleName)))))");
    }

    private void check(String source, String expectedOutput) {
        // ajh02: need to use 2 for returnType - in 3 it has "returnType2"
        ASTParser parser = ASTParser.newParser(AST.JLS2);
        //JavaCore.getOptions());
        parser.setCompilerOptions(new HashMap());
        parser.setSource(source.toCharArray());
        CompilationUnit cu2 = (CompilationUnit) parser.createAST(null);
        TestVisitor visitor = new TestVisitor();
        cu2.accept(visitor);
        String result = visitor.toString();
        System.err.println("actual:\n" + result);
        assertTrue("Expected:\n" + expectedOutput + "====Actual:\n" + result, expectedOutput.equals(result));
    }

    private void checkJLS3(String source, String expectedOutput) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setCompilerOptions(new HashMap());
        parser.setSource(source.toCharArray());
        CompilationUnit cu2 = (CompilationUnit) parser.createAST(null);
        TestVisitor visitor = new TestVisitor();
        cu2.accept(visitor);
        String result = visitor.toString();
        System.err.println("actual:\n" + result);
        assertTrue("Expected:\n" + expectedOutput + "====Actual:\n" + result, expectedOutput.equals(result));
    }

    /** @deprecated using deprecated code */
    private static final int AST_INTERNAL_JLS2 = AST.JLS2;

    /**
	 * @deprecated (not really - just suppressing the warnings
	 * that come from testing Javadoc.getComment())
	 *
	 */
    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    protected CompilationUnit createAST(char[] source) {
        ASTParser parser = ASTParser.newParser(AST_INTERNAL_JLS2);
        parser.setSource(source);
        parser.setResolveBindings(false);
        return (CompilationUnit) parser.createAST(null);
    }
}

class TestVisitor extends AjASTVisitor {

    StringBuffer b = new StringBuffer();

    boolean visitTheKids = true;

    boolean visitDocTags;

     TestVisitor() {
        this(false);
    }

    public String toString() {
        return b.toString();
    }

     TestVisitor(boolean visitDocTags) {
        super(visitDocTags);
        this.visitDocTags = visitDocTags;
    }

    public boolean isVisitingChildren() {
        return visitTheKids;
    }

    public void setVisitingChildren(boolean visitChildren) {
        visitTheKids = visitChildren;
    }

    public boolean visit(TypeDeclaration node) {
        if (((AjTypeDeclaration) node).isAspect()) {
            if (((AspectDeclaration) node).isPrivileged()) {
                b.append("(privileged");
            }
            //$NON-NLS-1$
            b.append("(aspect");
        //			if (((AspectDeclaration)node).getPerClause() != null){
        //				b.append("{" + ((AspectDeclaration)node).getPerClause() + "}");
        //			}
        } else if (node.isInterface()) {
            // $NON-NLS-1$
            b.append("(interface");
        } else {
            //$NON-NLS-1$
            b.append("(class");
        }
        return isVisitingChildren();
    }

    public void endVisit(TypeDeclaration node) {
        if (((AjTypeDeclaration) node).isAspect())
            if (((AspectDeclaration) node).isPrivileged() || ((AspectDeclaration) node).getPerClause() != null) {
                b.append(")");
            }
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(PointcutDeclaration node) {
        //$NON-NLS-1$
        b.append("(pointcut");
        return isVisitingChildren();
    }

    public void endVisit(PointcutDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(ReferencePointcut node) {
        //$NON-NLS-1$
        b.append("(referencePointcut");
        return isVisitingChildren();
    }

    public void endVisit(ReferencePointcut node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(BeforeAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append("(beforeAdvice");
        return isVisitingChildren();
    }

    public boolean visit(AroundAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append("(aroundAdvice");
        return isVisitingChildren();
    }

    public boolean visit(AfterAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append("(afterAdvice");
        return isVisitingChildren();
    }

    public boolean visit(AfterThrowingAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append("(afterThrowingAdvice");
        return isVisitingChildren();
    }

    public boolean visit(AfterReturningAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append("(afterReturningAdvice");
        return isVisitingChildren();
    }

    public void endVisit(BeforeAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(AroundAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(AfterAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(AfterThrowingAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(AfterReturningAdviceDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(MethodDeclaration node) {
        if (node instanceof InterTypeMethodDeclaration)
            return visit((InterTypeMethodDeclaration) node);
        if (node.isConstructor()) {
            b.append("(constructor");
        } else {
            //$NON-NLS-1$
            b.append("(method");
        }
        return isVisitingChildren();
    }

    public void endVisit(MethodDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(InterTypeFieldDeclaration node) {
        //$NON-NLS-1$
        b.append("(fieldITD");
        return isVisitingChildren();
    }

    public void endVisit(InterTypeFieldDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(InterTypeMethodDeclaration node) {
        if (node.isConstructor()) {
            b.append("(constructorITD");
        } else {
            //$NON-NLS-1$
            b.append("(methodITD");
        }
        return isVisitingChildren();
    }

    public void endVisit(InterTypeMethodDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(MethodInvocation node) {
        //$NON-NLS-1$
        b.append("(methodInvocation");
        return isVisitingChildren();
    }

    public void endVisit(MethodInvocation node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(BodyDeclaration node) {
        //$NON-NLS-1$
        b.append("(methodInvocation");
        return isVisitingChildren();
    }

    public void endVisit(BodyDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(FieldDeclaration node) {
        //$NON-NLS-1$
        b.append("(field");
        return isVisitingChildren();
    }

    public void endVisit(FieldDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(FieldAccess node) {
        //$NON-NLS-1$
        b.append("(fieldAccess");
        return isVisitingChildren();
    }

    public void endVisit(FieldAccess node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(Assignment node) {
        //$NON-NLS-1$
        b.append("(assignment");
        return isVisitingChildren();
    }

    public void endVisit(Assignment node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(Block node) {
        //$NON-NLS-1$
        b.append("(block");
        return isVisitingChildren();
    }

    public void endVisit(Block node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(CompilationUnit node) {
        //$NON-NLS-1$
        b.append("(compilationUnit");
        return isVisitingChildren();
    }

    public void endVisit(CompilationUnit node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(ExpressionStatement node) {
        //$NON-NLS-1$
        b.append("(expressionStatement");
        return isVisitingChildren();
    }

    public void endVisit(ExpressionStatement node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(InfixExpression node) {
        //$NON-NLS-1$
        b.append("(infixExpression");
        return isVisitingChildren();
    }

    public void endVisit(InfixExpression node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(Initializer node) {
        //$NON-NLS-1$
        b.append("(initializer");
        return isVisitingChildren();
    }

    public void endVisit(Initializer node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(NumberLiteral node) {
        //$NON-NLS-1$
        b.append("(numberLiteral");
        return isVisitingChildren();
    }

    public void endVisit(NumberLiteral node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(PrimitiveType node) {
        //$NON-NLS-1$
        b.append("(primitiveType");
        return isVisitingChildren();
    }

    public void endVisit(PrimitiveType node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(QualifiedName node) {
        //$NON-NLS-1$
        b.append("(qualifiedName");
        return isVisitingChildren();
    }

    public void endVisit(QualifiedName node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(SimpleName node) {
        //$NON-NLS-1$
        b.append("(simpleName");
        return isVisitingChildren();
    }

    public void endVisit(SimpleName node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(StringLiteral node) {
        //$NON-NLS-1$
        b.append("(stringLiteral");
        return isVisitingChildren();
    }

    public void endVisit(StringLiteral node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(VariableDeclaration node) {
        //$NON-NLS-1$
        b.append("(variableDeclaration");
        return isVisitingChildren();
    }

    public boolean visit(BlockComment bc) {
        b.append("(blockcomment");
        return isVisitingChildren();
    }

    public void endVisit(BlockComment bc) {
        b.append(")");
    }

    public void endVisit(VariableDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(VariableDeclarationStatement node) {
        //$NON-NLS-1$
        b.append("(variableDeclarationStatement");
        return isVisitingChildren();
    }

    public void endVisit(VariableDeclarationStatement node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(DeclareAtTypeDeclaration node) {
        b.append("(declareAtType");
        return isVisitingChildren();
    }

    public boolean visit(DeclareAtMethodDeclaration node) {
        b.append("(declareAtMethod");
        return isVisitingChildren();
    }

    public boolean visit(DeclareAtConstructorDeclaration node) {
        b.append("(declareAtConstructor");
        return isVisitingChildren();
    }

    public boolean visit(DeclareAtFieldDeclaration node) {
        b.append("(declareAtField");
        return isVisitingChildren();
    }

    public boolean visit(DeclareErrorDeclaration node) {
        b.append("(declareError");
        return isVisitingChildren();
    }

    public boolean visit(DeclareParentsDeclaration node) {
        b.append("(declareParents");
        return isVisitingChildren();
    }

    public boolean visit(DeclarePrecedenceDeclaration node) {
        b.append("(declarePrecedence");
        return isVisitingChildren();
    }

    public boolean visit(DeclareSoftDeclaration node) {
        b.append("(declareSoft");
        return isVisitingChildren();
    }

    public boolean visit(DeclareWarningDeclaration node) {
        b.append("(declareWarning");
        return isVisitingChildren();
    }

    public void endVisit(DeclareErrorDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(DeclareParentsDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(DeclarePrecedenceDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(DeclareAtFieldDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(DeclareAtMethodDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(DeclareAtTypeDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(DeclareAtConstructorDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(DeclareSoftDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(DeclareWarningDeclaration node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(DefaultTypePattern node) {
        b.append("(defaultTypePattern");
        return isVisitingChildren();
    }

    public void endVisit(DefaultTypePattern node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(SignaturePattern node) {
        b.append("(signaturePattern");
        return isVisitingChildren();
    }

    public void endVisit(SignaturePattern node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public boolean visit(PerObject node) {
        b.append("(perObject");
        return isVisitingChildren();
    }

    public boolean visit(PerCflow node) {
        b.append("(perCflow");
        return isVisitingChildren();
    }

    public boolean visit(PerTypeWithin node) {
        b.append("(perTypeWithin");
        return isVisitingChildren();
    }

    public void endVisit(PerObject node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(PerCflow node) {
        //$NON-NLS-1$
        b.append(")");
    }

    public void endVisit(PerTypeWithin node) {
        //$NON-NLS-1$
        b.append(")");
    }
}
