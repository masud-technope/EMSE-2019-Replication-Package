package org.aspectj.apache.bcel.generic;

/** 
 * LDC2_W - Push long or double from constant pool
 *
 * <PRE>Stack: ... -&gt; ..., item.word1, item.word2</PRE>
 *
 * @version $Id: LDC2_W.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class LDC2_W extends CPInstruction implements PushInstruction, TypedInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     LDC2_W() {
    }

    public  LDC2_W(int index) {
        super(org.aspectj.apache.bcel.Constants.LDC2_W, index);
    }

    public Type getType(ConstantPoolGen cpg) {
        switch(cpg.getConstantPool().getConstant(index).getTag()) {
            case org.aspectj.apache.bcel.Constants.CONSTANT_Long:
                return Type.LONG;
            case org.aspectj.apache.bcel.Constants.CONSTANT_Double:
                return Type.DOUBLE;
            default:
                // Never reached
                throw new RuntimeException("Unknown constant type " + opcode);
        }
    }

    public Number getValue(ConstantPoolGen cpg) {
        org.aspectj.apache.bcel.classfile.Constant c = cpg.getConstantPool().getConstant(index);
        switch(c.getTag()) {
            case org.aspectj.apache.bcel.Constants.CONSTANT_Long:
                return new Long(((org.aspectj.apache.bcel.classfile.ConstantLong) c).getBytes());
            case org.aspectj.apache.bcel.Constants.CONSTANT_Double:
                return new Double(((org.aspectj.apache.bcel.classfile.ConstantDouble) c).getBytes());
            default:
                // Never reached
                throw new RuntimeException("Unknown or invalid constant type at " + index);
        }
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
        v.visitCPInstruction(this);
        v.visitLDC2_W(this);
    }
}
