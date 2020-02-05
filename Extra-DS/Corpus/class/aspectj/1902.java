package ca.ubc.cs.spl.aspectPatterns.examples.builder.java;

public class TextCreator extends Creator {

    /** 
     * Defines a <i>buildPart()</i> operation for type parts.
     *
     * @param newType the type to process
     */
    public void processType(String newType) {
        representation = "This is a new " + newType + ":\n";
    }

    /** 
     * Defines a <i>buildPart()</i> operation for attribute parts.
     *
     * @param newAttribute the attribute to process
     */
    public void processAttribute(String newAttribute) {
        representation += ("Its " + newAttribute + " is ");
    }

    /** 
     * Defines a <i>buildPart()</i> operation for value parts.
     *
     * @param newValue the value to process
     */
    public void processValue(String newValue) {
        representation += (newValue + ".\n");
    }
}
