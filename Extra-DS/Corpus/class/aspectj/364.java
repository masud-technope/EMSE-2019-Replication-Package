package ca.ubc.cs.spl.aspectPatterns.examples.singleton.java;

public class PrinterSingleton {

    /**
     * counts the instances of this class
     */
    protected static int objectsSoFar = 0;

    /**
     * stores this <i>Singleton</i>'s only instance
     */
    protected static PrinterSingleton onlyInstance = null;

    /**
     * each instance has an ID to distinguish them.
     */
    protected int id;

    protected  PrinterSingleton() {
        id = ++objectsSoFar;
    }

    /**
     * Factory method that provides access to the <i>Singleton</i> instance.
     * Uses creation-on-demand.
     *
     * @return the unique <i>Singleton</i> instance
     */
    public static PrinterSingleton instance() {
        if (onlyInstance == null) {
            onlyInstance = new PrinterSingleton();
        }
        return onlyInstance;
    }

    /**
     * Prints the instance's ID to <code>System.out</code>.
     */
    public void print() {
        System.out.println("\tMy ID is " + id);
    }
}
