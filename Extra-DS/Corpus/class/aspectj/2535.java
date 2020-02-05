package ca.ubc.cs.spl.aspectPatterns.examples.state.java;

public class QueueEmpty implements QueueState {

    /**
     * Tries to insert an object into the queue. Returns true if successful, 
     * false otherwiese. The state of the context
     * is changed to "normal" (queue is no longer empty).
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @param arg the object to be inserted into the queue
     * @return true if insertion was successful, false otherwise.
     */
    public boolean insert(QueueContext context, Object arg) {
        QueueNormal nextState = new QueueNormal();
        context.setState(nextState);
        return nextState.insert(context, arg);
    }

    /**
     * Returns the first item in the queue. Returns null since the queue is 
     * empty.
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @return null.
     */
    public Object getFirst(QueueContext context) {
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
    public boolean removeFirst(QueueContext context) {
        return false;
    }
}
