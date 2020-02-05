package org.aspectj.apache.bcel.generic;

/**
 * Denotes an unparameterized instruction to pop a value on top from the stack,
 * such as ISTORE, POP, PUTSTATIC.
 *
 * @version $Id: PopInstruction.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @see ISTORE
 * @see POP
 */
public interface PopInstruction extends StackConsumer {
}
