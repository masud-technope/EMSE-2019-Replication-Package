package org.aspectj.apache.bcel.generic;

/**
 * Denote an instruction that may produce a value on top of the stack
 * (this excludes DUP_X1, e.g.)
 *
 * @version $Id: StackProducer.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface StackProducer {

    /** @return how many words are produced on stack
   */
    public int produceStack(ConstantPoolGen cpg);
}
