package org.aspectj.apache.bcel.generic;

/**
 * Super class for the IFxxx family of instructions.
 *
 * @version $Id: IfInstruction.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class IfInstruction extends BranchInstruction implements StackConsumer {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     IfInstruction() {
    }

    /**
   * @param instruction Target instruction to branch to
   */
    protected  IfInstruction(short opcode, InstructionHandle target) {
        super(opcode, target);
    }

    /**
   * @return negation of instruction, e.g. IFEQ.negate() == IFNE
   */
    public abstract IfInstruction negate();
}
