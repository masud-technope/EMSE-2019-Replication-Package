package org.aspectj.apache.bcel.generic;

/** 
 * Super class for GOTO
 *
 * @version $Id: GotoInstruction.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class GotoInstruction extends BranchInstruction implements UnconditionalBranch {

     GotoInstruction(short opcode, InstructionHandle target) {
        super(opcode, target);
    }

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     GotoInstruction() {
    }
}
