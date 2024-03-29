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
 * ******************************************************************/
package org.aspectj.ajdt.internal.compiler.ast;

import org.aspectj.ajdt.internal.compiler.lookup.EclipseFactory;
import org.aspectj.ajdt.internal.compiler.lookup.EclipseSourceLocation;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.aspectj.org.eclipse.jdt.internal.compiler.ast.Expression;
import org.aspectj.org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.aspectj.org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.aspectj.org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.aspectj.org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

public class InterSuperFixerVisitor extends ASTVisitor {

    InterTypeDeclaration dec;

    ReferenceBinding onType;

    TypeBinding superType;

    // Keeps track of whether we are inside any nested local type declarations
    private int depthCounter = 0;

    EclipseFactory world;

    public  InterSuperFixerVisitor(InterTypeDeclaration dec, EclipseFactory world, Scope scope) {
        this.dec = dec;
        this.onType = dec.onTypeBinding;
        this.world = world;
        // not a parent interface (if one exists)
        if (onType.isInterface() && onType.superInterfaces().length == 1) {
            superType = onType.superInterfaces()[0];
        } else if (onType.superclass() != null) {
            superType = onType.superclass();
        } else if (onType.superInterfaces() == null || onType.superInterfaces().length == 0) {
            superType = scope.getJavaLangObject();
        } else if (onType.superInterfaces().length == 1) {
            superType = onType.superInterfaces()[0];
        } else {
            superType = null;
        }
    }

    public void endVisit(FieldReference ref, BlockScope scope) {
        ref.receiver = fixReceiver(ref.receiver, scope);
    }

    public void endVisit(MessageSend send, BlockScope scope) {
        send.receiver = fixReceiver(send.receiver, scope);
    }

    public boolean visit(TypeDeclaration localTypeDeclaration, BlockScope scope) {
        depthCounter++;
        return super.visit(localTypeDeclaration, scope);
    }

    public void endVisit(TypeDeclaration localTypeDeclaration, BlockScope scope) {
        depthCounter--;
    }

    private Expression fixReceiver(Expression expression, BlockScope scope) {
        // Don't mess with super calls down in nested local type declarations (pr90143)
        if (depthCounter != 0)
            return expression;
        if (expression instanceof SuperReference) {
            SuperReference superRef = (SuperReference) expression;
            if (superType == null) {
                ISourceLocation location = new EclipseSourceLocation(scope.problemReporter().referenceContext.compilationResult(), expression.sourceStart, expression.sourceEnd);
                world.showMessage(IMessage.ERROR, "multiple supertypes for this interface", location, null);
                dec.ignoreFurtherInvestigation = true;
            }
            //FIXME ??? note error
            expression = new InterSuperReference(superRef, superType);
        }
        return expression;
    }
}
