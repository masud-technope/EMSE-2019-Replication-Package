package ca.ubc.cs.spl.aspectPatterns.examples.bridge.aspectj;

public class CrossCapitalImplementation implements ScreenImplementation {

    /**
         * Does a line feed (to <code>System.out</code>).
         */
    public void printLine() {
        System.out.println();
    }

    /** 
         * Prints a double cross ("#") to <code>System.out</code>.
         */
    public void printDecor() {
        System.out.print("X");
    }

    /**
         * Prints the argument text in capitals to <code>System.out</code>.
         *
         * @param text the text to print
         */
    public void printText(String text) {
        System.out.print(text.toUpperCase());
    }
}
