package ca.ubc.cs.spl.aspectPatterns.examples.composite.java;

public class File implements FileSystemComponent {

    /**
     * stores the name for this File
     */
    protected String name;

    /**
	 * stores the size for this File
	 */
    protected int size;

    public  File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Overwrites the <code>toString()</code> method from <code>Object</code>
     * to print information about this object
     */
    public String toString() {
        return ("File: " + name + " (" + size + " KB)");
    }

    /**
     * Adds a child to the Component. Since Files have no
     * children, this method does nothing.
     *
     * @param component the child to add
     */
    public void add(FileSystemComponent component) {
    }

    /**
     * Removes a child from the Component. Since Files have no
     * children, this method does nothing.
     *
     * @param component the child to add
     */
    public void remove(FileSystemComponent component) {
    }

    /**
     * Returns a child of the Component. Since Files are <i>Leaf</i>s, they
     * don't have any children. Thus, this method returns null.
     *
     * @param index the position of the child
     * @return always null, since Files do not have children
     */
    public FileSystemComponent getChild(int index) {
        return null;
    }

    /**
     * Returns the number of chilren this Component has. Since Files 
     * are <i>Leaf</i>s, they don't have any children. Thus, this method 
     * returns 0.
     *
     * @returns always 0, since Files do not have children
     */
    public int getChildCount() {
        return 0;
    }

    /**
	 * Returns the size of this File
	 * 
	 * @return the size of this File (on disk)
	 */
    public int getSize() {
        return size;
    }
}
