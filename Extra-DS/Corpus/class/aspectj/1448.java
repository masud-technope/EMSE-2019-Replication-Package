package org.aspectj.apache.bcel.generic;

import java.io.*;
import org.aspectj.apache.bcel.util.ByteSequence;

/** 
 * BIPUSH - Push byte on stack
 *
 * <PRE>Stack: ... -&gt; ..., value</PRE>
 *
 * @version $Id: BIPUSH.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class BIPUSH extends Instruction implements ConstantPushInstruction {

    private byte b;

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     BIPUSH() {
    }

    /** Push byte on stack
   */
    public  BIPUSH(byte b) {
        super(org.aspectj.apache.bcel.Constants.BIPUSH, (short) 2);
        this.b = b;
    }

    /**
   * Dump instruction as byte code to stream out.
   */
    public void dump(DataOutputStream out) throws IOException {
        super.dump(out);
        out.writeByte(b);
    }

    /**
   * @return mnemonic for instruction
   */
    public String toString(boolean verbose) {
        return super.toString(verbose) + " " + b;
    }

    /**
   * Read needed data (e.g. index) from file.
   */
    protected void initFromFile(ByteSequence bytes, boolean wide) throws IOException {
        length = 2;
        b = bytes.readByte();
    }

    public Number getValue() {
        return new Integer(b);
    }

    /** @return Type.BYTE
   */
    public Type getType(ConstantPoolGen cp) {
        return Type.BYTE;
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
        v.visitBIPUSH(this);
    }
}
