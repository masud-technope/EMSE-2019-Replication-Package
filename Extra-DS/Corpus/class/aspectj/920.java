package ca.ubc.cs.spl.aspectPatterns.examples.facade.java;

public class Main {

    /**
     * Tests the higher-level interface of <code>OutputFacade</code>.
     * 
     * @param args Command-line parameters, ignored here
     */
    public static void main(String[] args) {
        OutputFacade facade = new OutputFacade();
        System.out.println("Testing Facade...");
        facade.printDecoration();
        facade.printNormal("Facade: this is normal printing");
        facade.printFancy("Facade: this is fancy  printing");
    }
}
