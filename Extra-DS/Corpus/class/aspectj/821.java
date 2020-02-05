package ca.ubc.cs.spl.aspectPatterns.examples.singleton.java;

class Main {

    /**
     * the three object references to instances of the <i>Singleton</i> class.
     */
    private static PrinterSingleton printer1, printer2, printer3;

    /**
     * Implements the first test case. Creates 3 references to the 
     * <i>Singleton</i> by (a) using the regular constructor and then by (b) 
     * using a factory method. (a) should fail (but does not, since this
     * <code>Main</code> class is in the same package and can access the
     * protected constructor), (b) should create three identical objects.
     */
    private static void test1() {
        System.out.println("\nTest 1a: Try to call regular constructor. " + "This should fail.");
        printer1 = new PrinterSingleton();
        printer2 = new PrinterSingleton();
        printer3 = new PrinterSingleton();
        printer1.print();
        printer2.print();
        printer3.print();
        System.out.println("\t=> OO Problem: Classes in the same package can " + "access the protected constructor.");
        System.out.println("\nTest 1b: Using instance() instead. This hould " + "create three identical objects.");
        printer1 = PrinterSingleton.instance();
        printer2 = PrinterSingleton.instance();
        printer3 = PrinterSingleton.instance();
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
        System.out.println("\nTest 3: Ensuring that subclasses can access the" + " constructor");
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
     *  <LI> Creates 3 references to the <i>Singleton</i> by (a) using the
     *       regular constructor and then by (b) using a factory method.
     *       (a) should fail, (b) should create three identical objects.
     *  <LI> Tests if the above 3 objects are in fact identical
     *  <LI> Creates 3 instances of a <i>Singleton</i>'s subclass. These
     *       objects should be different.
     * </OL>
     */
    public static void main(String[] args) {
        System.out.println("Testing SINGLETON pattern (java) ...");
        test1();
        test2();
        test3();
        System.out.println("\n... done.");
    }
}
