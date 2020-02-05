package ca.ubc.cs.spl.aspectPatterns.examples.abstractFactory.aspectj;

import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * This <i>Concrete Factory</i> implements the 
 * <code>AbstractFactory</code> interface to provide 
 * regular Swing GUI components.
 * 
 * The factroy methods <code>createLabel()</code> and <create>Button()</code>
 * do not need to be defined here, they recieve their implementation from
 * the inter-type declarations in aspect 
 * <code>AbstractFactroyEnhancement</code>.
 * 
 * This is done so that future concrete factories can reuse the 
 * implementations of the factory methods and will only have to specify those
 * that differ from the default ones.
 * 
 * @author Jan Hannemann
 * @author Gregor Kiczales
 * @version 1.1, 01/20/04
 *
 */
public class RegularFactory implements ComponentFactory {

    /** 	
     * Returns the name of the factory.
     *
     * @return the name of the factory
     */
    public String getName() {
        return ("Regular Factory");
    }
}
