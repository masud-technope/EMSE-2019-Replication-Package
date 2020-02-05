package org.aspectj.apache.bcel.generic;

/**
 * Super class for stack operations like DUP and POP.
 *
 * @version $Id: StackInstruction.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class StackInstruction extends Instruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     StackInstruction() {
    }

    /**
   * @param opcode instruction opcode
   */
    protected  StackInstruction(short opcode) {
        super(opcode, (short) 1);
    }

    /** @return Type.UNKNOWN
   */
    public Type getType(ConstantPoolGen cp) {
        return Type.UNKNOWN;
    }
}
