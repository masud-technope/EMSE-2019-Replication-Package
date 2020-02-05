package ca.ubc.cs.spl.aspectPatterns.examples.interpreter.java;

import java.util.Hashtable;

public class VariableContext {

    /**
     * stores the mapping between variable names and values
     */
    protected Hashtable assignments = new Hashtable();

    /**
     * Returns the current value for a variable
     *
     * @param name the name of the variable
     * @return the value of the variable
     */
    public boolean lookup(String name) {
        Boolean value = (Boolean) assignments.get(name);
        if (value == null) {
            throw new ExpressionException("No variable \"" + name + "\" known.");
        }
        return value.booleanValue();
    }

    /**
	 * Assigns a boolean value to a <code>VariableExpression</code>
	 *
	 * @param varExp the varaible <i>Expression</i> to assign a value to
	 * @param bool the boolean value to assign 
	 */
    public void assign(VariableExpression varExp, boolean bool) {
        assignments.put(varExp.getName(), new Boolean(bool));
    }
}
