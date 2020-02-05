package ca.ubc.cs.spl.aspectPatterns.examples.iterator.aspectj;

import java.util.Iterator;

public class Main {

    /**
     * Prints all elements in the iterator to <code>System.out</code>.
     *
     * @param iter the iterator which elements are to be printed
     */
    private static void print(Iterator iter) {
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /**
     * Implements the driver for the Iterator design pattern example.<p> 
     *
     * In this example, the concrete aggregate is a list that gets filled with 
     * five integer objects (1 to 5). The, the <code>ReverseIterator</code> is 
     * created and used to print all elements in reverse order.  
     *
     * @param args command line paramters, unused
     */
    public static void main(String[] args) {
        OpenList openList = new OpenList();
        openList.append(new Integer(1));
        openList.append(new Integer(2));
        openList.append(new Integer(3));
        openList.append(new Integer(4));
        openList.append(new Integer(5));
        System.out.println("List created, containing int objects 1, 2, 3, 4, 5.");
        Iterator iter = OpenListIteration.aspectOf().createIteratorFor(openList);
        System.out.println("Using ReverseIterator to print list elements in reverse order...");
        print(iter);
        System.out.println("done.");
    }
}
