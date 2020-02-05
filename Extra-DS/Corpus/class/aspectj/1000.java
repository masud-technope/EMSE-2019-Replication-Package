package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.aspectj;

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
}
