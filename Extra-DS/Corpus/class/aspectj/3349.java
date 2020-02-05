package ca.ubc.cs.spl.aspectPatterns.examples.builder.aspectj;

public class XMLCreator implements Creator {

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
        checkAttribute();
        representation += ("\t<" + newAttribute + ">");
        this.attribute = newAttribute;
    }

    /** 
     * Defines a <i>buildPart()</i> operation for value parts.
     *
     * @param newValue the type to process
     */
    public void processValue(String newValue) {
        representation += newValue;
    }

    /**
     * Checks wether the opening type tag is closed and closes it if not.
     */
    protected void checkType() {
        if (type != null) {
            representation += ("</" + type + ">\n");
            type = null;
        }
    }

    /**
     * Checks wether the opening attribute tag is closed and closes it if not.
     */
    protected void checkAttribute() {
        if (attribute != null) {
            representation += ("</" + attribute + ">\n");
            attribute = null;
        }
    }

    /** 
     * Defines the <i>getResult()</i> operation for <i>Builder</i>s. 
     */
    public String getRepresentation() {
        checkAttribute();
        checkType();
        return representation;
    }
}
