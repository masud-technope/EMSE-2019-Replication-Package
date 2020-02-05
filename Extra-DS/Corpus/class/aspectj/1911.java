package org.aspectj.apache.bcel.generic;

/** 
 * MONITORENTER - Enter monitor for object
 * <PRE>Stack: ..., objectref -&gt; ...</PRE>
 *
 * @version $Id: MONITORENTER.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class MONITORENTER extends Instruction implements ExceptionThrower, StackConsumer {

    public  MONITORENTER() {
        super(org.aspectj.apache.bcel.Constants.MONITORENTER, (short) 1);
    }

    public Class[] getExceptions() {
        return new Class[] { org.aspectj.apache.bcel.ExceptionConstants.NULL_POINTER_EXCEPTION };
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
        v.visitStackConsumer(this);
        v.visitMONITORENTER(this);
    }
}
