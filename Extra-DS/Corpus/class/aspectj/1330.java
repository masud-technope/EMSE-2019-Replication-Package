package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.aspectj;

public class AndExpression implements BooleanExpression {

    /**
     * stores the first part of this AND <i>Expression</i>
     */
    protected BooleanExpression expression1;

    /**
     * stores the second part of this AND <i>Expression</i>
     */
    protected BooleanExpression expression2;

    public  AndExpression(BooleanExpression op1, BooleanExpression op2) {
        this.expression1 = op1;
        this.expression2 = op2;
    }

    /**
     * Evaluates this <i>Expression</i> in the given <i>Context</i>
     *
     * @param c the context to evaluate the <i>Expression</i> in
     * @return the boolean value of the <i>Expression</i>
     */
    public boolean evaluate(VariableContext c) {
        return (expression1.evaluate(c) && expression2.evaluate(c));
    }
}
