package org.aspectj.apache.bcel.classfile;

/** 
 * Thrown when the BCEL attempts to read a class file and determines
 * that the file is malformed or otherwise cannot be interpreted as a
 * class file.
 *
 * @version $Id: ClassFormatException.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ClassFormatException extends RuntimeException {

    public  ClassFormatException() {
        super();
    }

    public  ClassFormatException(String s) {
        super(s);
    }
}
