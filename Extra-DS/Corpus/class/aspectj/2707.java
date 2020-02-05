package ca.ubc.cs.spl.aspectPatterns.examples.observer.java;

import java.util.HashSet;
import java.util.Iterator;

public class Screen implements ChangeSubject, ChangeObserver {

    /**
     * stores the <i>Observer</i>s for this screen (<i>Subject</i>)
     */
    private HashSet observers;

    /**
     * the individual name of this screen object
     */
    private String name;

    public  Screen(String s) {
        this.name = s;
        observers = new HashSet();
    }

    /**
     * Prints the name of the <code>Screen</code> object and the argument 
     * string to stdout.
     *
     * @param s the string to print
     */
    public void display(String s) {
        System.out.println(name + ": " + s);
        notifyObservers();
    }

    /**
	 * Attaches an <i>Observer</i> to this <i>Subject</i>.
	 * 
	 * @param o the <i>Observer</i> to attach
	 */
    public void addObserver(ChangeObserver o) {
        this.observers.add(o);
    }

    /**
	 * Detaches an <i>Observer</i> from this <i>Subject</i>.
	 * 
	 * @param o the <i>Observer</i> to detach
	 */
    public void removeObserver(ChangeObserver o) {
        this.observers.remove(o);
    }

    /**
	 * Notifies all <i>Observer</i>s.
	 */
    public void notifyObservers() {
        for (Iterator e = observers.iterator(); e.hasNext(); ) {
            ((ChangeObserver) e.next()).refresh(this);
        }
    }

    /**
	 * Updates an <i>Observer</i>. Uses the <i>push</i> strategy (i.e. the
	 * subject triggering the update passes itself as an argument).
	 * 
	 * This particular method prints a message showing what object caused
	 * the update 
	 *
	 * @param s the <i>Subject</i> triggering the update
	 */
    public void refresh(ChangeSubject s) {
        String subjectTypeName = s.getClass().getName();
        subjectTypeName = subjectTypeName.substring(subjectTypeName.lastIndexOf(".") + 1, subjectTypeName.length());
        display("update received from a " + subjectTypeName + " object");
    }
}
