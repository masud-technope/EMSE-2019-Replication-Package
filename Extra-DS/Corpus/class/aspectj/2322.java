package ca.ubc.cs.spl.aspectPatterns.examples.composite.java;

import java.util.LinkedList;

public class Directory implements FileSystemComponent {

    /**
     * stores the children for this Directory (files and subdirectories)
     */
    // Component interface
    protected LinkedList children = new LinkedList();

    /**
     * stores the name of this Directory
     */
    protected String name;

    public  Directory(String name) {
        this.name = name;
    }

    /**
     * Overwrites the <code>toString()</code> method from <code>Object</code>
     * to print information about this Directory
     */
    public String toString() {
        return ("Directory: " + name);
    }

    /**
     * Adds a child to the component
     *
     * @param component the child to add
     */
    public void add(FileSystemComponent component) {
        this.children.add(component);
    }

    /**
     * Removes a child from the component
     *
     * @param component the child to remove
     */
    public void remove(FileSystemComponent component) {
        this.children.remove(component);
    }

    /**
     * Returns a child of the Directory at the given position
     *
     * @param index the position of the child
     */
    public FileSystemComponent getChild(int index) {
        return (FileSystemComponent) children.get(index);
    }

    /**
     * Returns the number of chilren this Directory has
     *
     * @returns the number of children of this Directory
     */
    public int getChildCount() {
        return children.size();
    }

    /**
	 * Returns the size of this Directory. For simplicity, we define that only
	 * files have a tangible size, so this method returns 0.
	 * 
	 * @return the size of the component (on disk)
	 */
    public int getSize() {
        return 0;
    }
}
