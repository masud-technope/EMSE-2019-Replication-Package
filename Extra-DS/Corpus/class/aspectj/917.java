package org.aspectj.apache.bcel.generic;

/**
 * Get the type associated with an instruction, int for ILOAD, or the type
 * of the field of a PUTFIELD instruction, e.g..
 *
 * @version $Id: TypedInstruction.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface TypedInstruction {

    public Type getType(ConstantPoolGen cpg);
}
