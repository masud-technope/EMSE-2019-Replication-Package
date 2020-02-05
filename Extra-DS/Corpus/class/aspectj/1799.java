package ca.ubc.cs.spl.aspectPatterns.examples.composite.aspectj;

public class Directory {

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
}
