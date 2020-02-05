package ca.ubc.cs.spl.aspectPatterns.examples.adapter.java;

public class Main {

    /**
     * the Target in the scenario
     */
    private static Writer myTarget;

    /**
     * the Adaptee in the scenario
     */
    private static SystemOutPrinter adaptee;

    /**
     * Implements the driver.  
     * 
     * @param args required for a main method, but ignored
     */
    public static void main(String[] args) {
        System.out.println("Creating the Adaptee...");
        adaptee = new SystemOutPrinter();
        System.out.println("Creating the Adapter...");
        myTarget = new PrinterAdapter(adaptee);
        System.out.print("Adapter and Adaptee are the same object: ");
        System.out.println(myTarget.equals(adaptee));
        System.out.println("Issuing the request() to the Adapter...");
        myTarget.write("Test successful.");
    }
}
