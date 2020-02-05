package ca.ubc.cs.spl.aspectPatterns.examples.chainOfResponsibility.java;

public class Main {

    /**
     * Implements the driver for the chain of responisbility example. 
     * It creates a simple GUI consisting of a <code>Button</code> in a 
     * <code>Panel</code> in a <code>Frame</code>. 
     *
     * Clicking the button will start a request, that gets passed on
     * along the following chain: button, panel, frame. Depending on 
     * whether the ALT, SHIFT, or CTRL keys are pressed during the 
     * button click, a different object in the chain will handle the
     * request:
     * 
     * <ol>
     * 		<li> If the SHIFT key is pressed, Button will handle the request
     * 		<li> If the CTRL  key is pressed, Panel  will handle the request
     * 		<li> If the ALT   key is pressed, Frame  will handle the request
     * 		<li> If no keys are pressed, the request will not be handled and
     * 			 an exception will be raised.
     * </ol>
     */
    public static void main(String[] args) {
        Frame frame = new Frame("Chain of Responsibility");
        Panel panel = new Panel(frame);
        Button button = new Button("Click me to see the pattern in action! Use <SHIFT>, <CTRL>, and <ALT> during clicks to see different behavior", panel);
        frame.getContentPane().add(panel);
        panel.add(button);
        frame.pack();
        frame.setVisible(true);
    }
}
