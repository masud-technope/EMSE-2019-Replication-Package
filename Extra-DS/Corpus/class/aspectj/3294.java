package ca.ubc.cs.spl.aspectPatterns.examples.state.java;

public class Main {

    /**
     * Implements insertion into a queue. Prints out status messages.
     *
     * @param queue the queue to insert into
     * @param s the string to insert into the queue
     */
    private static void testInsert(Queue queue, String s) {
        System.out.print("   Trying to insert [" + s + "] into the queue ... ");
        boolean status = queue.insert(s);
        if (status == true) {
            System.out.println("successful");
        } else {
            System.out.println("NOT successful, queue probably full");
        }
    }

    /**
     * Implements deletion from a queue. Prints out status messages.
     *
     * @param queue the queue to delete items from
     */
    private static void testRemove(Queue queue) {
        System.out.print("   Trying to remove 1st element of the queue ... ");
        String item = (String) queue.getFirst();
        boolean status = queue.removeFirst();
        if (status == true) {
            System.out.println("successful: " + item);
        } else {
            System.out.println("NOT successful: " + item);
        }
    }

    /**
     * Implements the driver for the State design pattern example.<p> 
     *
     * @param args the command line paramters, unused
     */
    public static void main(String[] args) {
        System.out.println("Testing Pattern: State - STARTING\n");
        Queue queue = new Queue();
        testInsert(queue, "This ");
        testInsert(queue, "is ");
        testInsert(queue, "a ");
        testInsert(queue, "test");
        System.out.println();
        testRemove(queue);
        testRemove(queue);
        testRemove(queue);
        testRemove(queue);
        System.out.println("\nTesting Pattern: State - FINISHED");
    }
}
