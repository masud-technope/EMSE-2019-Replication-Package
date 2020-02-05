package org.aspectj.apache.bcel.generic;

/** 
 * I2B - Convert int to byte
 * <PRE>Stack: ..., value -&gt; ..., result</PRE>
 *
 * @version $Id: I2B.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class I2B extends ConversionInstruction {

    /** Convert int to byte
   */
    public  I2B() {
        super(org.aspectj.apache.bcel.Constants.I2B);
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
        v.visitTypedInstruction(this);
        v.visitStackProducer(this);
        v.visitStackConsumer(this);
        v.visitConversionInstruction(this);
        v.visitI2B(this);
    }
}
