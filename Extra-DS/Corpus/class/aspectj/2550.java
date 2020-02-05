package ca.ubc.cs.spl.aspectPatterns.examples.iterator.java;

import java.util.Iterator;

public class OpenList implements SimpleList {

    java.util.LinkedList list = new java.util.LinkedList();

    /** 
     * Returns the number of elements in the list
     *
     * @return the number of elements in the list
     */
    public int count() {
        return list.size();
    }

    /**
	 * Appends an object to the list. Since this is an open list, inserting 
	 * elements is assumed to succeed.
	 *
	 * @param o the object to append
	 * @return true if successful, false otherwise
	 */
    public boolean append(Object o) {
        list.addLast(o);
        return true;
    }

    /**
	 * Removes an object from the list
	 *
	 * @param o the object to remove
	 * @return true if successful, false otherwise
	 */
    public boolean remove(Object o) {
        return list.remove(o);
    }

    /**
	 * Returns an object from the list
	 *
	 * @param index the position of the object
	 * @return the object at the specified index  
	 */
    public Object get(int index) {
        return list.get(index);
    }

    /**
	 * Returns a reverse iterator for this list. 
	 *
	 * @return the a reverse iterator for this list
	 */
    public Iterator createReverseIterator() {
        return new ReverseIterator(this);
    }
}
