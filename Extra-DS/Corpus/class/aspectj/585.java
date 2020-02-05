package ca.ubc.cs.spl.aspectPatterns.examples.proxy.aspectj;

public class OutputImplementation {

    /**
	 * A type of <i>request(..)</i>. Prints the argument string to 
	 * <code>System.out</code>
	 *
	 * @param s the string to print
	 */
    public void safeRequest(String s) {
        System.out.println("[OutputImplementation.safeRequest()]: " + s);
    }

    /**
	 * A type of <i>request(..)</i>.
	 * <code>System.out</code>
	 *
	 * @param s the string to print
	 */
    public void regularRequest(String s) {
        System.out.println("[OutputImplementation.regularRequest()]: " + s);
    }

    /**
	 * A type of <i>request(..)</i>.
	 *
	 * @param s the string to print
	 */
    public void unsafeRequest(String s) {
        System.out.println("[OutputImplementation.unsafeRequest()]: " + s);
    }
}
