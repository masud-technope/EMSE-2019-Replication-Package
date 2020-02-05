package ca.ubc.cs.spl.aspectPatterns.examples.state.aspectj;

public class Queue {

    /**
     * the current state of this context
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
        return state.insert(arg);
    }

    /**
     * Returns the first item in the queue
     *
     * @return the first item in the queue
     */
    public Object getFirst() {
        return state.getFirst();
    }

    /**
     * Tries to remove an object from the queue. Returns true if successful,
     * false otherwiese.
     *
     * @return true if deletion was successful, false otherwise.
     */
    public boolean removeFirst() {
        return state.removeFirst();
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
