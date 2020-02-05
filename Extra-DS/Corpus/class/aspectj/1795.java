package ca.ubc.cs.spl.aspectPatterns.examples.state.java;

public interface QueueContext {

    /**
     * Sets the state of the context to the arguments state.
     *
     * @param state the new state for the context object.
     */
    public void setState(QueueState state);
}
