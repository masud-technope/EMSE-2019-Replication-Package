package ca.ubc.cs.spl.aspectPatterns.examples.decorator.java;

public class StarDecorator extends OutputDecorator {

    /**
     * Adds three stars before and after the argument string before passing
     * the call on to the component this decorator decorates. 
     *
     * @param s the string to be decorated.
     */
    public void print(String s) {
        outputComponent.print(" *** " + s + " *** ");
    }

    public  StarDecorator(Output output) {
        super(output);
    }
}
