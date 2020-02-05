package org.aspectj.apache.bcel.generic;

/** 
 * DSTORE - Store double into local variable
 * <pre>Stack: ..., value.word1, value.word2 -&gt; ... </PRE>
 *
 * @version $Id: DSTORE.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class DSTORE extends StoreInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     DSTORE() {
        super(org.aspectj.apache.bcel.Constants.DSTORE, org.aspectj.apache.bcel.Constants.DSTORE_0);
    }

    /** Store double into local variable
   * @param n index of local variable
   */
    public  DSTORE(int n) {
        super(org.aspectj.apache.bcel.Constants.DSTORE, org.aspectj.apache.bcel.Constants.DSTORE_0, n);
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
        v.visitDSTORE(this);
    }
}
