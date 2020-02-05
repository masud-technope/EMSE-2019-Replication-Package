package ca.ubc.cs.spl.aspectPatterns.examples.bridge.java;

public class GreetingScreen extends Screen {

    public  GreetingScreen(ScreenImplementation si) {
        super(si);
    }

    /**
     * Draws/prints a greeting in a text box
     */
    public void drawGreeting() {
        drawTextBox("Greetings!");
    }
}
