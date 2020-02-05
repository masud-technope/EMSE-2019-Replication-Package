package ca.ubc.cs.spl.aspectPatterns.examples.prototype.aspectj;

public class StringPrototypeB implements Cloneable {

    /**
     * the string that this object encapsulates
     */
    protected String text;

    public  StringPrototypeB(String init) {
        text = init;
    }

    /**
     * Changes the string this object encapsulates
     *
     * @param newText the new text for this object.
     */
    public void setText(String newText) {
        text = newText;
    }

    /**
     * Returns a string representation of this object.
     *
     * @return a string representation of this object.
     */
    public String toString() {
        return "AnotherString: " + text;
    }
}