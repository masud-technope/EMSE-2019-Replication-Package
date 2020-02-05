package ca.ubc.cs.spl.aspectPatterns.examples.proxy.aspectj;

public class AlternateOutputImplementation {

    /**
	 * Prints the argument string to 
	 * <code>System.out</code>
	 *
	 * @param s the string to print
	 */
    public void alternateRequest(String s) {
        System.out.println("[AlternateSubject.safeRequest()]: " + s);
    }
}
