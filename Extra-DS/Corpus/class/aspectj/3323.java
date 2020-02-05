package org.aspectj.apache.bcel.generic;

/** 
 * INSTANCEOF - Determine if object is of given type
 * <PRE>Stack: ..., objectref -&gt; ..., result</PRE>
 *
 * @version $Id: INSTANCEOF.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class INSTANCEOF extends CPInstruction implements LoadClass, ExceptionThrower, StackProducer, StackConsumer {

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     INSTANCEOF() {
    }

    public  INSTANCEOF(int index) {
        super(org.aspectj.apache.bcel.Constants.INSTANCEOF, index);
    }

    public Class[] getExceptions() {
        return org.aspectj.apache.bcel.ExceptionConstants.EXCS_CLASS_AND_INTERFACE_RESOLUTION;
    }

    public ObjectType getLoadClassType(ConstantPoolGen cpg) {
        Type t = getType(cpg);
        if (t instanceof ArrayType)
            t = ((ArrayType) t).getBasicType();
        return (t instanceof ObjectType) ? (ObjectType) t : null;
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
        v.visitLoadClass(this);
        v.visitExceptionThrower(this);
        v.visitStackProducer(this);
        v.visitStackConsumer(this);
        v.visitTypedInstruction(this);
        v.visitCPInstruction(this);
        v.visitINSTANCEOF(this);
    }
}
