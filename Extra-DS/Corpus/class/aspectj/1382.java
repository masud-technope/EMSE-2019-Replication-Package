package ca.ubc.cs.spl.aspectPatterns.examples.memento.aspectj;

import ca.ubc.cs.spl.aspectPatterns.patternLibrary.Memento;

public class Main {

    /**
     * This example changes the state of the <i>Originator</i> five times, but
     * creates a <i>Memento</i> of it after the third change. After the 5 
     * changes are done, the <i>Memento</i> is used to restore the 
     * <i>Originator</i>'s state.  
     * 
     * @param args command line parameters, unused.
     */
    public static void main(String[] args) {
        Memento storedState = null;
        Counter counter = new Counter();
        for (int i = 1; i <= 5; i++) {
            counter.increment();
            counter.show();
            if (i == 3) {
                storedState = CounterMemento.aspectOf().createMementoFor(counter);
            }
        }
        System.out.println("\nTrying to reinstate state (3)...");
        CounterMemento.aspectOf().setMemento(counter, storedState);
        counter.show();
    }
}
