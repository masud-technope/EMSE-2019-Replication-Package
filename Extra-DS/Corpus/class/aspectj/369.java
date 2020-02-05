package ca.ubc.cs.spl.aspectPatterns.examples.state.java;

public class Queue implements QueueContext {

    /**
     * the current <i>State</i> of this <i>Context</i>
     */
    protected QueueState state = new QueueEmpty();

    /**
     * Tries to insert an object into the queue. Returns true if successful, 
     * false otherwiese.
     *
     * @param arg the object to be inserted into the queue
     * @return true if insertion was successful, false otherwise.
     */
    public boolean insert(Object arg) {
        return state.insert(this, arg);
    }

    /**
     * Returns the first item in the queue
     *
     * @return the first item in the queue
     */
    public Object getFirst() {
        return state.getFirst(this);
    }

    /**
     * Tries to remove an object from the queue. Returns true if successful,
     * false otherwise.
     *
     * @return true if deletion was successful, false otherwise.
     */
    public boolean removeFirst() {
        // Removes the first element from the queue
        return state.removeFirst(this);
    }

    /**
     * Sets the state of the context to the arguments state.
     *
     * @param state the new state for the context object.
     */
    public void setState(QueueState state) {
        this.state = state;
    }
}
