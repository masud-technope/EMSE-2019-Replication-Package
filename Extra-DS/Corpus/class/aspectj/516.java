package org.aspectj.apache.bcel.verifier.statics;

import java.util.ArrayList;

/**
 * A small utility class representing a set of basic int values.
 *
 * @version $Id: IntList.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class IntList {

    /** The int are stored as Integer objects here. */
    private ArrayList theList;

    /** This constructor creates an empty list. */
     IntList() {
        theList = new ArrayList();
    }

    /** Adds an element to the list. */
    void add(int i) {
        theList.add(new Integer(i));
    }

    /** Checks if the specified int is already in the list. */
    boolean contains(int i) {
        Integer[] ints = new Integer[theList.size()];
        theList.toArray(ints);
        for (int j = 0; j < ints.length; j++) {
            if (i == ints[j].intValue())
                return true;
        }
        return false;
    }
}
