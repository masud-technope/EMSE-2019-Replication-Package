package org.aspectj.apache.bcel.generic;

/** 
 * DLOAD - Load double from local variable
 * <PRE>Stack ... -&gt; ..., result.word1, result.word2</PRE>
 *
 * @version $Id: DLOAD.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class DLOAD extends LoadInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     DLOAD() {
        super(org.aspectj.apache.bcel.Constants.DLOAD, org.aspectj.apache.bcel.Constants.DLOAD_0);
    }

    /** Load double from local variable
   * @param n index of local variable
   */
    public  DLOAD(int n) {
        super(org.aspectj.apache.bcel.Constants.DLOAD, org.aspectj.apache.bcel.Constants.DLOAD_0, n);
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
        v.visitDLOAD(this);
    }
}
