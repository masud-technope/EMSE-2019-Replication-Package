package org.aspectj.apache.bcel.generic;

/** 
 * Thrown on internal errors. Extends RuntimeException so it hasn't to be declared
 * in the throws clause every time.
 *
 * @version $Id: ClassGenException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ClassGenException extends RuntimeException {

    public  ClassGenException() {
        super();
    }

    public  ClassGenException(String s) {
        super(s);
    }
}
