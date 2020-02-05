package ca.ubc.cs.spl.aspectPatterns.examples.composite.java;

public interface FileSystemComponent {

    /**
     * Adds a child to the component
     *
     * @param component the child to add
     */
    public void add(FileSystemComponent component);

    /**
     * Removes a child from the component
     *
     * @param component the child to remove
     */
    public void remove(FileSystemComponent component);

    /**
     * Returns the child of the component ath the given position
     *
     * @param index the position of the child
     */
    public FileSystemComponent getChild(int index);

    /**
     * Returns the number of chilren a component has
     *
     * @returns the number of children of this component
     */
    public int getChildCount();

    /**
	 * Returns the size of this FileSystemComponent
	 * 
	 * @return the size of the component (on disk)
	 */
    public int getSize();
}
