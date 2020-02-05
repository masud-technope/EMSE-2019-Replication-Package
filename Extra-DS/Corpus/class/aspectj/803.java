package org.aspectj.apache.bcel.generic;

/** 
 * FSTORE - Store float into local variable
 * <PRE>Stack: ..., value -&gt; ... </PRE>
 *
 * @version $Id: FSTORE.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class FSTORE extends StoreInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     FSTORE() {
        super(org.aspectj.apache.bcel.Constants.FSTORE, org.aspectj.apache.bcel.Constants.FSTORE_0);
    }

    /** Store float into local variable
   * @param n index of local variable
   */
    public  FSTORE(int n) {
        super(org.aspectj.apache.bcel.Constants.FSTORE, org.aspectj.apache.bcel.Constants.FSTORE_0, n);
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
        v.visitFSTORE(this);
    }
}
