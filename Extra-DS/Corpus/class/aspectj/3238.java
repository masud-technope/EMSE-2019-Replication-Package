package org.aspectj.apache.bcel.generic;

/** 
 * FLOAD - Load float from local variable
 * <PRE>Stack ... -&gt; ..., result</PRE>
 *
 * @version $Id: FLOAD.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class FLOAD extends LoadInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     FLOAD() {
        super(org.aspectj.apache.bcel.Constants.FLOAD, org.aspectj.apache.bcel.Constants.FLOAD_0);
    }

    /** Load float from local variable
   * @param n index of local variable
   */
    public  FLOAD(int n) {
        super(org.aspectj.apache.bcel.Constants.FLOAD, org.aspectj.apache.bcel.Constants.FLOAD_0, n);
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
        v.visitFLOAD(this);
    }
}
