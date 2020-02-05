package ca.ubc.cs.spl.aspectPatterns.examples.prototype.aspectj;

public class StringPrototypeA implements Cloneable {

    /**
     * the string that this object encapsulates
     */
    protected String text;

    public  StringPrototypeA(String init) {
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
        return "MyString: " + text;
    }
}
