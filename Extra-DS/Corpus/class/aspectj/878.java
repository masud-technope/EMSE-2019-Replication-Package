package ca.ubc.cs.spl.aspectPatterns.examples.prototype.java;

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
     * @returns a string representation of this object.
     */
    public String toString() {
        return "StringPrototypeA: " + text;
    }

    /** 
     * Returns a copy of this object. Does only work this way if the
     * superclass implements <code>clone()</code>.
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
