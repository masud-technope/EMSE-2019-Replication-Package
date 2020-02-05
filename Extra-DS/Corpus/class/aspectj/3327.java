package ca.ubc.cs.spl.aspectPatterns.examples.mediator.java;

import javax.swing.*;

public class Label extends JLabel implements GUIMediator {

    public  Label(String s) {
        super(s);
    }

    /**
     * Handles the event that a <i>colleague</i> chanbged. 
     *
     * @param colleague the <i>Colleague</i> that caused the notification 
     */
    public void colleagueChanged(GUIColleague colleague) {
        Button button = (Button) colleague;
        if (button == Main.button1) {
            this.setText("Button1 clicked");
        } else if (button == Main.button2) {
            this.setText("Button2 clicked");
        }
        button.setText("(Done)");
    }
}
