package org.aspectj.apache.bcel.generic;

/** 
 * ICONST - Push value between -1, ..., 5, other values cause an exception
 *
 * <PRE>Stack: ... -&gt; ..., </PRE>
 *
 * @version $Id: ICONST.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ICONST extends Instruction implements ConstantPushInstruction, TypedInstruction {

    private int value;

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     ICONST() {
    }

    public  ICONST(int i) {
        super(org.aspectj.apache.bcel.Constants.ICONST_0, (short) 1);
        if ((i >= -1) && (i <= 5))
            // Even works for i == -1
            opcode = (short) (org.aspectj.apache.bcel.Constants.ICONST_0 + i);
        else
            throw new ClassGenException("ICONST can be used only for value between -1 and 5: " + i);
        value = i;
    }

    public Number getValue() {
        return new Integer(value);
    }

    /** @return Type.INT
   */
    public Type getType(ConstantPoolGen cp) {
        return Type.INT;
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
        v.visitPushInstruction(this);
        v.visitStackProducer(this);
        v.visitTypedInstruction(this);
        v.visitConstantPushInstruction(this);
        v.visitICONST(this);
    }
}
