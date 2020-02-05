package org.aspectj.apache.bcel.verifier.exc;

/**
 * Instances of this class are thrown by BCEL's class file verifier "JustIce"
 * when a class file to verify does not pass the verification pass 2 as described
 * in the Java Virtual Machine specification, 2nd edition.
 *
 * @version $Id: ClassConstraintException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class ClassConstraintException extends VerificationException {

    /**
	 * Constructs a new ClassConstraintException with null as its error message string.
	 */
    public  ClassConstraintException() {
        super();
    }

    /**
	 * Constructs a new ClassConstraintException with the specified error message.
	 */
    public  ClassConstraintException(String message) {
        super(message);
    }
}
