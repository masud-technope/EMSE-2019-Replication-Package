package ca.ubc.cs.spl.aspectPatterns.examples.memento.java;

public class Main {

    /**
     * This example changes the state of the <i>Originator</i> five times, but
     * creates a <i>Memento</i> of it after the third change. After the 5 
     * changes are done, the <i>Memento</i> is used to restore the 
     * <i>Originator</i>'s state.  
     */
    public static void main(String[] args) {
        CounterMemento storedState = null;
        Counter counter = new Counter();
        for (int i = 1; i <= 5; i++) {
            counter.increment();
            counter.show();
            if (i == 3) {
                storedState = counter.createMemento();
            }
        }
        System.out.println("\nTrying to reinstate state (3)...");
        counter.setMemento(storedState);
        counter.show();
    }
}
