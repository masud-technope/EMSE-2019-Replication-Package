package ca.ubc.cs.spl.aspectPatterns.examples.bridge.java;

public abstract class Screen {

    /**
     * stores the actual <i>Implementor</i> to use 
     */
    private ScreenImplementation implementor;

    public  Screen(ScreenImplementation implementor) {
        this.implementor = implementor;
    }

    /**
     * Draws or prints a text to an output device determined by the 
     * current <i>Implementor</i>.
     *
     * @param text The text to be drawn/printed
     */
    public void drawText(String text) {
        implementor.printText(text);
        implementor.printLine();
    }

    /**
     * Draws or prints a text in a box to an output device determined 
     * by the current <i>Implementor</i>.
     *
     * @param text The text to be drawn/printed
     */
    public void drawTextBox(String text) {
        int length = text.length();
        for (int i = 0; i < length + 4; i++) {
            implementor.printDecor();
        }
        implementor.printLine();
        implementor.printDecor();
        implementor.printText(" " + text + " ");
        implementor.printDecor();
        implementor.printLine();
        for (int i = 0; i < length + 4; i++) {
            implementor.printDecor();
        }
        implementor.printLine();
    }
}
