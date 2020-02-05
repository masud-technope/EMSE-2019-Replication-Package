package org.aspectj.apache.bcel.generic;

import org.aspectj.apache.bcel.classfile.ConstantPool;

/**
 * Super class for the GET/PUTxxx family of instructions.
 *
 * @version $Id: FieldInstruction.java,v 1.4 2004/11/22 08:31:27 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class FieldInstruction extends FieldOrMethod implements TypedInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     FieldInstruction() {
    }

    /**
   * @param index to constant pool
   */
    protected  FieldInstruction(short opcode, int index) {
        super(opcode, index);
    }

    /**
   * @return mnemonic for instruction with symbolic references resolved
   */
    public String toString(ConstantPool cp) {
        return org.aspectj.apache.bcel.Constants.OPCODE_NAMES[opcode] + " " + cp.constantToString(index, org.aspectj.apache.bcel.Constants.CONSTANT_Fieldref);
    }

    /** @return size of field (1 or 2)
   */
    protected int getFieldSize(ConstantPoolGen cpg) {
        return getType(cpg).getSize();
    }

    /** @return return type of referenced field
   */
    public Type getType(ConstantPoolGen cpg) {
        return getFieldType(cpg);
    }

    /** @return type of field
   */
    public Type getFieldType(ConstantPoolGen cpg) {
        return Type.getType(getSignature(cpg));
    }

    /** @return name of referenced field.
   */
    public String getFieldName(ConstantPoolGen cpg) {
        return getName(cpg);
    }
}
