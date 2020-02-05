package org.aspectj.apache.bcel.classfile;

/**
 * Denote class to have an accept method();
 *
 * @version $Id: Node.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface Node {

    public void accept(Visitor obj);
}
