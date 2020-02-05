package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.java;

public class OrExpression implements BooleanExpression {

    /**
     * stores the first part of this OR <i>Expression</i>
     */
    protected BooleanExpression expression1;

    /**
     * stores the second part of this OR <i>Expression</i>
     */
    protected BooleanExpression expression2;

    public  OrExpression(BooleanExpression op1, BooleanExpression op2) {
        this.expression1 = op1;
        this.expression2 = op2;
    }

    /**
     * Evaluates this <i>Expression</i> in the given <i>Context</i>
     *
     * @param c the context to evaluate the <i>Expression</i> in
     * @returns the boolean value of the <i>Expression</i>
     */
    public boolean evaluate(VariableContext c) {
        return (expression1.evaluate(c) || expression2.evaluate(c));
    }

    /**
     * Replaces a variable with an <i>Expression</i>
     *
     * @param name the name of the variable
     * @param exp the <i>Expression</i> to replace the variable
     * @returns a copy of this <i>Expression</i> with the variable replaced
     */
    public BooleanExpression replace(String name, BooleanExpression exp) {
        return new OrExpression(expression1.replace(name, exp), expression2.replace(name, exp));
    }

    /**
     * Copies this <i>Expression</i>
     *
     * @returns the copied <i>Expression</i>
     */
    public BooleanExpression copy() {
        return new OrExpression(expression1.copy(), expression2.copy());
    }
}
