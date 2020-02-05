package ca.ubc.cs.spl.aspectPatterns.examples.composite.java;

public class Main {

    /**
	 * helper variable to store recursion depth for pretty printing
	 */
    private static int indent = 0;

    /**
     * Prints a number of spaces according to the current recursion depth
     */
    private static void indent() {
        for (int i = 0; i < indent; i++) System.out.print(" ");
    }

    /** 
     * Pretty-prints a recursive composite structure 
     *
     * @param comp the component denoting the entry point into the structure
     */
    private static void printStructure(FileSystemComponent comp) {
        indent();
        System.out.println(comp);
        indent += 4;
        for (int i = 0; i < comp.getChildCount(); i++) {
            printStructure(comp.getChild(i));
        }
        indent -= 4;
    }

    /**
     * This example creates a simple structure as follows: Composite directory1 
 	 * has three children: file1, directory2, and file3. directory2 has file2 
 	 * as a child.
     */
    public static void main(String[] args) {
        System.out.println("\n<<< Sample OOP implementation of Composite pattern >>>\n");
        System.out.print("Creating Composite structure ...\n");
        Directory directory1 = new Directory("Directory1");
        Directory directory2 = new Directory("Directory2");
        File file1 = new File("File1", 123);
        File file2 = new File("File2", 4556);
        File file3 = new File("File3", 16);
        directory1.add(file1);
        directory1.add(directory2);
        directory2.add(file2);
        directory1.add(file3);
        System.out.println("done.");
        System.out.println("This is the Structure:");
        printStructure(directory1);
        System.out.println("\n<<< Test completed >>>\n");
    }
}
