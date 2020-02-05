package ca.ubc.cs.spl.aspectPatterns.examples.facade.aspectj;

public class RegularScreen {

    /**
     * Prints a string to System.out.
     *
     * @param s the string to print 
     */
    public static void print(String s) {
        System.out.print(s);
    }

    /**
     * Prints a newline to System.out.
     */
    public static void newline() {
        System.out.println();
    }
}
