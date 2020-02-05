package ca.ubc.cs.spl.aspectPatterns.examples.bridge.java;

import java.util.Date;

public class InformationScreen extends Screen {

    public  InformationScreen(ScreenImplementation si) {
        super(si);
    }

    /**
     * Draws/prints the system time in a text box
     */
    public void drawInfo() {
        Date date = new Date();
        drawTextBox("Current system time: " + date);
    }
}
