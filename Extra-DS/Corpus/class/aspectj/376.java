package ca.ubc.cs.spl.aspectPatterns.examples.abstractFactory.java;

import javax.swing.JLabel;
import javax.swing.JButton;

public class RegularFactory implements ComponentFactory {

    /**
	 * Factroy method to create regular <code>JLabel</code> objects. 
	 *
	 * @return the regular <code>JLabel</code>
	 */
    public JLabel createLabel() {
        return new JLabel("This Label was created by " + getName());
    }

    /**
	 * Factory method to create regular <code>JButton</code> objects. 
	 *
	 * @param  the label for the new <code>JButton</code>
	 * @return the regular <code>JButton</code>
	 */
    public JButton createButton(String label) {
        return new JButton(label);
    }

    /** 	
     * Returns the name of the factory.
     *
     * @return the name of the factory
     */
    public String getName() {
        return ("Regular Factory");
    }
}
