package ca.ubc.cs.spl.aspectPatterns.examples.visitor.java;

public interface Visitable {

    /**
     * Accepts a <i>Visitor</i>.
     *
     * @param visitor the NodeVisitor that is to be accepted.
     */
    public void accept(BinaryTreeVisitor visitor);
}
