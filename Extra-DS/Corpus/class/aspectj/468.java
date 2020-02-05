package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.java;

public class BooleanConstant implements BooleanExpression {

    /**
     * the value of this constant
     */
    protected boolean value;

    public  BooleanConstant(boolean value) {
        this.value = value;
    }

    /**
     * Evaluates this <i>Expression</i> in the given <i>Context</i>.
     *
     * @param c the <i>Context</i> to evaluate the <i>Expression</i> in
     * @return the boolean value of the <i>Expression</i>
     */
    public boolean evaluate(VariableContext c) {
        return value;
    }

    /**
     * Replaces a variable with an <i>Expression</i>. 
     * Has no effect on constants.
     *
     * @param name the name of the variable
     * @param exp the <i>Expression</i> to replace the variable
     * @return the unchanged constant
     */
    public BooleanExpression replace(String name, BooleanExpression exp) {
        return this;
    }

    /**
     * Copies this <i>Expression</i>
     *
     * @return the copied <i>Expression</i>
     */
    public BooleanExpression copy() {
        return new BooleanConstant(value);
    }
}
