package ca.ubc.cs.spl.aspectPatterns.examples.bridge.aspectj;

import java.util.Date;

public class InformationScreen implements Screen {

    public  InformationScreen(ScreenImplementation si) {
        setImplementor(si);
    }

    /**
     * Draws/prints the system time in a text box
     */
    public void drawInfo() {
        Date date = new Date();
        drawTextBox("Current system time: " + date);
    }
}
