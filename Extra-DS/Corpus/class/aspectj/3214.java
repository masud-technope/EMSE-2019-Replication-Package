package ca.ubc.cs.spl.aspectPatterns.examples.templateMethod.java;

public class FancyGenerator extends DecoratedStringGenerator {

    /**
     * Prepares a string for decoration. Turns the string into lowercase.
     *
     * @param s the string to filter
     * @return the prepared string
     */
    public String prepare(String s) {
        return s.toLowerCase();
    }

    /**
     * Filters a string. Capitalizes all consonants.
     *
     * @param s the string to filter
     * @return the filtered string
     */
    public String filter(String s) {
        s = s.replace('a', 'A');
        s = s.replace('e', 'E');
        s = s.replace('i', 'I');
        s = s.replace('o', 'O');
        s = s.replace('u', 'U');
        return s;
    }

    /**
     * Finalizes a string by adding an explanation to it.
     *
     * @param s the string to finalize
     * @return the finalized string
     */
    public String finalize(String s) {
        return (s + ".\n(all consonants capitalized)");
    }
}
