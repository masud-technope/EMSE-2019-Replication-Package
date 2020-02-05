package org.aspectj.apache.bcel.generic;

import java.io.DataOutputStream;
import java.io.IOException;
import org.aspectj.apache.bcel.classfile.Constant;
import org.aspectj.apache.bcel.classfile.ConstantClass;
import org.aspectj.apache.bcel.classfile.ConstantPool;
import org.aspectj.apache.bcel.util.ByteSequence;

/** 
 * Abstract super class for instructions that use an index into the 
 * constant pool such as LDC, INVOKEVIRTUAL, etc.
 *
 * @see ConstantPoolGen
 * @see LDC
 * @see INVOKEVIRTUAL
 *
 * @version $Id: CPInstruction.java,v 1.4 2004/11/22 08:31:27 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class CPInstruction extends Instruction implements TypedInstruction, IndexedInstruction {

    // index to constant pool
    protected int index;

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     CPInstruction() {
    }

    /**
   * @param index to constant pool
   */
    protected  CPInstruction(short opcode, int index) {
        super(opcode, (short) 3);
        setIndex(index);
    }

    /**
   * Dump instruction as byte code to stream out.
   * @param out Output stream
   */
    public void dump(DataOutputStream out) throws IOException {
        out.writeByte(opcode);
        out.writeShort(index);
    }

    /**
   * Long output format:
   *
   * &lt;name of opcode&gt; "["&lt;opcode number&gt;"]" 
   * "("&lt;length of instruction&gt;")" "&lt;"&lt; constant pool index&gt;"&gt;"
   *
   * @param verbose long/short format switch
   * @return mnemonic for instruction
   */
    public String toString(boolean verbose) {
        return super.toString(verbose) + " " + index;
    }

    /**
   * @return mnemonic for instruction with symbolic references resolved
   */
    public String toString(ConstantPool cp) {
        Constant c = cp.getConstant(index);
        String str = cp.constantToString(c);
        if (c instanceof ConstantClass)
            str = str.replace('.', '/');
        return org.aspectj.apache.bcel.Constants.OPCODE_NAMES[opcode] + " " + str;
    }

    /**
   * Read needed data (i.e., index) from file.
   * @param bytes input stream
   * @param wide wide prefix?
   */
    protected void initFromFile(ByteSequence bytes, boolean wide) throws IOException {
        setIndex(bytes.readUnsignedShort());
        length = 3;
    }

    /**
   * @return index in constant pool referred by this instruction.
   */
    public final int getIndex() {
        return index;
    }

    /**
   * Set the index to constant pool.
   * @param index in  constant pool.
   */
    public void setIndex(int index) {
        if (index < 0)
            throw new ClassGenException("Negative index value: " + index);
        this.index = index;
    }

    /** @return type related with this instruction.
   */
    public Type getType(ConstantPoolGen cpg) {
        ConstantPool cp = cpg.getConstantPool();
        String name = cp.getConstantString(index, org.aspectj.apache.bcel.Constants.CONSTANT_Class);
        if (!name.startsWith("["))
            name = "L" + name + ";";
        return Type.getType(name);
    }
}
