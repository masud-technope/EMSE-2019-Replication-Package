package ca.ubc.cs.spl.aspectPatterns.examples.factoryMethod.java;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonCreator extends GUIComponentCreator {

    /**
     * Factory method that creates a button with label and <code>
     * ActionListener</code>.
     *
     * @returns the created button
     */
    public JComponent createComponent() {
        final JButton button = new JButton("Click me!");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                button.setText("Thank you!");
            }
        });
        return button;
    }

    /**
     * Returns a title explaining this example.
     *
     * @returns the title for the GUI frame
     */
    public String getTitle() {
        return "Example 1: A JButton";
    }
}
