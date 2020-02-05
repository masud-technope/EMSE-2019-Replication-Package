package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.java;

public class Main {

    /** 
     * Assigns boolean values to two <code>VariableExpression</code>s 
     * and evaluates an expression in the given context.
     *
     * @param x a boolean variable expression
     * @param xValue the value to assign to x
     * @param y another boolean variable expression
     * @param yValue the value to assign to y
     * @param context the context to evaluate the expression in
     * @param exp the expression to evaluate
     */
    private static void assignAndEvaluate(VariableExpression x, boolean xValue, VariableExpression y, boolean yValue, VariableContext context, BooleanExpression exp) {
        context.assign(x, xValue);
        context.assign(y, yValue);
        boolean result = exp.evaluate(context);
        System.out.println("The result for (x=" + xValue + ", y=" + yValue + ") is: " + result);
    }

    /**
     * Implements the driver for the Intepreter design pattern example.<p> 
     *
     * @param command-line parameters, unused.
     */
    public static void main(String[] args) {
        BooleanExpression exp = null;
        VariableContext context = new VariableContext();
        VariableExpression x = new VariableExpression("X");
        VariableExpression y = new VariableExpression("Y");
        exp = new OrExpression(new AndExpression(new BooleanConstant(true), x), new AndExpression(y, new NotExpression(x)));
        System.out.println("Testing Expression: ((true & x) | (y & !x))");
        assignAndEvaluate(x, false, y, false, context, exp);
        assignAndEvaluate(x, false, y, true, context, exp);
        assignAndEvaluate(x, true, y, false, context, exp);
        assignAndEvaluate(x, true, y, true, context, exp);
        VariableExpression z = new VariableExpression("Z");
        NotExpression notZ = new NotExpression(z);
        BooleanExpression replacement = exp.replace("Y", notZ);
        context.assign(z, false);
        boolean result = replacement.evaluate(context);
        System.out.println("The result for the replacement is: " + result);
    }
}
