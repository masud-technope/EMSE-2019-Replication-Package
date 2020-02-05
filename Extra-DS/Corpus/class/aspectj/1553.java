package ca.ubc.cs.spl.aspectPatterns.examples.flyweight.aspectj;

public class CharacterFlyweight implements PrintableFlyweight {

    /**
     * The character this <i>ConcreteFlyweight</i> represents
     */
    private char c;

    public  CharacterFlyweight(char c) {
        this.c = c;
    }

    /** 
     * Prints the stored character
     *
     * @param uppercase whether the character should be printed in
     * uppercase
     */
    public void print(boolean uppercase) {
        System.out.print(uppercase ? Character.toUpperCase(c) : c);
    }
}
