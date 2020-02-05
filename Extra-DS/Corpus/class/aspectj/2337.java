package ca.ubc.cs.spl.aspectPatterns.examples.chainOfResponsibility.java;

import javax.swing.*;
import java.awt.event.*;

public class Button extends JButton implements ClickHandler {

    /**
     * the successor in the chain of responsibility
     */
    protected ClickHandler successor;

    public  Button(String label, ClickHandler successor) {
        super(label);
        this.successor = successor;
        this.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                handleClick(new Click(ae));
            }
        });
    }

    /** 
     * Implements the method to handle requests as defined by the
     * <code>ClickHandler</code> interface. The request is only handled here
     * if the SHIFT key was pressed.
     * 
     * @see ClickHandler
     */
    public void handleClick(Click click) {
        System.out.println("Button is asked to handle the request...");
        if (click.hasShiftMask()) {
            System.out.println("Button handles the request.");
        } else {
            if (successor == null) {
                throw new RuntimeException("request unhandled (end of chain reached)");
            } else {
                successor.handleClick(click);
            }
        }
    }
}
