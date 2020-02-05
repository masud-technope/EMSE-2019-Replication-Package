package org.aspectj.apache.bcel.verifier.structurals;

public class Frame {

    /**
	 * For instance initialization methods, it is important to remember
	 * which instance it is that is not initialized yet. It will be
	 * initialized invoking another constructor later.
	 * NULL means the instance already *is* initialized.
	 */
    protected static UninitializedObjectType _this;

    /**
	 *
	 */
    private LocalVariables locals;

    /**
	 *
	 */
    private OperandStack stack;

    /**
	 *
	 */
    public  Frame(int maxLocals, int maxStack) {
        locals = new LocalVariables(maxLocals);
        stack = new OperandStack(maxStack);
    }

    /**
	 *
	 */
    public  Frame(LocalVariables locals, OperandStack stack) {
        this.locals = locals;
        this.stack = stack;
    }

    /**
	 *
	 */
    protected Object clone() {
        Frame f = new Frame(locals.getClone(), stack.getClone());
        return f;
    }

    /**
	 *
	 */
    public Frame getClone() {
        return (Frame) clone();
    }

    /**
	 *
	 */
    public LocalVariables getLocals() {
        return locals;
    }

    /**
	 *
	 */
    public OperandStack getStack() {
        return stack;
    }

    /**
	 *
	 */
    public boolean equals(Object o) {
        // implies "null" is non-equal.
        if (!(o instanceof Frame))
            return false;
        Frame f = (Frame) o;
        return this.stack.equals(f.stack) && this.locals.equals(f.locals);
    }

    /**
	 * Returns a String representation of the Frame instance.
	 */
    public String toString() {
        String s = "Local Variables:\n";
        s += locals;
        s += "OperandStack:\n";
        s += stack;
        return s;
    }
}
