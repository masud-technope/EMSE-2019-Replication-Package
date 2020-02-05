package org.aspectj.apache.bcel.verifier.exc;

/**
 * Instances of this class are thrown by BCEL's class file verifier "JustIce"
 * when the verification of a method is requested that does not exist.
 *
 * @version $Id: InvalidMethodException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class InvalidMethodException extends RuntimeException {

    /** Constructs an InvalidMethodException with the specified detail message. */
    public  InvalidMethodException(String message) {
        super(message);
    }
}
