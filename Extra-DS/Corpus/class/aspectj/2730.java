package ca.ubc.cs.spl.aspectPatterns.examples.bridge.aspectj;

public class GreetingScreen implements Screen {

    public  GreetingScreen(ScreenImplementation si) {
        setImplementor(si);
    }

    /**
     * Draws/prints a greeting in a text box
     */
    public void drawGreeting() {
        drawTextBox("Greetings!");
    }
}
