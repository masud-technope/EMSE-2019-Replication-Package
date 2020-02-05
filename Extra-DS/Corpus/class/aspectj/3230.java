package ca.ubc.cs.spl.aspectPatterns.examples.decorator.aspectj;

public class ConcreteOutput {

    /**
     * Prints the argument string to <code>System.out</code>.
     *
     * @param s the string to be printed.
     */
    public void print(String s) {
        System.out.print(s);
    }
}
