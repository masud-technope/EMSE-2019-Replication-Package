package org.aspectj.apache.bcel.verifier.exc;

/**
 * Instances of this class are thrown by BCEL's class file verifier "JustIce" when
 * a class file does not pass the verification pass 3. Note that the pass 3 used by
 * "JustIce" involves verification that is usually delayed to pass 4.
 *
 * @version $Id: CodeConstraintException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public abstract class CodeConstraintException extends VerificationException {

    /**
	 * Constructs a new CodeConstraintException with null as its error message string.
	 */
     CodeConstraintException() {
        super();
    }

    /**
	 * Constructs a new CodeConstraintException with the specified error message.
	 */
     CodeConstraintException(String message) {
        super(message);
    }
}
