package ca.ubc.cs.spl.aspectPatterns.examples.state.aspectj;

public class QueueFull implements QueueState {

    /**
     * stores the items in the queue
     */
    protected Object[] items;

    /**
	 * stores the index of the first item in the queue.
	 */
    protected int first;

    /**
     * Tries to insert an object into the queue. Returns false since the
     * queue is full.
     *
     * @param arg the object to be inserted into the queue
     * @return false.
     */
    public boolean insert(Object arg) {
        return false;
    }

    /**
     * Returns the first item in the queue. 
     *
     * @return the first item in the queue.
     */
    public Object getFirst() {
        return items[first];
    }

    /**
     * Tries to remove an object from the queue. Returns true if successful,
     * false otherwiese. The state transition to "normal" is implemented by 
     * the aspect.
     *
     * @return true since it is always possible to delete an item from a 
     * full queue
     */
    public boolean removeFirst() {
        return true;
    }
}
