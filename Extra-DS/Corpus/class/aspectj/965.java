package ca.ubc.cs.spl.aspectPatterns.examples.mediator.aspectj;

import javax.swing.*;
import java.awt.event.*;

public class Main {

    static JFrame frame = new JFrame("Mediator Demo");

    static Button button1 = new Button("Button1");

    static Button button2 = new Button("Button2");

    static Label label = new Label("Click a button!");

    /**
     * Implements the driver for the mediator example. It creates a small
     * GUI with a label and two buttons. The buttons are <i>Colleague</i>s,
     * the label is the <i>Mediator</i>. 
     *
     * Each button click causes the mediator to update itself and the
     * calling button.
     */
    public static void main(String[] args) {
        ;
        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        MediatorImplementation.aspectOf().setMediator(button1, label);
        MediatorImplementation.aspectOf().setMediator(button2, label);
    }
}
