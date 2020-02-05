package ca.ubc.cs.spl.aspectPatterns.examples.proxy.java;

public class RequestBlocker implements OutputSubject {

    /**
     * a reference to the <i>Subject</i> (used to forward requests to)
     */
    private OutputSubject realSubject;

    public  RequestBlocker(OutputSubject subject) {
        this.realSubject = subject;
    }

    /**
	 * Forwards the request to its subject. We are not interested in
	 * this kind of request, but must implement the method (and the 
	 * request forwarding) anyway since the method is part of the 
	 * <code>RequestBlocker</code> interface.
     *
     * @param s the string to print
     */
    public void safeRequest(String s) {
        realSubject.safeRequest(s);
        System.out.println("[RequestBlocker:] Not interested in safe requests," + " but must implement anyway");
    }

    /**
	 * Forwards the request to its subject. We are not interested in
	 * this kind of request, but must implement the method (and the 
	 * request forwarding) anyway since the method is part of the 
	 * <code>RequestBlocker</code> interface.
	 *
	 * @param s the string to print
	 */
    public void regularRequest(String s) {
        realSubject.regularRequest(s);
        System.out.println("[RequestBlocker:] Not interested in regular requests," + " but must implement anyway");
    }

    /**
	 * Blocks unsafe requests.
	 *
	 * @param s the string to print
	 */
    public void unsafeRequest(String s) {
        realSubject.unsafeRequest(s);
        System.out.println("[RequestBlocker:] " + s + " blocked.");
    }
}
