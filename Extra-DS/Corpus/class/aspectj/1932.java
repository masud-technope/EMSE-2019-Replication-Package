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
package org.aspectj.weaver.bcel;

import org.aspectj.apache.bcel.generic.InstructionHandle;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.weaver.UnresolvedType;

/* we're actually using the fact that we're an instruction targeter, for the
 * handler */
public final class ExceptionRange extends Range {

    private InstructionHandle handler;

    private final UnresolvedType exceptionType;

    private final int priority;

    /**
	 * After this constructor is called, this range is not well situated unless 
	 * {@link #associateWithTargets} is called
	 * 
	 * XXX priority should be fixed
	 */
    public  ExceptionRange(InstructionList body, UnresolvedType exceptionType, int priority) {
        super(body);
        this.exceptionType = exceptionType;
        this.priority = priority;
    }

    /**
	 * @param insideExisting 
	 */
    public  ExceptionRange(InstructionList body, UnresolvedType exceptionType, boolean insideExisting) {
        this(body, exceptionType, insideExisting ? Integer.MAX_VALUE : -1);
    }

    public void associateWithTargets(InstructionHandle start, InstructionHandle end, InstructionHandle handler) {
        // assert body.contains(start) && body.contains(end) && body.contains(handler)
        this.start = start;
        this.end = end;
        this.handler = handler;
        start.addTargeter(this);
        end.addTargeter(this);
        handler.addTargeter(this);
    }

    // ---- 
    public InstructionHandle getHandler() {
        return handler;
    }

    public UnresolvedType getCatchType() {
        return exceptionType;
    }

    public int getPriority() {
        return priority;
    }

    // ---- from object
    public String toString() {
        String str;
        if (exceptionType == null) {
            str = "finally";
        } else {
            str = "catch " + exceptionType;
        }
        //        }
        return str;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ExceptionRange))
            return false;
        ExceptionRange o = (ExceptionRange) other;
        return o.getStart() == getStart() && o.getEnd() == getEnd() && o.handler == handler && ((o.exceptionType == null) ? (exceptionType == null) : o.exceptionType.equals(exceptionType)) && o.priority == priority;
    }

    private volatile int hashCode = 0;

    public int hashCode() {
        if (hashCode == 0) {
            int ret = 17;
            ret = 37 * ret + getStart().hashCode();
            ret = 37 * ret + getEnd().hashCode();
            ret = 37 * ret + handler.hashCode();
            ret = 37 * ret + ((exceptionType == null) ? 0 : exceptionType.hashCode());
            ret = 37 * ret + priority;
            hashCode = ret;
        }
        return hashCode;
    }

    public void updateTarget(InstructionHandle oldIh, InstructionHandle newIh, InstructionList newBody) {
        super.updateTarget(oldIh, newIh, newBody);
        // we're guaranteed that start, end, and handler are distinct instruction handles.
        if (oldIh == handler) {
            handler = newIh;
        }
    }

    public static boolean isExceptionStart(InstructionHandle ih) {
        if (!isRangeHandle(ih))
            return false;
        Range r = getRange(ih);
        if (!(r instanceof ExceptionRange))
            return false;
        ExceptionRange er = (ExceptionRange) r;
        return er.getStart() == ih;
    }

    public static boolean isExceptionEnd(InstructionHandle ih) {
        if (!isRangeHandle(ih))
            return false;
        Range r = getRange(ih);
        if (!(r instanceof ExceptionRange))
            return false;
        ExceptionRange er = (ExceptionRange) r;
        return er.getEnd() == ih;
    }
}
