package org.aspectj.apache.bcel.verifier.structurals;

import org.aspectj.apache.bcel.generic.*;

/**
 * This class represents an exception handler; that is, an ObjectType
 * representing a subclass of java.lang.Throwable and the instruction
 * the handler starts off (represented by an InstructionContext).
 * 
 * @version $Id: ExceptionHandler.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class ExceptionHandler {

    /** The type of the exception to catch. NULL means ANY. */
    private ObjectType catchtype;

    /** The InstructionHandle where the handling begins. */
    private InstructionHandle handlerpc;

    /** Leave instance creation to JustIce. */
     ExceptionHandler(ObjectType catch_type, InstructionHandle handler_pc) {
        catchtype = catch_type;
        handlerpc = handler_pc;
    }

    /**
	 * Returns the type of the exception that's handled. <B>'null' means 'ANY'.</B>
	 */
    public ObjectType getExceptionType() {
        return catchtype;
    }

    /**
	 * Returns the InstructionHandle where the handler starts off.
	 */
    public InstructionHandle getHandlerStart() {
        return handlerpc;
    }
}
