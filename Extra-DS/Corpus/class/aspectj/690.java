package org.aspectj.apache.bcel.generic;

/** 
 * SWAP - Swa top operand stack word
 * <PRE>Stack: ..., word2, word1 -&gt; ..., word1, word2</PRE>
 *
 * @version $Id: SWAP.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class SWAP extends StackInstruction implements StackConsumer, StackProducer {

    public  SWAP() {
        super(org.aspectj.apache.bcel.Constants.SWAP);
    }

    /**
   * Call corresponding visitor method(s). The order is:
   * Call visitor methods of implemented interfaces first, then
   * call methods according to the class hierarchy in descending order,
   * i.e., the most specific visitXXX() call comes last.
   *
   * @param v Visitor object
   */
    public void accept(Visitor v) {
        v.visitStackConsumer(this);
        v.visitStackProducer(this);
        v.visitStackInstruction(this);
        v.visitSWAP(this);
    }
}
