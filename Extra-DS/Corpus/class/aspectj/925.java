package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.aspectj;

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
     * @param c the context to evaluate the <i>Expression</i> in
     * @return the boolean value of the <i>Expression</i>
     */
    public boolean evaluate(VariableContext c) {
        return value;
    }
}
