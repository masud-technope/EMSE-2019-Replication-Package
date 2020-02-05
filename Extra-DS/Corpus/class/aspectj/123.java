package org.aspectj.apache.bcel.classfile;

/** 
 * This interface denotes those constants that have a "natural" value,
 * such as ConstantLong, ConstantString, etc..
 *
 * @version $Id: ConstantObject.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @see     Constant
 */
public interface ConstantObject {

    /** @return object representing the constant, e.g., Long for ConstantLong
   */
    public abstract Object getConstantValue(ConstantPool cp);
}
