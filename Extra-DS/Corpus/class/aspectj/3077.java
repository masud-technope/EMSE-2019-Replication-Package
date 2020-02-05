package ca.ubc.cs.spl.aspectPatterns.examples.flyweight.java;

public class WhitespaceFlyweight implements PrintableFlyweight {

    /**
     * The character this flyweight represents
     */
    private char c;

    public  WhitespaceFlyweight(char c) {
        this.c = c;
    }

    /** 
	 * Prints the stored character.
	 *
	 * @param uppercase whether the character should be printed in
	 * uppercase
	 */
    public void print(boolean uppercase) {
        System.out.print(uppercase ? Character.toUpperCase(c) : c);
    }
}
