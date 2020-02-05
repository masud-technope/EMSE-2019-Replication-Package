package ca.ubc.cs.spl.aspectPatterns.examples.flyweight.aspectj;

public class Main {

    /**
	 * Implements the driver for the Flyweight design pattern example.<p> 
	 *
	 * This example creates a sentence out of <code>PrintableFlyweight</i>s
	 * (characters and whitespaces). 
	 */
    public static void main(String[] args) {
        System.out.println("This is a test for the AspectJ version of the " + "Flyweight pattern implementation.");
        System.out.println("The client will use char flyweights to print " + "the phrase");
        System.out.println("\"This Is A Test\".\n");
        System.out.println("Testing Pattern: Flyweight - STARTING\n");
        PrintableFlyweight T = FlyweightImplementation.aspectOf().getPrintableFlyweight('t');
        PrintableFlyweight H = FlyweightImplementation.aspectOf().getPrintableFlyweight('h');
        PrintableFlyweight I = FlyweightImplementation.aspectOf().getPrintableFlyweight('i');
        PrintableFlyweight S = FlyweightImplementation.aspectOf().getPrintableFlyweight('s');
        PrintableFlyweight A = FlyweightImplementation.aspectOf().getPrintableFlyweight('a');
        PrintableFlyweight E = FlyweightImplementation.aspectOf().getPrintableFlyweight('e');
        PrintableFlyweight Empty = FlyweightImplementation.aspectOf().getPrintableFlyweight(' ');
        // Printing: "This Is A Test"
        T.print(true);
        H.print(false);
        I.print(false);
        S.print(false);
        Empty.print(true);
        I.print(true);
        S.print(false);
        Empty.print(true);
        A.print(true);
        Empty.print(true);
        T.print(true);
        E.print(false);
        S.print(false);
        T.print(false);
        System.out.println();
        System.out.println("\nTesting Pattern: State - FINISHED");
    }
}
