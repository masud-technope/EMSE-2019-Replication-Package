package ca.ubc.cs.spl.aspectPatterns.examples.chainOfResponsibility.aspectj;

public class Main {

    /**
     * Implements a GUI-motivated example for the Chain Of Responsibility design
     * pattern.<p> 
     *
     * In this implementation, the request is handled by the panel if the 
     * CTRL mask is active (i.e., if the CTRL key was pressed while the button 
     * was clicked). If the SHIFT mask is active, the frame handles the request.
     * Otherwise, the request is unhandled.      
     *
     * @param args command line parameters, unused
     */
    public static void main(String[] args) {
        Frame frame = new Frame("Chain of Responsibility pattern example");
        Panel panel = new Panel();
        Button button = new Button("Click me to see the pattern in action! Use <SHIFT>, <CTRL>, and <ALT> during clicks to see different behavior");
        ClickChain.aspectOf().setSuccessor(button, panel);
        ClickChain.aspectOf().setSuccessor(panel, frame);
        frame.getContentPane().add(panel);
        panel.add(button);
        frame.pack();
        frame.setVisible(true);
    }
}
