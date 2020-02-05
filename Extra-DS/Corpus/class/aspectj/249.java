package ca.ubc.cs.spl.aspectPatterns.examples.singleton.aspectj;

public class Main {

    /**
     * the three object references to instances of the <i>Singleton</i> class.
     */
    private static Printer printer1, printer2, printer3;

    // Experimental setup: Main creates three Printer objects.
    // The Printer implementation gives each object a unique ID
    // which is printed when print() is called. If the Singleton
    // implementation works, all three objects should be the same.
    //  
    // Implementation: AOP5 - One (concrete) aspect defines the behavior
    // of the pattern, creating a generic getInstance() method that
    // is attached to the Singleton interface. Another aspect assigns
    // the role to a particular class.
    //
    // The general description of the pattern is reusable.
    //
    // Considers different signatures for the constructor.
    //
    // Clients don't have to type-cast, they just use new(..)
    //
    // Subclasses are automatically Singletons, too, unless 
    // explicitly declared as non-singletons
    /**
     * Implements the first test case. Creates 3 references to the 
     * <i>Singleton</i> by using the regular constructor. That should
     * create three identical objects.
     */
    private static void test1() {
        System.out.println("\nTest 1: All three printers should have the " + "same ID");
        printer1 = new Printer();
        printer2 = new Printer();
        printer3 = new Printer();
        printer1.print();
        printer2.print();
        printer3.print();
    }

    /**
     * Implements the second test case. Tests if the 3 objects from test 1 are
     * in fact identical
     */
    private static void test2() {
        System.out.println("\nTest 2: All three objects should be identical");
        System.out.print("\tThey are ");
        if ((printer1 == printer2) && (printer1 == printer3)) {
            System.out.println("identical");
        } else {
            System.out.println("not identical");
        }
    }

    /**
     * Implements the third test case. Creates 3 instances of the <i>Singleton
     * </i>'s subclass. These objects should be different.
     */
    private static void test3() {
        System.out.println("\nTest 3: Ensuring that subclasses can access the" + "constructor");
        System.out.println("        (All three outputs should be different)");
        printer1 = new PrinterSubclass();
        printer2 = new PrinterSubclass();
        printer3 = new PrinterSubclass();
        printer1.print();
        printer2.print();
        printer3.print();
    }

    /**
     * This is the driver for the <code>Singleton</code> case. It performes
     * three tests:
     *
     * <OL>
     *  <LI> Creates 3 references to the <i>Singleton</i> by using the
     *       regular constructor. That should create three identical objects.
     *  <LI> Tests if the above 3 objects are in fact identical
     *  <LI> Creates 3 instances of a <i>Singleton</i>'s subclass. These
     *       objects should be different.
     * </OL>
     */
    public static void main(String[] args) {
        System.out.println("Testing SINGLETON pattern (aspectj) ...");
        test1();
        test2();
        test3();
        System.out.println("\n... done.");
    }
}
