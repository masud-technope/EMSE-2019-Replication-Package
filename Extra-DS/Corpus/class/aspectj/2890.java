package ca.ubc.cs.spl.aspectPatterns.examples.state.java;

public class QueueFull implements QueueState {

    /**
     * stores the items in the queue
     */
    protected Object[] items;

    /**
	 * stores the index of the first item in the queue. 
	 */
    protected int first;

    public  QueueFull(Object[] items, int first) {
        this.items = items;
        this.first = first;
    }

    /**
     * Tries to insert an object into the queue. Returns false since the
     * queue is full.
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @param arg the object to be inserted into the queue
     * @return false.
     */
    public boolean insert(QueueContext context, Object arg) {
        return false;
    }

    /**
     * Returns the first item in the queue. 
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @return the first item in the queue.
     */
    public Object getFirst(QueueContext context) {
        return items[first];
    }

    /**
     * Tries to remove an object from the queue. Returns true if successful,
     * false otherwiese. The state of the context is changed to "normal".
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @return true if deletion was successful, false otherwise.
     */
    public boolean removeFirst(QueueContext context) {
        QueueState nextState = new QueueNormal(items, first, first);
        context.setState(nextState);
        return nextState.removeFirst(context);
    }
}
