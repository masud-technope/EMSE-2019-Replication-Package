package ca.ubc.cs.spl.aspectPatterns.examples.proxy.java;

public interface OutputSubject {

    /**
     * A type of <i>request(..)</i>.
     *
     * @param s the string to print
     */
    public void safeRequest(String s);

    /**
     * A type of <i>request(..)</i>.
     *
     * @param s the string to print
     */
    public void regularRequest(String s);

    /**
     * A type of <i>request(..)</i>.
	 *
	 * @param s the string to print
	 */
    public void unsafeRequest(String s);
}
