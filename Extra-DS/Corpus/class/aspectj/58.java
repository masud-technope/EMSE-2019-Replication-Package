package ca.ubc.cs.spl.aspectPatterns.examples.builder.aspectj;

public class Main {

    /** 
     * Builds a string representation of a person using a given builder.
     *
     * @param the builder to use.
     */
    protected static void build(Creator builder) {
        builder.processType("Person");
        builder.processAttribute("Name");
        builder.processValue("James Brick");
        builder.processAttribute("Age");
        builder.processValue("33");
        builder.processAttribute("Occupation");
        builder.processValue("Builder");
    }

    /**
     * Implements the driver for the Builder design pattern example.<p> 
     *
     * In this example, <code>Main</code> acts as the <i>Director</i> that
     * uses two different builders to build string representations of a
     * person. <code>TextCreator</code> creates a text-like representation,
     * <code>XMLCreator</code> an XML-like one.
     * 
     * @param args the command-line parameters, unused.
     */
    public static void main(String[] args) {
        Creator builder1 = new TextCreator();
        Creator builder2 = new XMLCreator();
        build(builder1);
        build(builder2);
        System.out.println(builder1.getRepresentation());
        System.out.println(builder2.getRepresentation());
    }
}
