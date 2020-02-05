package org.aspectj.apache.bcel.classfile;

import org.aspectj.apache.bcel.Constants;
import java.io.*;

/** 
 * This class is derived from the abstract 
 * <A HREF="org.aspectj.apache.bcel.classfile.Constant.html">Constant</A> class 
 * and represents a reference to a float object.
 *
 * @version $Id: ConstantFloat.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @see     Constant
 */
public final class ConstantFloat extends Constant implements ConstantObject {

    private float bytes;

    /** 
   * @param bytes Data
   */
    public  ConstantFloat(float bytes) {
        super(Constants.CONSTANT_Float);
        this.bytes = bytes;
    }

    /**
   * Initialize from another object. Note that both objects use the same
   * references (shallow copy). Use clone() for a physical copy.
   */
    public  ConstantFloat(ConstantFloat c) {
        this(c.getBytes());
    }

    /** 
   * Initialize instance from file data.
   *
   * @param file Input stream
   * @throws IOException
   */
     ConstantFloat(DataInputStream file) throws IOException {
        this(file.readFloat());
    }

    /**
   * Called by objects that are traversing the nodes of the tree implicitely
   * defined by the contents of a Java class. I.e., the hierarchy of methods,
   * fields, attributes, etc. spawns a tree of objects.
   *
   * @param v Visitor object
   */
    public void accept(Visitor v) {
        v.visitConstantFloat(this);
    }

    /**
   * Dump constant float to file stream in binary format.
   *
   * @param file Output file stream
   * @throws IOException
   */
    public final void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeFloat(bytes);
    }

    /**
   * @return data, i.e., 4 bytes.
   */
    public final float getBytes() {
        return bytes;
    }

    /**
   * @param bytes.
   */
    public final void setBytes(float bytes) {
        this.bytes = bytes;
    }

    /**
   * @return String representation.
   */
    public final String toString() {
        return super.toString() + "(bytes = " + bytes + ")";
    }

    /** @return Float object
   */
    public Object getConstantValue(ConstantPool cp) {
        return new Float(bytes);
    }
}
