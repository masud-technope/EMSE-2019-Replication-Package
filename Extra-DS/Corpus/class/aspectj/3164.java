package org.aspectj.apache.bcel.generic;

/** 
 * ACONST_NULL - Push null reference
 * <PRE>Stack: ... -&gt; ..., null</PRE>
 *
 * @version $Id: ACONST_NULL.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ACONST_NULL extends Instruction implements PushInstruction, TypedInstruction {

    /** 
   * Push null reference
   */
    public  ACONST_NULL() {
        super(org.aspectj.apache.bcel.Constants.ACONST_NULL, (short) 1);
    }

    /** @return Type.NULL
   */
    public Type getType(ConstantPoolGen cp) {
        return Type.NULL;
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
        v.visitStackProducer(this);
        v.visitPushInstruction(this);
        v.visitTypedInstruction(this);
        v.visitACONST_NULL(this);
    }
}
