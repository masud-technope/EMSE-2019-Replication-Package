package ca.ubc.cs.spl.aspectPatterns.examples.builder.aspectj;

public interface Creator {

    /** 
     * Defines the <i>buildPart()</i> operation for type parts.
     *
     * @param type the type to process
     */
    public abstract void processType(String type);

    /** 
     * Defines the <i>buildPart()</i> operation for attribute parts.
     *
     * @param type the type to process
     */
    public abstract void processAttribute(String type);

    /** 
     * Defines the <i>buildPart()</i> operation for value parts.
     *
     * @param type the type to process
     */
    public abstract void processValue(String type);

    /** 
     * Defines the <i>getResult()</i> operation for <i>Builder</i>s.
     *
     * @param type the type to process
     */
    public String getRepresentation();
}
