package ca.ubc.cs.spl.aspectPatterns.examples.flyweight.java;

public class Main {

    /**
     * Implements the driver for the Flyweight design pattern example.<p> 
     *
     * This example creates a sentence out of <code>PrintableFlyweight</i>s
     * (characters and whitespaces). 
     */
    public static void main(String[] args) {
        System.out.println("This is a test for the java Flyweight pattern " + "implementation.");
        System.out.println("The client will use char flyweights to print the " + "phrase");
        System.out.println("\"This Is A Test\".\n");
        System.out.println("Testing Pattern: Flyweight - STARTING\n");
        PrintableFlyweightFactory pff = new PrintableFlyweightFactory();
        PrintableFlyweight T = pff.getPrintableFlyweight('t');
        PrintableFlyweight H = pff.getPrintableFlyweight('h');
        PrintableFlyweight I = pff.getPrintableFlyweight('i');
        PrintableFlyweight S = pff.getPrintableFlyweight('s');
        PrintableFlyweight A = pff.getPrintableFlyweight('a');
        PrintableFlyweight E = pff.getPrintableFlyweight('e');
        PrintableFlyweight Empty = pff.getPrintableFlyweight(' ');
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
