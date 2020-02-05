package ca.ubc.cs.spl.aspectPatterns.examples.mediator.java;

public interface GUIColleague {

    /**
     * Defines the method signature for setting a <i>Colleague</i>'s 
     * <i>Mediator</i>.
     *
     * @param mediator the new mediator
     */
    public void setMediator(GUIMediator mediator);
}
