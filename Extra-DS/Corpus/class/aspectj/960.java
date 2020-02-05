package ca.ubc.cs.spl.aspectPatterns.examples.bridge.java;

public class StarImplementation implements ScreenImplementation {

    /**
         * Does a line feed (to <code>System.out</code>).
         */
    public void printLine() {
        System.out.println();
    }

    /** 
         * Prints a star ("*") to <code>System.out</code>.
         */
    public void printDecor() {
        System.out.print("*");
    }

    /**
         * Prints the argument text to <code>System.out</code>.
         *
         * @param text the text to print
         */
    public void printText(String text) {
        System.out.print(text);
    }
}
