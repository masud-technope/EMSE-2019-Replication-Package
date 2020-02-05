package org.aspectj.apache.bcel.verifier;

/**
 * The NativeVerifier class implements a main(String[] args) method that's
 * roughly compatible to the one in the Verifier class, but that uses the
 * JVM's internal verifier for its class file verification.
 * This can be used for comparison runs between the JVM-internal verifier
 * and JustIce.
 *
 * @version $Id: NativeVerifier.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public abstract class NativeVerifier {

    /**
	 * This class must not be instantiated.
	 */
    private  NativeVerifier() {
    }

    /**
	 * Works only on the first argument.
	 */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Verifier front-end: need exactly one argument.");
            System.exit(1);
        }
        int dotclasspos = args[0].lastIndexOf(".class");
        if (dotclasspos != -1)
            args[0] = args[0].substring(0, dotclasspos);
        args[0] = args[0].replace('/', '.');
        try {
            Class.forName(args[0]);
        } catch (ExceptionInInitializerError //subclass of LinkageError!
        eiie) {
            System.out.println("NativeVerifier: ExceptionInInitializerError encountered on '" + args[0] + "'.");
            System.out.println(eiie);
            System.exit(1);
        } catch (LinkageError le) {
            System.out.println("NativeVerifier: LinkageError encountered on '" + args[0] + "'.");
            System.out.println(le);
            System.exit(1);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("NativeVerifier: FILE NOT FOUND: '" + args[0] + "'.");
            System.exit(1);
        } catch (Throwable t) {
            System.out.println("NativeVerifier: Unspecified verification error on'" + args[0] + "'.");
            System.exit(1);
        }
        System.out.println("NativeVerifier: Class file '" + args[0] + "' seems to be okay.");
        System.exit(0);
    }
}
