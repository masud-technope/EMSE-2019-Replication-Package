package ca.ubc.cs.spl.aspectPatterns.examples.mediator.aspectj;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton {

    public  Button(String name) {
        super(name);
        this.setActionCommand(name);
        this.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                clicked();
            }
        });
    }

    public void clicked() {
    }
}
