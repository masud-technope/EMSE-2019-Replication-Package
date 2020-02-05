package org.aspectj.apache.bcel.generic;

/** 
 * ATHROW -  Throw exception
 * <PRE>Stack: ..., objectref -&gt; objectref</PRE>
 *
 * @version $Id: ATHROW.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ATHROW extends Instruction implements UnconditionalBranch, ExceptionThrower {

    /** 
   *  Throw exception
   */
    public  ATHROW() {
        super(org.aspectj.apache.bcel.Constants.ATHROW, (short) 1);
    }

    /** @return exceptions this instruction may cause
   */
    public Class[] getExceptions() {
        return new Class[] { org.aspectj.apache.bcel.ExceptionConstants.THROWABLE };
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
        v.visitUnconditionalBranch(this);
        v.visitExceptionThrower(this);
        v.visitATHROW(this);
    }
}
