package ca.ubc.cs.spl.aspectPatterns.examples.state.java;

public class QueueNormal implements QueueState {

    /**
     * stores the items in the queue
     */
    protected Object[] items = new Object[3];

    /**
     * stores the index of the first item in the queue
     */
    protected int first = 0;

    /**
     * stores the index of the last item in the queue
     */
    protected int last = 0;

    public  QueueNormal(Object[] items, int first, int last) {
        this.items = items;
        this.first = first;
        this.last = last;
    }

    public  QueueNormal() {
    }

    /**
     * Tries to insert an object into the queue. Returns true if successful, 
     * false otherwiese. If the queue is full
     * after the insertion, the state of the context is changed to "full".
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @param arg the object to be inserted into the queue
     * @return true if insertion was successful, false otherwise.
     */
    public boolean insert(QueueContext context, Object arg) {
        items[(last) % items.length] = arg;
        last = (last + 1) % items.length;
        if (first == last) {
            context.setState(new QueueFull(items, first));
        }
        return true;
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
     * false otherwiese. If the removed item was
     * the last one in the queue, the state of the context is changed to
     * "empty".
     *
     * @param context the <i>Context</i> for this design pattern (for update 
     * on demand)
     * @return true if deletion was successful, false otherwise.
     */
    public boolean removeFirst(QueueContext context) {
        first = (first + 1) % items.length;
        if (first == last) {
            context.setState(new QueueEmpty());
        }
        return true;
    }
}
