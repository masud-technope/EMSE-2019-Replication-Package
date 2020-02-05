package ca.ubc.cs.spl.aspectPatterns.examples.templateMethod.java;

public abstract class DecoratedStringGenerator {

    /**
     * Decorates a string. This is the <i>TemplateMethod()</i>.
     *
     * @param s the string to decorate
     * @return the decorated string
     */
    public String generate(String s) {
        s = prepare(s);
        s = filter(s);
        s = finalize(s);
        return s;
    }

    /**
     * Prepares a string for decoration.
     *
     * @param s the string to filter
     * @return the prepared string
     */
    public abstract String prepare(String s);

    /**
     * Filters a string. 
     *
     * @param s the string to filter
     * @return the filtered string
     */
    public abstract String filter(String s);

    /**
     * Finalizes a string. This is the last step in the template method.
     *
     * @param s the string to finalize
     * @return the finalized string
     */
    public abstract String finalize(String s);
}
