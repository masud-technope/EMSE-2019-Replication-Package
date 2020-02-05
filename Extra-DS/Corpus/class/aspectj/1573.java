package ca.ubc.cs.spl.aspectPatterns.examples.decorator.java;

public class Main {

    /**
     * Implements the driver for the Decorator design pattern example.<p> 
     *
     * Experimental setup: Concrete decorator (ConcreteOutput) prints a
     * string, Decorators (StarDecorator and BracketDecorator) wrap other
     * output around it. Output should be: "[ *** <String> *** ]" 
     *
     * @param args command line paramters, unused
     */
    public static void main(String[] args) {
        Output original = new ConcreteOutput();
        Output bracketed = new BracketDecorator(original);
        Output stared = new StarDecorator(bracketed);
        stared.print("<String>");
        System.out.println();
    }
}
