package ca.ubc.cs.spl.aspectPatterns.examples.decorator.java;

public class ConcreteOutput implements Output {

    /**
     * Prints the argument string to <code>System.out</code>.
     *
     * @param s the string to be printed.
     */
    public void print(String s) {
        System.out.print(s);
    }
}
