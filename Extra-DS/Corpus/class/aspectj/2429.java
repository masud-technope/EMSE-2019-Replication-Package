package org.aspectj.apache.bcel.verifier;

import org.aspectj.apache.bcel.Repository;
import org.aspectj.apache.bcel.classfile.JavaClass;

/**
 * This class has a main method implementing a demonstration program
 * of how to use the VerifierFactoryObserver. It transitively verifies
 * all class files encountered; this may take up a lot of time and,
 * more notably, memory.
 *
 * @version $Id: TransitiveHull.java,v 1.4 2004/11/22 08:31:27 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class TransitiveHull implements VerifierFactoryObserver {

    /** Used for indentation. */
    private int indent = 0;

    /** Not publicly instantiable. */
    private  TransitiveHull() {
    }

    /* Implementing VerifierFactoryObserver. */
    public void update(String classname) {
        // avoid swapping if possible.
        System.gc();
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println(classname);
        indent += 1;
        Verifier v = VerifierFactory.getVerifier(classname);
        VerificationResult vr;
        vr = v.doPass1();
        if (//System.exit(1);
        vr != VerificationResult.VR_OK)
            System.out.println("Pass 1:\n" + vr);
        vr = v.doPass2();
        if (//System.exit(1);
        vr != VerificationResult.VR_OK)
            System.out.println("Pass 2:\n" + vr);
        if (vr == VerificationResult.VR_OK) {
            JavaClass jc = Repository.lookupClass(v.getClassName());
            for (int i = 0; i < jc.getMethods().length; i++) {
                vr = v.doPass3a(i);
                if (//System.exit(1);
                vr != VerificationResult.VR_OK)
                    System.out.println(v.getClassName() + ", Pass 3a, method " + i + " ['" + jc.getMethods()[i] + "']:\n" + vr);
                vr = v.doPass3b(i);
                if (//System.exit(1);
                vr != VerificationResult.VR_OK)
                    System.out.println(v.getClassName() + ", Pass 3b, method " + i + " ['" + jc.getMethods()[i] + "']:\n" + vr);
            }
        }
        indent -= 1;
    }

    /**
	 * This method implements a demonstration program
	 * of how to use the VerifierFactoryObserver. It transitively verifies
	 * all class files encountered; this may take up a lot of time and,
	 * more notably, memory.
	 */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Need exactly one argument: The root class to verify.");
            System.exit(1);
        }
        int dotclasspos = args[0].lastIndexOf(".class");
        if (dotclasspos != -1)
            args[0] = args[0].substring(0, dotclasspos);
        args[0] = args[0].replace('/', '.');
        TransitiveHull th = new TransitiveHull();
        VerifierFactory.attach(th);
        // the observer is called back and does the actual trick.
        VerifierFactory.getVerifier(args[0]);
        VerifierFactory.detach(th);
    }
}
