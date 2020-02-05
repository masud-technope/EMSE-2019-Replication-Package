package ca.ubc.cs.spl.aspectPatterns.examples.composite.aspectj;

public class File {

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
	 * Returns the size of this File
	 * 
	 * @return the size of this File (on disk)
	 */
    public int getSize() {
        return size;
    }
}
