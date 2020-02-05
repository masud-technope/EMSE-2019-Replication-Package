package org.aspectj.apache.bcel.generic;

/**
 * Equality of instructions isn't clearly to be defined. You might
 * wish, for example, to compare whether instructions have the same
 * meaning. E.g., whether two INVOKEVIRTUALs describe the same
 * call.<br>The DEFAULT comparator however, considers two instructions
 * to be equal if they have same opcode and point to the same indexes
 * (if any) in the constant pool or the same local variable index. Branch
 * instructions must have the same target.
 *
 * @see Instruction
 * @version $Id: InstructionComparator.java,v 1.3 2005/09/21 16:28:36 acolyer Exp $
 * @author <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface InstructionComparator {

    public static final InstructionComparator DEFAULT = new InstructionComparator() {

        public boolean equals(Instruction i1, Instruction i2) {
            if (i1.opcode == i2.opcode) {
                if (i1 instanceof Select) {
                    InstructionHandle[] t1 = ((Select) i1).getTargets();
                    InstructionHandle[] t2 = ((Select) i2).getTargets();
                    // See AspectJ bug 104957
                    if (t1 == null && t2 == null)
                        return true;
                    if (t1 == null || t2 == null)
                        return false;
                    if (t1.length == t2.length) {
                        for (int i = 0; i < t1.length; i++) {
                            if (t1[i] != t2[i]) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if (i1 instanceof BranchInstruction) {
                    return ((BranchInstruction) i1).target == ((BranchInstruction) i2).target;
                } else if (i1 instanceof ConstantPushInstruction) {
                    return ((ConstantPushInstruction) i1).getValue().equals(((ConstantPushInstruction) i2).getValue());
                } else if (i1 instanceof IndexedInstruction) {
                    return ((IndexedInstruction) i1).getIndex() == ((IndexedInstruction) i2).getIndex();
                } else if (i1 instanceof NEWARRAY) {
                    return ((NEWARRAY) i1).getTypecode() == ((NEWARRAY) i2).getTypecode();
                } else {
                    return true;
                }
            }
            return false;
        }
    };

    public boolean equals(Instruction i1, Instruction i2);
}
