package org.aspectj.apache.bcel.generic;

/** 
 * DUP_X2 - Duplicate top operand stack word and put three down
 * <PRE>Stack: ..., word3, word2, word1 -&gt; ..., word1, word3, word2, word1</PRE>
 *
 * @version $Id: DUP_X2.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class DUP_X2 extends StackInstruction {

    public  DUP_X2() {
        super(org.aspectj.apache.bcel.Constants.DUP_X2);
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
        v.visitStackInstruction(this);
        v.visitDUP_X2(this);
    }
}
