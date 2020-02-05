package org.aspectj.apache.bcel.generic;

/**
 * IMPDEP2 - Implementation dependent
 *
 * @version $Id: IMPDEP2.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class IMPDEP2 extends Instruction {

    public  IMPDEP2() {
        super(org.aspectj.apache.bcel.Constants.IMPDEP2, (short) 1);
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
        v.visitIMPDEP2(this);
    }
}
