package ca.ubc.cs.spl.aspectPatterns.examples.visitor.aspectj;

import ca.ubc.cs.spl.aspectPatterns.patternLibrary.VisitorProtocol;

public class TraversalVisitor implements VisitorProtocol.Visitor {

    /** 
     * contains the accumulated result
     */
    protected String result = "";

    /**
     * Visits a a non-terminal binary tree node.
     *
     * @param node the regular node
     */
    public void visitNode(VisitorProtocol.VisitableNode node) {
        if (node instanceof BinaryTreeNode) {
            BinaryTreeNode rnode = (BinaryTreeNode) node;
            result += "{";
            rnode.left.accept(this);
            result += ",";
            rnode.right.accept(this);
            result += "}";
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
            result += leaf.value;
        }
    }

    /** 
	 * Returns the result of the visitor's operation
	 *
	 * @return a string representing a traversal of the tree
	 */
    public String report() {
        return ">>> TraversalVisitor traversed the tree to: " + result;
    }
}
