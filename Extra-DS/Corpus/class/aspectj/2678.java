package org.aspectj.apache.bcel.generic;

/** 
 * LCONST - Push 0 or 1, other values cause an exception
 *
 * <PRE>Stack: ... -&gt; ..., </PRE>
 *
 * @version $Id: LCONST.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class LCONST extends Instruction implements ConstantPushInstruction, TypedInstruction {

    private long value;

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     LCONST() {
    }

    public  LCONST(long l) {
        super(org.aspectj.apache.bcel.Constants.LCONST_0, (short) 1);
        if (l == 0)
            opcode = org.aspectj.apache.bcel.Constants.LCONST_0;
        else if (l == 1)
            opcode = org.aspectj.apache.bcel.Constants.LCONST_1;
        else
            throw new ClassGenException("LCONST can be used only for 0 and 1: " + l);
        value = l;
    }

    public Number getValue() {
        return new Long(value);
    }

    /** @return Type.LONG
   */
    public Type getType(ConstantPoolGen cp) {
        return Type.LONG;
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
        v.visitLCONST(this);
    }
}
