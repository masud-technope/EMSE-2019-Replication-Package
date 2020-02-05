package org.aspectj.apache.bcel.classfile;

import org.aspectj.apache.bcel.Constants;
import java.io.*;

/**
 * This class represents collection of local variables in a
 * method. This attribute is contained in the <em>Code</em> attribute.
 *
 * @version $Id: LocalVariableTable.java,v 1.3 2006/02/15 09:15:34 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @see     Code
 * @see LocalVariable
 * 
 * Updates: Andy 14Feb06 - Made unpacking of the data lazy, depending on someone
 *          actually asking for it.
 */
public class LocalVariableTable extends Attribute {

    // if 'isInPackedState' then this data needs unpacking
    private boolean isInPackedState = false;

    private byte[] data;

    private int localVariableTableLength;

    private LocalVariable[] localVariableTable;

    /**
   * Initialize from another object. Note that both objects use the same
   * references (shallow copy). Use copy() for a physical copy.
   */
    public  LocalVariableTable(LocalVariableTable c) {
        this(c.getNameIndex(), c.getLength(), c.getLocalVariableTable(), c.getConstantPool());
    }

    /**
   * @param name_index Index in constant pool to `LocalVariableTable'
   * @param length Content length in bytes
   * @param local_variable_table Table of local variables
   * @param constant_pool Array of constants
   */
    public  LocalVariableTable(int name_index, int length, LocalVariable[] local_variable_table, ConstantPool constant_pool) {
        super(Constants.ATTR_LOCAL_VARIABLE_TABLE, name_index, length, constant_pool);
        setLocalVariableTable(local_variable_table);
    }

    /**
   * Construct object from file stream.
   * @param name_index Index in constant pool
   * @param length Content length in bytes
   * @param file Input stream
   * @param constant_pool Array of constants
   * @throws IOException
   */
     LocalVariableTable(int name_index, int length, DataInputStream file, ConstantPool constant_pool) throws IOException {
        super(Constants.ATTR_LOCAL_VARIABLE_TABLE, name_index, length, constant_pool);
        data = new byte[length];
        int byteReads = file.read(data);
        isInPackedState = true;
    // assert(bytesRead==length)
    }

    /**
   * Called by objects that are traversing the nodes of the tree implicitely
   * defined by the contents of a Java class. I.e., the hierarchy of methods,
   * fields, attributes, etc. spawns a tree of objects.
   *
   * @param v Visitor object
   */
    public void accept(Visitor v) {
        unpack();
        v.visitLocalVariableTable(this);
    }

    /**
   * Dump local variable table attribute to file stream in binary format.
   *
   * @param file Output file stream
   * @throws IOException
   */
    public final void dump(DataOutputStream file) throws IOException {
        super.dump(file);
        if (isInPackedState) {
            file.write(data);
        } else {
            file.writeShort(localVariableTableLength);
            for (int i = 0; i < localVariableTableLength; i++) localVariableTable[i].dump(file);
        }
    }

    /**
   * @return Array of local variables of method.
   */
    public final LocalVariable[] getLocalVariableTable() {
        unpack();
        return localVariableTable;
    }

    /** @return first matching variable using index
   */
    public final LocalVariable getLocalVariable(int index) {
        unpack();
        for (int i = 0; i < localVariableTableLength; i++) if (localVariableTable[i].getIndex() == index)
            return localVariableTable[i];
        return null;
    }

    public final void setLocalVariableTable(LocalVariable[] local_variable_table) {
        data = null;
        isInPackedState = false;
        this.localVariableTable = local_variable_table;
        localVariableTableLength = (local_variable_table == null) ? 0 : local_variable_table.length;
    }

    /**
   * @return String representation.
   */
    public final String toString() {
        StringBuffer buf = new StringBuffer("");
        unpack();
        for (int i = 0; i < localVariableTableLength; i++) {
            buf.append(localVariableTable[i].toString());
            if (i < localVariableTableLength - 1)
                buf.append('\n');
        }
        return buf.toString();
    }

    /**
   * @return deep copy of this attribute
   */
    public Attribute copy(ConstantPool constant_pool) {
        unpack();
        LocalVariableTable c = (LocalVariableTable) clone();
        c.localVariableTable = new LocalVariable[localVariableTableLength];
        for (int i = 0; i < localVariableTableLength; i++) c.localVariableTable[i] = localVariableTable[i].copy();
        c.constant_pool = constant_pool;
        return c;
    }

    public final int getTableLength() {
        unpack();
        return localVariableTableLength;
    }

    // ---
    // Unpacks the byte array into the table
    private void unpack() {
        if (!isInPackedState)
            return;
        try {
            ByteArrayInputStream bs = new ByteArrayInputStream(data);
            DataInputStream dis = new DataInputStream(bs);
            localVariableTableLength = (dis.readUnsignedShort());
            localVariableTable = new LocalVariable[localVariableTableLength];
            for (int i = 0; i < localVariableTableLength; i++) localVariableTable[i] = new LocalVariable(dis, constant_pool);
            dis.close();
            // throw it away now
            data = null;
        } catch (IOException e) {
            throw new RuntimeException("Unpacking of LocalVariableTable attribute failed");
        }
        isInPackedState = false;
    }
}
