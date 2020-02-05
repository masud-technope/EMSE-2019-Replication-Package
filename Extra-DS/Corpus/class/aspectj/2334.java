package ca.ubc.cs.spl.aspectPatterns.examples.abstractFactory.java;

import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * Defines the interface for creating products. The only factory methods are
 * <code>createLabel()</code> and <code>createButton(..)</code>.
 *
 * @author  Jan Hannemann
 * @author  Gregor Kiczales
 * @version 1.1, 01/20/04
 * 
 */
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
