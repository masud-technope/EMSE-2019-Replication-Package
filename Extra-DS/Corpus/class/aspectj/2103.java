package ca.ubc.cs.spl.aspectPatterns.examples.visitor.java;

public class BinaryTreeNode implements Visitable {

    /**
     * the left subtree
     */
    protected Visitable left;

    /**
     * the right subtree
     */
    protected Visitable right;

    /**
     * Accepts a visitor and calls <code>visitRegularNode(Node) on it.
     *
     * @param visitor the NodeVisitor that is to be accepted.
     */
    public void accept(BinaryTreeVisitor visitor) {
        visitor.visitNode(this);
    }

    /**
	 * Accessor for the left subtree.
	 *
	 * @return the left subtree.
	 */
    public Visitable getLeft() {
        return left;
    }

    /**
	 * Accessor for the right subtree.
	 *
	 * @return the right subtree.
	 */
    public Visitable getRight() {
        return right;
    }

    public  BinaryTreeNode(Visitable left, Visitable right) {
        this.left = left;
        this.right = right;
    }
}
