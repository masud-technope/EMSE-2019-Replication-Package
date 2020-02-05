package org.aspectj.apache.bcel.generic;

/**
 * Denotes an unparameterized instruction to produce a value on top of the stack,
 * such as ILOAD, LDC, SIPUSH, DUP, ICONST, etc.
 *
 * @version $Id: PushInstruction.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>

 * @see ILOAD
 * @see ICONST
 * @see LDC
 * @see DUP
 * @see SIPUSH
 * @see GETSTATIC
 */
public interface PushInstruction extends StackProducer {
}
