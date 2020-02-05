package ca.ubc.cs.spl.aspectPatterns.examples.chainOfResponsibility.java;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class Frame extends JFrame implements ClickHandler {

    /**
     * the successor in the chain of responsibility
     */
    protected ClickHandler successor;

    public  Frame(String title) {
        super(title);
        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /** 
     * Implements the method to handle requests as defined by the
     * <code>ClickHandler</code> interface. The request is only handled here
     * if the ALT key was pressed.
     * 
     * @see ClickHandler
     */
    public void handleClick(Click click) {
        System.out.println("Frame is asked to handle the request...");
        if (click.hasAltMask()) {
            System.out.println("Frame handles the request.");
        } else {
            if (successor == null) {
                throw new RuntimeException("request unhandled (end of chain reached)");
            } else {
                successor.handleClick(click);
            }
        }
    }
}
