package ca.ubc.cs.spl.aspectPatterns.examples.observer.aspectj;

public class Screen {

    /**
     * the individual name of this screen object
     */
    private String name;

    public  Screen(String s) {
        this.name = s;
    }

    /**
     * Prints the name of the <code>Screen</code> object and the argument 
     * string to stdout.
     *
     * @param s the string to print
     */
    public void display(String s) {
        System.out.println(name + ": " + s);
    }
}
