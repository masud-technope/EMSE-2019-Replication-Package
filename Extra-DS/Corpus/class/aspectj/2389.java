package ca.ubc.cs.spl.aspectPatterns.examples.observer.java;

public interface ChangeObserver {

    /**
     * Updates an <i>Observer</i>. Uses the <i>push</i> strategy (i.e. the
     * subject triggering the update passes itself as an argument).
     *
     * @param s the <i>Subject</i> triggering the update
     */
    public void refresh(ChangeSubject s);
}
