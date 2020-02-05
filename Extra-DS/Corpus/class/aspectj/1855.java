package ca.ubc.cs.spl.aspectPatterns.examples.mediator.java;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton implements GUIColleague {

    private GUIMediator mediator;

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
        mediator.colleagueChanged(this);
    }

    /**
     * Allows to set the <i>Mediator</i> for this <i>Colleague</i>
     *
     * @param mediator the new mediator
     */
    public void setMediator(GUIMediator mediator) {
        this.mediator = mediator;
    }
}
