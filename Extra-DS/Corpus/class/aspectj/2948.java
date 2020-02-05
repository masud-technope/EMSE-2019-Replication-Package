package ca.ubc.cs.spl.aspectPatterns.examples.proxy.java;

public class OutputImplementation implements OutputSubject {

    /**
	 * A type of <i>request(..)</i>. Prints the argument string to 
	 * <code>System.out</code>
	 *
	 * @param s the string to print
	 */
    public void safeRequest(String s) {
        System.out.println("[RealSubject.safeRequest()]: " + s);
    }

    /**
	 * A type of <i>request(..)</i>.
	 * <code>System.out</code>
	 *
	 * @param s the string to print
	 */
    public void regularRequest(String s) {
        System.out.println("[RealSubject.regularRequest()]: " + s);
    }

    /**
	 * A type of <i>request(..)</i>.
	 *
	 * @param s the string to print
	 */
    public void unsafeRequest(String s) {
        System.out.println("[RealSubject.unsafeRequest()]: " + s);
    }
}
