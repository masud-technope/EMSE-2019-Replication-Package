package org.aspectj.apache.bcel.verifier.exc;

/**
 * A LocalVariableInfoInconsistentException instance is thrown by
 * the LocalVariableInfo class when it detects that the information
 * it holds is inconsistent; this is normally due to inconsistent
 * LocalVariableTable entries in the Code attribute of a certain
 * Method object.
 *
 * @version $Id: LocalVariableInfoInconsistentException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class LocalVariableInfoInconsistentException extends ClassConstraintException {

    /**
	 * Constructs a new LocalVariableInfoInconsistentException with null as its error message string.
	 */
    public  LocalVariableInfoInconsistentException() {
        super();
    }

    /**
	 * Constructs a new LocalVariableInfoInconsistentException with the specified error message.
	 */
    public  LocalVariableInfoInconsistentException(String message) {
        super(message);
    }
}
