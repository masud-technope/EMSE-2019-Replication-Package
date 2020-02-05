package ca.ubc.cs.spl.aspectPatterns.examples.state.aspectj;

public class QueueEmpty implements QueueState {

    /**
     * Tries to insert an object into the queue. Returns true since it is
     * always possible to insert items into an empty queue. The appropriate
     * state transitions are implemented by the aspect.
     *
     * @param arg the object to be inserted into the queue
     * @return true.
     */
    public boolean insert(Object arg) {
        return true;
    }

    /**
     * Returns the first item in the queue. Returns null since the queue is 
     * empty.
     *
     * @return null.
     */
    public Object getFirst() {
        return null;
    }

    /**
     * Tries to remove an object from the queue. Returns false (queue is 
     * empty).
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @return false.
     */
    public boolean removeFirst() {
        return false;
    }
}
