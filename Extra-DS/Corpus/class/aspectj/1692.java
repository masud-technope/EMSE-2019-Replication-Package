package ca.ubc.cs.spl.aspectPatterns.examples.mediator.java;

public interface GUIMediator {

    /**
     * Defines the method signature for notifying <i>Mediator</i>s of changes 
     * to <i>Colleague</i>s. This method is called by colleagues who 
     * pass themselves as an argument (push model).
     *
     * @param colleague the changing colleage
     */
    public void colleagueChanged(GUIColleague colleague);
}
