package ca.ubc.cs.spl.aspectPatterns.examples.visitor.java;

public class BinaryTreeLeaf implements Visitable {

    /**
     * the value stored in this leaf
     */
    protected int value;

    /**
     * Accepts a visitor and calls <code>visitLeaf(Node) on it.
     *
     * @param visitor the NodeVisitor that is to be accepted.
     */
    public void accept(BinaryTreeVisitor visitor) {
        visitor.visitLeaf(this);
    }

    public  BinaryTreeLeaf(int value) {
        this.value = value;
    }

    /** 
	 * Accessor for the leaf's value
	 *
	 * @return the leaf's value
	 */
    public int getValue() {
        return value;
    }
}
