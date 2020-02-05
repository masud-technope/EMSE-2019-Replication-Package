package org.aspectj.apache.bcel.verifier.exc;

/**
 * Instances of this class are thrown by BCEL's class file verifier "JustIce"
 * whenever
 * verification proves that some constraint of a class file (as stated in the
 * Java Virtual Machine Specification, Edition 2) is violated.
 * This is roughly equivalent to the VerifyError the JVM-internal verifiers
 * throw.
 *
 * @version $Id: VerifierConstraintViolatedException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public abstract class VerifierConstraintViolatedException extends RuntimeException {

    // /** The name of the offending class that did not pass the verifier. */
    // String name_of_offending_class;
    /** The specified error message. */
    private String detailMessage;

    /**
	 * Constructs a new VerifierConstraintViolatedException with null as its error message string.
	 */
     VerifierConstraintViolatedException() {
        super();
    }

    /**
	 * Constructs a new VerifierConstraintViolatedException with the specified error message.
	 */
     VerifierConstraintViolatedException(String message) {
        // Not that important
        super(message);
        detailMessage = message;
    }

    /** Extends the error message with a string before ("pre") and after ("post") the
	    'old' error message. All of these three strings are allowed to be null, and null
	    is always replaced by the empty string (""). In particular, after invoking this
	    method, the error message of this object can no longer be null.
	*/
    public void extendMessage(String pre, String post) {
        if (pre == null)
            pre = "";
        if (detailMessage == null)
            detailMessage = "";
        if (post == null)
            post = "";
        detailMessage = pre + detailMessage + post;
    }

    /**
	 * Returns the error message string of this VerifierConstraintViolatedException object.
	 * @return the error message string of this VerifierConstraintViolatedException.
	 */
    public String getMessage() {
        return detailMessage;
    }
}
