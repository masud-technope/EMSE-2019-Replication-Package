package org.aspectj.apache.bcel.verifier;

import java.util.ArrayList;

/**
 * A PassVerifier actually verifies a class file; it is instantiated
 * by a Verifier.
 * The verification should conform with a certain pass as described
 * in The Java Virtual Machine Specification, 2nd edition.
 * This book describes four passes. Pass one means loading the
 * class and verifying a few static constraints. Pass two actually
 * verifies some other constraints that could enforce loading in
 * referenced class files. Pass three is the first pass that actually
 * checks constraints in the code array of a method in the class file;
 * it has two parts with the first verifying static constraints and
 * the second part verifying structural constraints (where a data flow
 * analysis is used for). The fourth pass, finally, performs checks
 * that can only be done at run-time.
 * JustIce does not have a run-time pass, but certain constraints that
 * are usually delayed until run-time for performance reasons are also
 * checked during the second part of pass three.
 * PassVerifier instances perform caching.
 * That means, if you really want a new verification run of a certain
 * pass you must use a new instance of a given PassVerifier.
 *
 * @version $Id: PassVerifier.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 * @see org.aspectj.apache.bcel.verifier.Verifier
 * @see #verify()
 */
public abstract class PassVerifier {

    /** The (warning) messages. */
    //Type of elements: String
    private ArrayList messages = new ArrayList();

    /** The VerificationResult cache. */
    private VerificationResult verificationResult = null;

    /**
	 * This method runs a verification pass conforming to the
	 * Java Virtual Machine Specification, 2nd edition, on a
	 * class file.
	 * PassVerifier instances perform caching;
	 * i.e. if the verify() method once determined a VerificationResult,
	 * then this result may be returned after every invocation of this
	 * method instead of running the verification pass anew; likewise with
	 * the result of getMessages().
	 *
	 * @see #getMessages()
	 * @see #addMessage(String)
	 */
    public VerificationResult verify() {
        if (verificationResult == null) {
            verificationResult = do_verify();
        }
        return verificationResult;
    }

    /** Does the real verification work, uncached. */
    public abstract VerificationResult do_verify();

    /**
	 * This method adds a (warning) message to the message pool of this
	 * PassVerifier. This method is normally only internally used by
	 * BCEL's class file verifier "JustIce" and should not be used from
	 * the outside. 
	 *
	 * @see #getMessages()
	 */
    public void addMessage(String message) {
        messages.add(message);
    }

    /**
	 * Returns the (warning) messages that this PassVerifier accumulated
	 * during its do_verify()ing work.
	 *
	 * @see #addMessage(String)
	 * @see #do_verify()
	 */
    public String[] getMessages() {
        // create messages if not already done (cached!)
        verify();
        String[] ret = new String[messages.size()];
        for (int i = 0; i < messages.size(); i++) {
            ret[i] = (String) messages.get(i);
        }
        return ret;
    }
}
