package ca.ubc.cs.spl.aspectPatterns.examples.visitor.java;

public interface BinaryTreeVisitor {

    /**
     * Visits a non-terminal binary tree node.
     *
     * @param node the node to visit
     */
    public void visitNode(Visitable node);

    /**
     * Visits a leaf, which is a terminal tree node.
     *
     * @param node the leaf
     */
    public void visitLeaf(Visitable node);

    /** 
	 * Returns the result of the visitor's operation
	 *
	 * @return a string describing the result of this visitor's operation.
	 */
    public String report();
}
