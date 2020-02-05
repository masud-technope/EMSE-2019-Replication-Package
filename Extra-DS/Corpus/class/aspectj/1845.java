package ca.ubc.cs.spl.aspectPatterns.examples.builder.java;

public class XMLCreator extends Creator {

    protected String type = null;

    protected String attribute = null;

    /** 
     * Defines a <i>buildPart()</i> operation for type parts.
     *
     * @param newType the type to process
     */
    public void processType(String newType) {
        representation = "<" + newType + ">\n";
        type = newType;
    }

    /** 
     * Defines a <i>buildPart()</i> operation for attribute parts.
     *
     * @param newAttribute the attribute to process
     */
    public void processAttribute(String newAttribute) {
        if (attribute != null) {
            representation += ("</" + attribute + ">\n");
        }
        representation += ("\t<" + newAttribute + ">");
        this.attribute = newAttribute;
    }

    /** 
     * Defines a <i>buildPart()</i> operation for value parts.
     *
     * @param newValue the value to process
     */
    public void processValue(String newValue) {
        representation += (newValue);
    }

    /** 
     * Defines the <i>getResult()</i> operation for <i>Builder</i>s. Includes
     * a default implementation.
     */
    public String getRepresentation() {
        if (attribute != null) {
            representation += ("</" + attribute + ">\n");
            attribute = null;
        }
        if (type != null) {
            representation += ("</" + type + ">\n");
            type = null;
        }
        return representation;
    }
}
