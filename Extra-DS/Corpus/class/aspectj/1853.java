package ca.ubc.cs.spl.aspectPatterns.examples.decorator.java;

public abstract class OutputDecorator implements Output {

    /**
     * the <i>Component</i> to decorate
     */
    protected Output outputComponent;

    /**
     * Prints the argument string to <code>System.out</code>. This method is
     * overwritten by concrete decorators. The default implementation
     * forwards the method call to the decorated <i>Component</i>.
     *
     * @param s the string to be printed.
     */
    public void print(String s) {
        outputComponent.print(s);
    }

    public  OutputDecorator(Output output) {
        this.outputComponent = output;
    }
}
