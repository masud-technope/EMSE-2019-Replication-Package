package ca.ubc.cs.spl.aspectPatterns.examples.state.java;

public interface QueueState {

    /**
     * Tries to insert an object into the queue. Returns true if successful, 
     * false otherwiese.
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @param arg the object to be inserted into the queue
     * @return true if insertion was successful, false otherwise.
     */
    public boolean insert(QueueContext context, Object arg);

    /**
     * Returns the first item in the queue
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @return the first item in the queue
     */
    public Object getFirst(QueueContext context);

    /**
     * Tries to remove an object from the queue. Returns true if successful,
     * false otherwiese.
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @return true if deletion was successful, false otherwise.
     */
    public boolean removeFirst(QueueContext context);
}
