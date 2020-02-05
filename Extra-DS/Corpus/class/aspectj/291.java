package ca.ubc.cs.spl.aspectPatterns.examples.visitor.java;

public class SummationVisitor implements BinaryTreeVisitor {

    /**
     * the colleced sum of leaf values
     */
    protected int sum = 0;

    /**
     * Visits a non-terminal binary tree node.
     *
     * @param node the regular node
     */
    public void visitNode(Visitable node) {
        BinaryTreeNode rnode = (BinaryTreeNode) node;
        rnode.left.accept(this);
        rnode.right.accept(this);
    }

    /**
     * Visits a terminal tree node.
     *
     * @param node the leaf
     */
    public void visitLeaf(Visitable node) {
        BinaryTreeLeaf leaf = (BinaryTreeLeaf) node;
        sum += leaf.getValue();
    }

    /** 
	 * Returns the result of the visitor's operation
	 *
	 * @return a string representation of the sum of leaf values
	 */
    public String report() {
        return ">>> SummationVisitor collected a sum of: " + sum;
    }
}
