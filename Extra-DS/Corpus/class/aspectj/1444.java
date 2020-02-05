/* *******************************************************************
 * Copyright (c) 2004 IBM
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Common Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html 
 *  
 * Contributors: 
 *     Andy Clement -     initial implementation {date}
 * ******************************************************************/
package org.aspectj.apache.bcel.generic.annotation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.aspectj.apache.bcel.classfile.annotation.AnnotationElementValue;
import org.aspectj.apache.bcel.classfile.annotation.ArrayElementValue;
import org.aspectj.apache.bcel.classfile.annotation.ClassElementValue;
import org.aspectj.apache.bcel.classfile.annotation.ElementValue;
import org.aspectj.apache.bcel.classfile.annotation.EnumElementValue;
import org.aspectj.apache.bcel.classfile.annotation.SimpleElementValue;
import org.aspectj.apache.bcel.generic.ConstantPoolGen;

public abstract class ElementValueGen {

    protected int type;

    protected ConstantPoolGen cpGen;

    protected  ElementValueGen(int type, ConstantPoolGen cpGen) {
        this.type = type;
        this.cpGen = cpGen;
    }

    /**
     * Subtypes return an immutable variant of the ElementValueGen
     */
    public abstract ElementValue getElementValue();

    public int getElementValueType() {
        return type;
    }

    public abstract String stringifyValue();

    public abstract void dump(DataOutputStream dos) throws IOException;

    public static final int STRING = 's';

    public static final int ENUM_CONSTANT = 'e';

    public static final int CLASS = 'c';

    public static final int ANNOTATION = '@';

    public static final int ARRAY = '[';

    public static final int PRIMITIVE_INT = 'I';

    public static final int PRIMITIVE_BYTE = 'B';

    public static final int PRIMITIVE_CHAR = 'C';

    public static final int PRIMITIVE_DOUBLE = 'D';

    public static final int PRIMITIVE_FLOAT = 'F';

    public static final int PRIMITIVE_LONG = 'J';

    public static final int PRIMITIVE_SHORT = 'S';

    public static final int PRIMITIVE_BOOLEAN = 'Z';

    public static ElementValueGen readElementValue(DataInputStream dis, ConstantPoolGen cpGen) throws IOException {
        int type = dis.readUnsignedByte();
        switch(type) {
            case // byte
            'B':
                return new SimpleElementValueGen(PRIMITIVE_BYTE, dis.readUnsignedShort(), cpGen);
            case // char
            'C':
                return new SimpleElementValueGen(PRIMITIVE_CHAR, dis.readUnsignedShort(), cpGen);
            case // double
            'D':
                return new SimpleElementValueGen(PRIMITIVE_DOUBLE, dis.readUnsignedShort(), cpGen);
            case // float
            'F':
                return new SimpleElementValueGen(PRIMITIVE_FLOAT, dis.readUnsignedShort(), cpGen);
            case // int
            'I':
                return new SimpleElementValueGen(PRIMITIVE_INT, dis.readUnsignedShort(), cpGen);
            case // long
            'J':
                return new SimpleElementValueGen(PRIMITIVE_LONG, dis.readUnsignedShort(), cpGen);
            case // short
            'S':
                return new SimpleElementValueGen(PRIMITIVE_SHORT, dis.readUnsignedShort(), cpGen);
            case // boolean
            'Z':
                return new SimpleElementValueGen(PRIMITIVE_BOOLEAN, dis.readUnsignedShort(), cpGen);
            case // String
            's':
                return new SimpleElementValueGen(STRING, dis.readUnsignedShort(), cpGen);
            case // Enum constant
            'e':
                return new EnumElementValueGen(dis.readUnsignedShort(), dis.readUnsignedShort(), cpGen);
            case // Class
            'c':
                return new ClassElementValueGen(dis.readUnsignedShort(), cpGen);
            default:
                throw new RuntimeException("Unexpected element value kind in annotation: " + type);
        }
    }

    protected ConstantPoolGen getConstantPool() {
        return cpGen;
    }

    /** 
	 * Creates an (modifiable) ElementValueGen copy of an (immutable) ElementValue - constant pool is assumed correct.
	 */
    public static ElementValueGen copy(ElementValue value, ConstantPoolGen cpool, boolean copyPoolEntries) {
        switch(value.getElementValueType()) {
            // byte
            case 'B':
            // char
            case 'C':
            // double
            case 'D':
            // float
            case 'F':
            // int
            case 'I':
            // long
            case 'J':
            // short
            case 'S':
            // boolean
            case 'Z':
            // String
            case 's':
                return new SimpleElementValueGen((SimpleElementValue) value, cpool, copyPoolEntries);
            // Enum constant
            case 'e':
                return new EnumElementValueGen((EnumElementValue) value, cpool, copyPoolEntries);
            // Annotation
            case '@':
                return new AnnotationElementValueGen((AnnotationElementValue) value, cpool, copyPoolEntries);
            case // Array
            '[':
                return new ArrayElementValueGen((ArrayElementValue) value, cpool, copyPoolEntries);
            case // Class
            'c':
                return new ClassElementValueGen((ClassElementValue) value, cpool, copyPoolEntries);
            default:
                throw new RuntimeException("Not implemented yet! (" + value.getElementValueType() + ")");
        }
    }
}
