package ca.ubc.cs.spl.aspectPatterns.examples.chainOfResponsibility.java;

import javax.swing.*;

public class Panel extends JPanel implements ClickHandler {

    /**
     * the successor in the chain of responsibility
     */
    protected ClickHandler successor;

    public  Panel(ClickHandler successor) {
        super();
        this.successor = successor;
    }

    /** 
     * Implements the method to handle requests as defined by the
     * <code>ClickHandler</code> interface. The request is only handled here.
     * if the CTRL key was pressed.
     * 
     * @see ClickHandler
     */
    public void handleClick(Click click) {
        System.out.println("Panel is asked to handle the request...");
        if (click.hasCtrlMask()) {
            System.out.println("Panel handles the request.");
        } else {
            if (successor == null) {
                throw new RuntimeException("request unhandled (end of chain reached)");
            } else {
                successor.handleClick(click);
            }
        }
    }
}
