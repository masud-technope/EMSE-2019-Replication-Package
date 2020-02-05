package ca.ubc.cs.spl.aspectPatterns.examples.visitor.java;

public class TraversalVisitor implements BinaryTreeVisitor {

    /** 
     * contains the accumulated result
     */
    protected String result = "";

    /**
     * Visits a non-terminal binary tree node.
     *
     * @param node the regular node
     */
    public void visitNode(Visitable node) {
        BinaryTreeNode rnode = (BinaryTreeNode) node;
        result += "{";
        rnode.getLeft().accept(this);
        result += ",";
        rnode.getRight().accept(this);
        result += "}";
    }

    /**
     * Visits a terminal tree node.
     *
     * @param node the leaf
     */
    public void visitLeaf(Visitable node) {
        BinaryTreeLeaf leaf = (BinaryTreeLeaf) node;
        result += leaf.getValue();
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
