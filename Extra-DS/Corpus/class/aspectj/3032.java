package ca.ubc.cs.spl.aspectPatterns.examples.flyweight.java;

public interface PrintableFlyweight {

    /**
     * Defines the method signature for <i>Flyweights</i>' 
     * <code>print()</code> method
     *
     * @param uppercase whether the character is to be printed as uppercase
     */
    public void print(boolean uppercase);
}
