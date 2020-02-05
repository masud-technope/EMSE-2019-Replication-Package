package org.aspectj.apache.bcel.generic;

/** 
 * ISTORE - Store int from stack into local variable
 * <PRE>Stack: ..., value -&gt; ... </PRE>
 *
 * @version $Id: ISTORE.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ISTORE extends StoreInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     ISTORE() {
        super(org.aspectj.apache.bcel.Constants.ISTORE, org.aspectj.apache.bcel.Constants.ISTORE_0);
    }

    /** Store int into local variable
   * @param n index of local variable
   */
    public  ISTORE(int n) {
        super(org.aspectj.apache.bcel.Constants.ISTORE, org.aspectj.apache.bcel.Constants.ISTORE_0, n);
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
        v.visitISTORE(this);
    }
}
