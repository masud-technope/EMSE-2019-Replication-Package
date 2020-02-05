package ca.ubc.cs.spl.aspectPatterns.examples.adapter.java;

public class PrinterAdapter implements Writer {

    /**
     * the adaptee to forward appropriate messages to.
     */
    private SystemOutPrinter adaptee = null;

    public  PrinterAdapter(SystemOutPrinter adaptee) {
        this.adaptee = adaptee;
    }

    /**
	 * Implements the <i>Target</i> interface. This is where the actual
	 * adaption happens: calls to write(String) trigger calls
	 * to printToSystemOut(String) on the adaptee.
     *
     * @param s the string to print
     * @see Writer#write(String)
     * @see SystemOutPrinter#printToSystemOut(String)
	 */
    public void write(String s) {
        adaptee.printToSystemOut(s);
    }
}
