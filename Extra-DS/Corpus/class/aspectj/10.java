package ca.ubc.cs.spl.aspectPatterns.examples.iterator.java;

import java.util.Iterator;

public class ReverseIterator implements Iterator {

    /**
     * the positition of the current element
     */
    protected int current;

    /**
	 * the list this iterator operates on
	 */
    protected SimpleList list;

    /**
	 * Returns true if the iteration has more elements.
	 *
	 * @return true if the iteration has more elements
	 */
    public boolean hasNext() {
        return (current > 0);
    }

    /**
	 * This opional method is not implemented for this iterator.
	 */
    public void remove() {
        throw new UnsupportedOperationException("remove() not supported");
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration. 
     */
    public Object next() {
        if (!hasNext()) {
            throw new ArrayIndexOutOfBoundsException("Iterator out of Bounds");
        } else {
            return list.get(--current);
        }
    }

    public  ReverseIterator(SimpleList list) {
        super();
        this.list = list;
        current = list.count();
    }
}
