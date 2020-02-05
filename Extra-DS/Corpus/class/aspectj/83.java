package org.aspectj.apache.bcel.generic;

/**
 * Denotes an unparameterized instruction to store a value into a local variable,
 * e.g. ISTORE.
 *
 * @version $Id: StoreInstruction.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class StoreInstruction extends LocalVariableInstruction implements PopInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   * tag and length are defined in readInstruction and initFromFile, respectively.
   */
     StoreInstruction(short canon_tag, short c_tag) {
        super(canon_tag, c_tag);
    }

    /**
   * @param opcode Instruction opcode
   * @param c_tag Instruction number for compact version, ASTORE_0, e.g.
   * @param n local variable index (unsigned short)
   */
    protected  StoreInstruction(short opcode, short c_tag, int n) {
        super(opcode, c_tag, n);
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
        v.visitStackConsumer(this);
        v.visitPopInstruction(this);
        v.visitTypedInstruction(this);
        v.visitLocalVariableInstruction(this);
        v.visitStoreInstruction(this);
    }
}
