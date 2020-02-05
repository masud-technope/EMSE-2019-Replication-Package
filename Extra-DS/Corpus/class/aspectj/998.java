package ca.ubc.cs.spl.aspectPatterns.examples.flyweight.java;

import java.util.Hashtable;

public class PrintableFlyweightFactory {

    /** 
     * stores the existing flyweights by character they represent
     */
    private Hashtable printables = new Hashtable();

    /**
     * Returns the flyweight representing the argument character.
     * If the appropriate flyweight does not yet exist, it is created 
     * on demand.
     *
     * @param c the character for which the the flyweight is returned
     * @return the <i>Flyweight</i> representing the argument character
     */
    public PrintableFlyweight getPrintableFlyweight(char c) {
        Character ch = new Character(c);
        if (printables.containsKey(ch)) {
            return (PrintableFlyweight) printables.get(ch);
        } else {
            PrintableFlyweight flyweight = null;
            if (Character.isWhitespace(c)) {
                flyweight = new WhitespaceFlyweight(c);
            } else {
                flyweight = new CharacterFlyweight(c);
            }
            printables.put(ch, flyweight);
            return flyweight;
        }
    }
}
