package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.java;

public class VariableExpression implements BooleanExpression {

    /** 
     * the name of the variable this object represents
     */
    protected String name = null;

    public  VariableExpression(String name) {
        this.name = name;
    }

    /**
	 * Accessor for the variable's name
	 *
	 * @return the name of the variable
	 */
    public String getName() {
        return name;
    }

    /**
     * Evaluates this <i>Expression</i> in the given <i>Context</i>
     *
     * @param c the context to evaluate the <i>Expression</i> in
     * @return the boolean value of the <i>Expression</i>
     */
    public boolean evaluate(VariableContext c) {
        return c.lookup(name);
    }

    /**
     * Replaces a variable with an <i>Expression</i>
     *
     * @param name the name of the variable
     * @param exp the <i>Expression</i> to replace the variable
     * @return a copy of this <i>Expression</i> with the variable replaced
     */
    public BooleanExpression replace(String name, BooleanExpression exp) {
        if (name.equals(this.name)) {
            return exp.copy();
        } else {
            return new VariableExpression(this.name);
        }
    }

    /**
     * Copies this <i>Expression</i>
     *
     * @return the copied <i>Expression</i>
     */
    public BooleanExpression copy() {
        return new VariableExpression(name);
    }
}
