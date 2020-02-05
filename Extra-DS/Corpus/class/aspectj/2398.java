package ca.ubc.cs.spl.aspectPatterns.examples.command.aspectj;

import ca.ubc.cs.spl.aspectPatterns.patternLibrary.Command;
import ca.ubc.cs.spl.aspectPatterns.patternLibrary.CommandReceiver;

public class ButtonCommand implements Command {

    private Printer printer = new Printer();

    /**
     * Implements a sample command. This one prints a short message to 
     * <code>System.out</code> whenever it executes. The message is
     * <quote>"ButtonCommand executed"</quote>. 
     */
    public void executeCommand(CommandReceiver receiver) {
        printer.println("ButtonCommand executed");
    }
}
