package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.aspectj;

public abstract interface BooleanExpression {

    /**
     * Evaluates this expression in the given <i>VariableContext</i>
     *
     * @param c the context to evaluate the <i>Expression</i> in
     * @return the boolean value of the <i>Expression</i>
     */
    public boolean evaluate(VariableContext c);

    /**
     * Replaces a variable with an <i>Expression</i>
     *
     * @param name the name of the variable
     * @param exp the <i>Expression</i> to replace the variable
     * @return a copy of this <i>Expression</i> with the variable replaced
     */
    public BooleanExpression replace(String name, BooleanExpression exp);

    /**
     * Copies this <i>Expression</i>
     *
     * @return the copied <i>Expression</i>
     */
    public BooleanExpression copy();
}
