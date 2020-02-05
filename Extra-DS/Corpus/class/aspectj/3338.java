package ca.ubc.cs.spl.aspectPatterns.patternLibrary;

public interface Command {

    /**
     * Executes the command.
     *
     * @param receiver the object this command is manipulating.
     */
    public void executeCommand(CommandReceiver receiver);

    /**
     * Queries the command's executable status. This interface method is
     * optional (default: all commands are excutable); a default 
     * implementation is provided by the abstract CommandProtocol aspect.
     *
     * @returns a boolean indicating whether the command is excutable.
     */
    public boolean isExecutable();
}
