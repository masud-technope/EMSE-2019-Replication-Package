package ca.ubc.cs.spl.aspectPatterns.examples.abstractFactory.aspectj;

import javax.swing.JLabel;
import javax.swing.JButton;

public interface ComponentFactory {

    /**
     * Creates factory-specific <code>JLabel</code> products. 
     *
     * @return the factory-specific <code>JLabel</code>
     */
    public JLabel createLabel();

    /**
     * Creates factory-specific <code>JButton</code> products. 
     *
     * @return the factory-specific <code>JButton</code>
     */
    public JButton createButton(String label);

    /** 	
     * Returns the name of the factory.
     *
     * @return the name of the factory
     */
    public String getName();
}
