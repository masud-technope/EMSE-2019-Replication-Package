package org.aspectj.apache.bcel.generic;

/**
 * IDIV - Divide ints
 * <PRE>Stack: ..., value1, value2 -&gt; result</PRE>
 *
 * @version $Id: IDIV.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class IDIV extends ArithmeticInstruction implements ExceptionThrower {

    /** Divide ints
   */
    public  IDIV() {
        super(org.aspectj.apache.bcel.Constants.IDIV);
    }

    /** @return exceptions this instruction may cause
   */
    public Class[] getExceptions() {
        return new Class[] { org.aspectj.apache.bcel.ExceptionConstants.ARITHMETIC_EXCEPTION };
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
        v.visitStackProducer(this);
        v.visitStackConsumer(this);
        v.visitArithmeticInstruction(this);
        v.visitIDIV(this);
    }
}
