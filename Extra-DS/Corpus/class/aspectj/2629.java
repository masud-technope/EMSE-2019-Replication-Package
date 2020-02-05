package ca.ubc.cs.spl.aspectPatterns.examples.visitor.aspectj;

import ca.ubc.cs.spl.aspectPatterns.patternLibrary.VisitorProtocol;

public class SummationVisitor implements VisitorProtocol.Visitor {

    /**
     * the colleced sum of leaf values
     */
    protected int sum = 0;

    /**
     * Visits a non-terminal binary tree node.
     *
     * @param node the regular node
     */
    public void visitNode(VisitorProtocol.VisitableNode node) {
        if (node instanceof BinaryTreeNode) {
            BinaryTreeNode rnode = (BinaryTreeNode) node;
            rnode.left.accept(this);
            rnode.right.accept(this);
        }
    }

    /**
     * Visits a terminal tree node.
     *
     * @param node the leaf
     */
    public void visitLeaf(VisitorProtocol.VisitableNode node) {
        if (node instanceof BinaryTreeLeaf) {
            BinaryTreeLeaf leaf = (BinaryTreeLeaf) node;
            sum += leaf.getValue();
        }
    }

    /** 
	 * Returns the result of the visitor's operation
	 *
	 * @return a string representing the sum of elemnent in the tree's leaves
	 */
    public String report() {
        return ">>> SumVisitor collected a sum of " + sum;
    }
}
