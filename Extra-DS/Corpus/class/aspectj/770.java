package org.aspectj.apache.bcel.verifier;

/**
 * VerifierFactoryObserver instances are notified when new Verifier
 * instances are created.
 *
 * @version $Id: VerifierFactoryObserver.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 *
 * @see VerifierFactory#getVerifier(String)
 * @see VerifierFactory#getVerifiers()
 * @see VerifierFactory#attach(VerifierFactoryObserver)
 * @see VerifierFactory#detach(VerifierFactoryObserver)
 */
public interface VerifierFactoryObserver {

    /**
	 * VerifierFactoryObserver instances are notified invoking this method.
	 * The String argument is the fully qualified class name of a class a
	 * new Verifier instance created by the VerifierFactory operates on.
	 */
    public void update(String s);
}
