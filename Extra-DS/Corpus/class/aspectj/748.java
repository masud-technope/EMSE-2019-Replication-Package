package ca.ubc.cs.spl.aspectPatterns.examples.state.aspectj;

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

    /**
     * Tries to insert an object into the queue. Returns true if successful, 
     * false otherwiese. Potential state changes to "full" are facilitated 
     * by the aspect.
     *
     * @param arg the object to be inserted into the queue
     * @return true if insertion was successful, false otherwise.
     */
    public boolean insert(Object arg) {
        // Inserts a new Object into the queue
        items[(last) % items.length] = arg;
        last = (last + 1) % items.length;
        return true;
    }

    /**
     * Returns the first item in the queue. 
     *
     * @returns null.
     */
    public Object getFirst() {
        // Returns the first element in the queue 
        return items[first];
    }

    /**
     * Tries to remove an object from the queue. Returns true if successful,
     * false otherwiese. Potential state changes to "empty" are facilitated 
     * by the aspect.
     *
     * @return true if deletion was successful, false otherwise.
     */
    public boolean removeFirst() {
        // Removes the first element from the queue  
        first = (first + 1) % items.length;
        return true;
    }
}
