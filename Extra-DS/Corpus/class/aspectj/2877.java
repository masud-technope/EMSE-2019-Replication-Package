package ca.ubc.cs.spl.aspectPatterns.examples.memento.aspectj;

public class Counter {

    /**
     * the number of times <code>increment()</code> was called on this object
     */
    protected int currentValue = 0;

    /**
	 * increments the counter (this <i>Originator</i>'s state) by one
	 */
    public void increment() {
        currentValue++;
    }

    /**
	 * Displays the state of this <i>Originator</i>
	 */
    public void show() {
        System.out.println("Originator value is " + currentValue);
    }
}
