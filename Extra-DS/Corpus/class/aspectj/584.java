package ca.ubc.cs.spl.aspectPatterns.examples.adapter.aspectj;

public class Main {

    /**
     * the Adaptee in the scenario. Note that our adaptee can be used as a 
     * Writer because of the <code>declare parents</code> statement in the 
     * aspect.
     */
    private static Writer adaptee;

    /**
	 * Implements the driver. 
	 * 
	 * In this implementation, the <i>Adaptee</i> becomes its own
	 * <i>Adapter</i>, so only one variable is needed.
	 * 
	 * @param args required for a main method, but ignored
	 */
    public static void main(String[] args) {
        System.out.println("Creating Adaptee (which is its own Adapter)...");
        adaptee = new SystemOutPrinter();
        System.out.print("Adapter and Adaptee are the same object: ");
        System.out.println(adaptee == adaptee);
        System.out.println("Issuing the request() to the Adapter...");
        adaptee.write("Test successful.");
    }
}
