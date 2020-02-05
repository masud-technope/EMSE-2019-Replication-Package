package org.aspectj.apache.bcel.generic;

/**
 * Denote an instruction that may consume a value from the stack.
 *
 * @version $Id: StackConsumer.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface StackConsumer {

    /** @return how many words are consumed from stack
   */
    public int consumeStack(ConstantPoolGen cpg);
}
