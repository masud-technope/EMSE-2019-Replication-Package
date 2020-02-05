package org.aspectj.apache.bcel.generic;

/**
 * Super class for instructions dealing with array access such as IALOAD.
 *
 * @version $Id: ArrayInstruction.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class ArrayInstruction extends Instruction implements ExceptionThrower, TypedInstruction {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     ArrayInstruction() {
    }

    /**
   * @param opcode of instruction
   */
    protected  ArrayInstruction(short opcode) {
        super(opcode, (short) 1);
    }

    public Class[] getExceptions() {
        return org.aspectj.apache.bcel.ExceptionConstants.EXCS_ARRAY_EXCEPTION;
    }

    /** @return type associated with the instruction
   */
    public Type getType(ConstantPoolGen cp) {
        switch(opcode) {
            case org.aspectj.apache.bcel.Constants.IALOAD:
            case org.aspectj.apache.bcel.Constants.IASTORE:
                return Type.INT;
            case org.aspectj.apache.bcel.Constants.CALOAD:
            case org.aspectj.apache.bcel.Constants.CASTORE:
                return Type.CHAR;
            case org.aspectj.apache.bcel.Constants.BALOAD:
            case org.aspectj.apache.bcel.Constants.BASTORE:
                return Type.BYTE;
            case org.aspectj.apache.bcel.Constants.SALOAD:
            case org.aspectj.apache.bcel.Constants.SASTORE:
                return Type.SHORT;
            case org.aspectj.apache.bcel.Constants.LALOAD:
            case org.aspectj.apache.bcel.Constants.LASTORE:
                return Type.LONG;
            case org.aspectj.apache.bcel.Constants.DALOAD:
            case org.aspectj.apache.bcel.Constants.DASTORE:
                return Type.DOUBLE;
            case org.aspectj.apache.bcel.Constants.FALOAD:
            case org.aspectj.apache.bcel.Constants.FASTORE:
                return Type.FLOAT;
            case org.aspectj.apache.bcel.Constants.AALOAD:
            case org.aspectj.apache.bcel.Constants.AASTORE:
                return Type.OBJECT;
            default:
                throw new ClassGenException("Oops: unknown case in switch" + opcode);
        }
    }
}
