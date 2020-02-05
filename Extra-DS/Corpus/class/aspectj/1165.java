package ca.ubc.cs.spl.aspectPatterns.examples.abstractFactory.aspectj;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class FramedFactory implements ComponentFactory {

    /**
     * Factroy method to create framed <code>JLabel</code> objects. 
     *
     * @return the framed <code>JLabel</code>
     */
    public JLabel createLabel() {
        JLabel label = new JLabel("This Label was created by " + getName());
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        label.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
        return label;
    }

    /**
     * Factory method to create framed <code>JButton</code> objects. 
     *
     * @param  the label for the new <code>JButton</code>
     * @return the framed <code>JButton</code>
     */
    public JButton createButton(String label) {
        JButton button = new JButton(label);
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        button.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
        return button;
    }

    /** 	
     * Returns the name of the factory.
     *
     * @return the name of the factory
     */
    public String getName() {
        return "Framed Factory";
    }
}
