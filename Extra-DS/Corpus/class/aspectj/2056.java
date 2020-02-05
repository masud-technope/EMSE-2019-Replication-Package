package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.java;

public class NotExpression implements BooleanExpression {

    /** 
     * the <i>Expression</i> this <i>Expression</i> negates
     */
    protected BooleanExpression exp = null;

    public  NotExpression(BooleanExpression exp) {
        this.exp = exp;
    }

    /**
     * Evaluates this <i>Expression</i> in the given <i>Context</i>
     *
     * @param c the context to evaluate the <i>Expression</i> in
     * @return the boolean value of the <i>Expression</i>
     */
    public boolean evaluate(VariableContext c) {
        return (!exp.evaluate(c));
    }

    /**
     * Replaces a variable with an <i>Expression</i>
     *
     * @param name the name of the variable
     * @param exp the <i>Expression</i> to replace the variable
     * @return a copy of this <i>Expression</i> with the variable replaced
     */
    public BooleanExpression replace(String name, BooleanExpression exp) {
        return new NotExpression(this.exp.replace(name, exp));
    }

    /**
     * Copies this <i>Expression</i>
     *
     * @returns the copied <i>Expression</i>
     */
    public BooleanExpression copy() {
        return new NotExpression(exp.copy());
    }
}
