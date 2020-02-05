package org.aspectj.apache.bcel.verifier;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/**
 * This class produces instances of the Verifier class. Its purpose is to make
 * sure that they are singleton instances with respect to the class name they
 * operate on. That means, for every class (represented by a unique fully qualified
 * class name) there is exactly one Verifier.
 *
 * @version $Id: VerifierFactory.java,v 1.4 2005/02/02 09:11:39 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 * @see org.aspectj.apache.bcel.verifier.Verifier
 */
public class VerifierFactory {

    /**
	 * The HashMap that holds the data about the already-constructed Verifier instances.
	 */
    private static HashMap hashMap = new HashMap();

    /**
	 * The VerifierFactoryObserver instances that observe the VerifierFactory.
	 */
    private static Vector observers = new Vector();

    /**
	 * The VerifierFactory is not instantiable.
	 */
    private  VerifierFactory() {
    }

    /**
	 * Returns the (only) verifier responsible for the class with the given name.
	 * Possibly a new Verifier object is transparently created.
	 * @return the (only) verifier responsible for the class with the given name.
	 */
    public static Verifier getVerifier(String fully_qualified_classname) {
        // fully_qualified_classname = fully_qualified_classname;
        Verifier v = (Verifier) (hashMap.get(fully_qualified_classname));
        if (v == null) {
            v = new Verifier(fully_qualified_classname);
            hashMap.put(fully_qualified_classname, v);
            notify(fully_qualified_classname);
        }
        return v;
    }

    /**
	 * Notifies the observers of a newly generated Verifier.
	 */
    private static void notify(String fully_qualified_classname) {
        // notify the observers
        Iterator i = observers.iterator();
        while (i.hasNext()) {
            VerifierFactoryObserver vfo = (VerifierFactoryObserver) i.next();
            vfo.update(fully_qualified_classname);
        }
    }

    /**
	 * Returns all Verifier instances created so far.
	 * This is useful when a Verifier recursively lets
	 * the VerifierFactory create other Verifier instances
	 * and if you want to verify the transitive hull of
	 * referenced class files.
	 */
    public static Verifier[] getVerifiers() {
        Verifier[] vs = new Verifier[hashMap.values().size()];
        // Because vs is big enough, vs is used to store the values into and returned!
        return (Verifier[]) (hashMap.values().toArray(vs));
    }

    /**
	 * Adds the VerifierFactoryObserver o to the list of observers.
	 */
    public static void attach(VerifierFactoryObserver o) {
        observers.addElement(o);
    }

    /**
	 * Removes the VerifierFactoryObserver o from the list of observers.
	 */
    public static void detach(VerifierFactoryObserver o) {
        observers.removeElement(o);
    }
}
