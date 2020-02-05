package ca.ubc.cs.spl.aspectPatterns.examples.memento.java;

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

    /**
     * Creates a <i>Memento</i> from this <i>Originator</i>, storing the 
     * current state
     */
    public CounterMemento createMemento() {
        return new CounterMemento(currentValue);
    }

    /**
     * Restores this <i>Originator</i> to former state stored by the 
     * memento passed
     *
     * @param memento the <i>Memento</i> that stores the prior state
     */
    public void setMemento(CounterMemento memento) {
        currentValue = memento.getState();
    }
}
