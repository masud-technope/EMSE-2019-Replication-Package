package ca.ubc.cs.spl.aspectPatterns.examples.factoryMethod.aspectj;

import javax.swing.JLabel;
import javax.swing.JComponent;

public class LabelCreator implements GUIComponentCreator {

    /**
     * Factory method that creates a label
     *
     * @returns the created label
     */
    public JComponent createComponent() {
        JLabel label = new JLabel("This is a JLabel.");
        return label;
    }

    /**
     * Returns a title explaining this example.
     *
     * @returns the title for the GUI frame
     */
    public String getTitle() {
        return "Example 2: A JLabel";
    }
}
