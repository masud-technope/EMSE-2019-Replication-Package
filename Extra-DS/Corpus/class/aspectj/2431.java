package ca.ubc.cs.spl.aspectPatterns.examples.visitor.aspectj;

public class BinaryTreeLeaf implements Visitable {

    /**
     * the value stored in this leaf
     */
    protected int value;

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
