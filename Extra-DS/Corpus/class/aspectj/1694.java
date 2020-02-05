package ca.ubc.cs.spl.aspectPatterns.examples.factoryMethod.aspectj;

import javax.swing.JComponent;

public interface GUIComponentCreator {

    /**
     * The factory method to create <code>JComponent</code>s, to be 
     * concretized by subclasses.
     *
     * @returns the created product
     */
    public JComponent createComponent();

    /**
     * Another factory method to create a title that explains the created
     * component
     *
     * @returns the title for the GUI frame
     */
    public String getTitle();
}
