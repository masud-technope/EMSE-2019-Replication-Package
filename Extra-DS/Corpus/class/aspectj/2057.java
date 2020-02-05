package org.aspectj.apache.bcel.generic;

/**
 * IMPDEP1 - Implementation dependent
 *
 * @version $Id: IMPDEP1.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class IMPDEP1 extends Instruction {

    public  IMPDEP1() {
        super(org.aspectj.apache.bcel.Constants.IMPDEP1, (short) 1);
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
        v.visitIMPDEP1(this);
    }
}
