package ca.ubc.cs.spl.aspectPatterns.examples.adapter.java;

public interface Writer {

    /**
     * Prints the argument string. In the pattern context, this is the
     * <i>request()</i> method on the <i>Target</i>. 
     *
     * @param s the string to print
     * @see PrinterAdapter 
     */
    public void write(String s);
}
