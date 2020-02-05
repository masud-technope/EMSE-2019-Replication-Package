package ca.ubc.cs.spl.aspectPatterns.examples.bridge.aspectj;

public interface Screen {

    /**
     * Draws or prints a text to an output device determined by the 
     * current <i>Implementor</i>.
     *
     * @param text The text to be drawn/printed
     */
    public void drawText(String text);

    /**
     * Draws or prints a text in a box to an output device determined 
     * by the current <i>Implementor</i>.
     *
     * @param text The text to be drawn/printed
     */
    public void drawTextBox(String text);
}
