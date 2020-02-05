package ca.ubc.cs.spl.aspectPatterns.examples.templateMethod.aspectj;

public interface DecoratedStringGenerator {

    /**
     * Prepares a string for decoration.
     *
     * @param s the string to filter
     * @return the prepared string
     */
    public String prepare(String s);

    /**
     * Filters a string. 
     *
     * @param s the string to filter
     * @return the filtered string
     */
    public String filter(String s);

    /**
     * Finalizes a string. This is the last step in the template method.
     *
     * @param s the string to finalize
     * @returns the finalized string
     */
    public String finalize(String s);
}
