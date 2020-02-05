package org.aspectj.apache.bcel.verifier.exc;

/**
 * When loading a class file, BCEL will throw an instance of LoadingException if
 * the class file is malformed; so it is not conforming to the "Pass 1" verification
 * process as described in the Java Virtual Machine specification, 2nd. edition.
 * @version $Id: LoadingException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class LoadingException extends VerifierConstraintViolatedException {

    /**
	 * Constructs a new LoadingException with null as its error message string.
	 */
    public  LoadingException() {
        super();
    }

    /**
	 * Constructs a new LoadingException with the specified error message.
	 */
    public  LoadingException(String message) {
        super(message);
    }
}
