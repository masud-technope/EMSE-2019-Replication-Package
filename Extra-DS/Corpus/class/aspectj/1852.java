package org.aspectj.apache.bcel.generic;

/** 
 * LSTORE - Store long into local variable
 * <PRE>Stack: ..., value.word1, value.word2 -&gt; ... </PRE>
 *
 * @version $Id: LSTORE.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class LSTORE extends StoreInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     LSTORE() {
        super(org.aspectj.apache.bcel.Constants.LSTORE, org.aspectj.apache.bcel.Constants.LSTORE_0);
    }

    public  LSTORE(int n) {
        super(org.aspectj.apache.bcel.Constants.LSTORE, org.aspectj.apache.bcel.Constants.LSTORE_0, n);
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
        super.accept(v);
        v.visitLSTORE(this);
    }
}
