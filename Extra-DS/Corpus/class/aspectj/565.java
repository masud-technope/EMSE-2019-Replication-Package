package org.aspectj.apache.bcel.generic;

/** 
 * ARETURN -  Return reference from method
 * <PRE>Stack: ..., objectref -&gt; &lt;empty&gt;</PRE>
 *
 * @version $Id: ARETURN.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ARETURN extends ReturnInstruction {

    /** 
   * Return reference from method
   */
    public  ARETURN() {
        super(org.aspectj.apache.bcel.Constants.ARETURN);
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
        v.visitExceptionThrower(this);
        v.visitTypedInstruction(this);
        v.visitStackConsumer(this);
        v.visitReturnInstruction(this);
        v.visitARETURN(this);
    }
}
