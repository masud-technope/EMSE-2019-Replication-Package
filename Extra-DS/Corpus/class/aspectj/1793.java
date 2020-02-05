/* *******************************************************************
 * Copyright (c) 1999-2001 Xerox Corporation, 
 *               2002 Palo Alto Research Center, Incorporated (PARC).
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Common Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html 
 *  
 * Contributors: 
 *     Xerox/PARC     initial implementation 
 * ******************************************************************/
package org.aspectj.runtime.internal;

import java.util.Stack;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.runtime.CFlow;
import org.aspectj.runtime.internal.cflowstack.ThreadStack;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactory;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;

public class CFlowStack {

    private static ThreadStackFactory tsFactory;

    private ThreadStack stackProxy;

    static {
        selectFactoryForVMVersion();
    }

    public  CFlowStack() {
        stackProxy = tsFactory.getNewThreadStack();
    }

    private Stack getThreadStack() {
        return stackProxy.getThreadStack();
    }

    //XXX dangerous, try to remove
    public void push(Object obj) {
        getThreadStack().push(obj);
    }

    public void pushInstance(Object obj) {
        getThreadStack().push(new CFlow(obj));
    }

    public void push(Object[] obj) {
        getThreadStack().push(new CFlowPlusState(obj));
    }

    public void pop() {
        getThreadStack().pop();
    }

    public Object peek() {
        Stack stack = getThreadStack();
        if (stack.isEmpty())
            throw new org.aspectj.lang.NoAspectBoundException();
        return (Object) stack.peek();
    }

    public Object get(int index) {
        CFlow cf = peekCFlow();
        return (null == cf ? null : cf.get(index));
    }

    public Object peekInstance() {
        CFlow cf = peekCFlow();
        if (cf != null)
            return cf.getAspect();
        else
            throw new NoAspectBoundException();
    }

    public CFlow peekCFlow() {
        Stack stack = getThreadStack();
        if (stack.isEmpty())
            return null;
        return (CFlow) stack.peek();
    }

    public CFlow peekTopCFlow() {
        Stack stack = getThreadStack();
        if (stack.isEmpty())
            return null;
        return (CFlow) stack.elementAt(0);
    }

    public boolean isValid() {
        return !getThreadStack().isEmpty();
    }

    private static ThreadStackFactory getThreadLocalStackFactory() {
        return new ThreadStackFactoryImpl();
    }

    private static ThreadStackFactory getThreadLocalStackFactoryFor11() {
        return new ThreadStackFactoryImpl11();
    }

    private static void selectFactoryForVMVersion() {
        String override = getSystemPropertyWithoutSecurityException("aspectj.runtime.cflowstack.usethreadlocal", "unspecified");
        boolean useThreadLocalImplementation = false;
        if (override.equals("unspecified")) {
            String v = System.getProperty("java.class.version", "0.0");
            // Java 1.2 is version 46.0 and above
            useThreadLocalImplementation = (v.compareTo("46.0") >= 0);
        } else {
            useThreadLocalImplementation = override.equals("yes") || override.equals("true");
        }
        // System.err.println("Trying to use thread local implementation? "+useThreadLocalImplementation);
        if (useThreadLocalImplementation) {
            tsFactory = getThreadLocalStackFactory();
        } else {
            tsFactory = getThreadLocalStackFactoryFor11();
        }
    }

    private static String getSystemPropertyWithoutSecurityException(String aPropertyName, String aDefaultValue) {
        try {
            return System.getProperty(aPropertyName, aDefaultValue);
        } catch (SecurityException ex) {
            return aDefaultValue;
        }
    }

    //  For debug ...
    public static String getThreadStackFactoryClassName() {
        return tsFactory.getClass().getName();
    }
}
