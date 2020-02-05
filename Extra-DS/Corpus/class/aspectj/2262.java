package ca.ubc.cs.spl.aspectPatterns.examples.command.java;

public class ButtonCommand2 implements Command {

    /**
 * Implements a sample command. This one prints a short message to 
 * <code>System.out</code> whenever it executes. The message is
 * <quote>"ButtonCommand number 2 executed"</quote>. 
 */
    public void executeCommand() {
        System.out.println("ButtonCommand number 2 executed");
    }
}
