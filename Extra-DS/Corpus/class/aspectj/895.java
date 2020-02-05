package org.aspectj.apache.bcel.generic;

/**
 * Denotes a push instruction that produces a literal on the stack
 * such as  SIPUSH, BIPUSH, ICONST, etc.
 *
 * @version $Id: ConstantPushInstruction.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>

 * @see ICONST
 * @see SIPUSH
 */
public interface ConstantPushInstruction extends PushInstruction, TypedInstruction {

    public Number getValue();
}
