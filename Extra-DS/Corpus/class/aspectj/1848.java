package ca.ubc.cs.spl.aspectPatterns.examples.state.aspectj;

public interface QueueState {

    /**
     * Tries to insert an object into the queue. Returns true if successful, 
     * false otherwiese.
     *
     * @param arg the object to be inserted into the queue
     * @return true if insertion was successful, false otherwise.
     */
    public boolean insert(Object arg);

    /**
     * Returns the first item in the queue
     *
     * @return the first item in the queue
     */
    public Object getFirst();

    /**
     * Tries to remove an object from the queue. Returns true if successful,
     * false otherwiese.
     *
     * @return true if deletion was successful, false otherwise.
     */
    public boolean removeFirst();
}
