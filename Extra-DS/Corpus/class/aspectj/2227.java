package ca.ubc.cs.spl.aspectPatterns.examples.observer.java;

public interface ChangeSubject {

    /**
     * Attaches an <i>Observer</i> to this <i>Subject</i>.
     * 
     * @param o the <i>Observer</i> to add
     */
    public void addObserver(ChangeObserver o);

    /**
     * Detaches an <i>Observer</i> from this <i>Subject</i>.
     * 
     * @param o the <i>Observer</i> to remove
     */
    public void removeObserver(ChangeObserver o);

    /**
     * Notifies all <i>Observer</i>s.
     */
    public void notifyObservers();
}
