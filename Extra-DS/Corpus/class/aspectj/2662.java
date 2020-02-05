package ca.ubc.cs.spl.aspectPatterns.examples.chainOfResponsibility.aspectj;

import javax.swing.*;
import java.awt.event.*;

public class Button extends JButton {

    public  Button(String label) {
        super(label);
        this.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                doClick(new Click(ae));
            }
        });
    }

    /** 
     * An empty method that is called when the button is clicked. This method
     * could also be defined in the concrete aspect.
     *
     * @param click the <code>Click</code> that was created when the 
     * button was clicked.  
     */
    public void doClick(Click click) {
    }
}
