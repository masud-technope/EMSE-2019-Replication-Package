package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.aspectj;

public class NotExpression implements BooleanExpression {

    /** 
     * the <i>Expression</i> this <i>Expression</i> negates
     */
    protected BooleanExpression exp = null;

    public  NotExpression(BooleanExpression exp) {
        this.exp = exp;
    }

    /**
     * Evaluates this <i>Expression</i> in the given 
     * <i>Context</i>
     *
     * @param c the context to evaluate the <i>Expression</i> in
     * @return the boolean value of the <i>Expression</i>
     */
    public boolean evaluate(VariableContext c) {
        return (!exp.evaluate(c));
    }
}
