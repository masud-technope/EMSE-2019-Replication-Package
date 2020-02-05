package ca.ubc.cs.spl.aspectPatterns.examples.iterator.java;

public interface SimpleList {

    /** 
     * Returns the number of elements in the list
     *
     * @return the number of elements in the list
     */
    public int count();

    /**
	 * Appends an object to the list
	 *
	 * @param o the object to append
	 * @return true if successful, false otherwise
	 */
    public boolean append(Object o);

    /**
	 * Removes an object from the list
	 *
	 * @param o the object to remove
	 * @return true if successful, false otherwise
	 */
    public boolean remove(Object o);

    /**
	 * Returns an object from the list at a given index
	 *
	 * @param index the position of the object
	 * @return the object at position index
	 */
    public Object get(int index);
}
