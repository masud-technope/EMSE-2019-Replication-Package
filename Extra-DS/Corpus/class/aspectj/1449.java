package ca.ubc.cs.spl.aspectPatterns.examples.facade.aspectj;

public class Main {

    /**
	 * Tests the higher-level interface of <code>OutputFacade</code>.
	 * 
	 * @param args Command-line parameters, ignored here
	 */
    public static void main(String[] args) {
        OutputFacade facade = new OutputFacade();
        System.out.println("Testing regular Facade access...");
        facade.printDecoration();
        facade.printNormal("Facade: this is normal printing");
        facade.printFancy("Facade: this is fancy  printing");
        System.out.println("\nCircumventing Facade encapsulation...");
        // Note that the compiler warning caused by the next line is 
        // intentional. See FacadePolicyEnforcement for details.
        RegularScreen.print("It works, but should create a compiler warning");
        System.out.println();
    }
}
