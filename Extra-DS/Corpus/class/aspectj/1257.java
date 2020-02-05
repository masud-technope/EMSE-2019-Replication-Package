package ca.ubc.cs.spl.aspectPatterns.patternLibrary;

public interface Memento {

    /**
	 * Sets the state of this <i>Memento</i> give the passed state.
	 * 
	 * 
	 * @param state the state to store
	 */
    public void setState(Object state);

    /**
	 * Returns the state of this <i>Memento</i> give the passed originator.
	 * 
	 * @return the state stored by this <i>Memento</i>
	 */
    public Object getState();
}
