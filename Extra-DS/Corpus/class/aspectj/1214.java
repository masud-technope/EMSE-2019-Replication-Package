package ca.ubc.cs.spl.aspectPatterns.examples.singleton.aspectj;

public class Printer {

    /**
     * counts the instances of this class
     */
    protected static int objectsSoFar = 0;

    /**
     * each instance has an ID to distinguish them.
     */
    protected int id;

    public  Printer() {
        id = ++objectsSoFar;
    }

    /**
     * Prints the instance's ID to <code>System.out</code>.
     */
    public void print() {
        System.out.println("\tMy ID is " + id);
    }
}
