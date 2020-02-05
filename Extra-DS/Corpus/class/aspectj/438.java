package org.aspectj.apache.bcel.generic;

/** 
 * DUP_X1 - Duplicate top operand stack word and put two down
 * <PRE>Stack: ..., word2, word1 -&gt; ..., word1, word2, word1</PRE>
 *
 * @version $Id: DUP_X1.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class DUP_X1 extends StackInstruction {

    public  DUP_X1() {
        super(org.aspectj.apache.bcel.Constants.DUP_X1);
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
        v.visitDUP_X1(this);
    }
}
