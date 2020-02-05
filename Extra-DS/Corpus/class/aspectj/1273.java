package org.aspectj.apache.bcel.generic;

/** 
 * DCMPL - Compare doubles: value1 < value2
 * <PRE>Stack: ..., value1.word1, value1.word2, value2.word1, value2.word2 -&gt;</PRE>
 *        ..., result
 *
 * @version $Id: DCMPL.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class DCMPL extends Instruction implements TypedInstruction, StackProducer, StackConsumer {

    public  DCMPL() {
        super(org.aspectj.apache.bcel.Constants.DCMPL, (short) 1);
    }

    /** @return Type.DOUBLE
   */
    public Type getType(ConstantPoolGen cp) {
        return Type.DOUBLE;
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
        v.visitDCMPL(this);
    }
}
