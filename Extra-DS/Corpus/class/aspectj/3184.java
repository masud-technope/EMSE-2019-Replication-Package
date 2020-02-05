package ca.ubc.cs.spl.aspectPatterns.examples.memento.java;

public class CounterMemento {

    /**
     * stores the <i>Originator</i>'s state
     */
    private int state;

    /**
     * Captures the <i>Originator</i>'s state and stores it
     *
     * @param newState the state to store
     */
    public void setState(int newState) {
        state = newState;
    }

    /**
     * Returns the stored <i>Originator</i> state
     *
     * @return the stored state
     */
    public int getState() {
        return state;
    }

    public  CounterMemento(int init) {
        state = init;
    }
}
