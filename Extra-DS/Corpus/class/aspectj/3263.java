package ca.ubc.cs.spl.aspectPatterns.examples.command.aspectj;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton {

    public  Button(String label) {
        super(label);
        this.setActionCommand(label);
        this.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                clicked();
            }
        });
    }

    /**
     * Stub method that is called whenever the button is pressed.
     */
    public void clicked() {
    }
}
