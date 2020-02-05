package ca.ubc.cs.spl.aspectPatterns.examples.templateMethod.aspectj;

public class SimpleGenerator implements DecoratedStringGenerator {

    /**
     * Prepares a string for decoration. Does nothing.
     *
     * @param s the string to filter
     * @return the passed string
     */
    public String prepare(String s) {
        return s;
    }

    /**
     * Filters a string. Does nothing.
     *
     * @param s the string to filter
     * @return the passed string
     */
    public String filter(String s) {
        return s;
    }

    /**
     * Finalizes a string by adding a period to it.
     *
     * @param s the string to finalize
     * @return the finalized string
     */
    public String finalize(String s) {
        return s + ".";
    }
}
