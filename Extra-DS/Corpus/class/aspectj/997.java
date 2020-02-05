package ca.ubc.cs.spl.aspectPatterns.examples.command.java;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton {

    /**
     * the command object associated with this button
     */
    protected Command command;

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
     * Calls <code>ececuteCommand()</code> on the associated 
     * command object. This method gets called whenever the 
     * button is pressed.
     */
    public void clicked() {
        if (command != null) {
            command.executeCommand();
        }
    }

    /**
     * Sets the associated command object for this button
     *
     * @param command the new <i>Command</i> object.
     */
    public void setCommand(Command command) {
        this.command = command;
    }
}
