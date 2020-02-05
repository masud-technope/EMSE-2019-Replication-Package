package ca.ubc.cs.spl.aspectPatterns.examples.facade.java;

public class StringTransformer {

    /**
     * Transforms a string to upper case
     *
     * @param s the string to transform
     * @returns the transformed string
     */
    public static String transformToUpper(String s) {
        return s.toUpperCase();
    }

    /**
     * Transforms a string to lower case
     *
     * @param s the string to transform
     * @returns the transformed string
     */
    public static String transformToLower(String s) {
        return s.toLowerCase();
    }
}
