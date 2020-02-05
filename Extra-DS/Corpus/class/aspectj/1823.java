package ca.ubc.cs.spl.aspectPatterns.examples.factoryMethod.java;

public class Main {

    /**
     * Implements the driver for the FactoryMethod design pattern example.<p> 
     *
     * In this example, the factory method <code>createComponent</code> 
     * creates a JComponent (a button and a label, repsectively). The 
     * <i>anOperation()</i> method <code>showFrame()</code> uses the factory 
     * methods to show a little GUI. In one case, the created frame contains 
     * a button, in the other a simple label.
     */
    public static void main(String[] args) {
        GUIComponentCreator creator1 = new ButtonCreator();
        GUIComponentCreator creator2 = new LabelCreator();
        creator1.showFrame();
        creator2.showFrame();
    }
}
