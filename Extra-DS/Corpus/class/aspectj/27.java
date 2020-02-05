package org.aspectj.apache.bcel.generic;

/**
 * Imnplement this interface if you're interested in changes to a FieldGen object
 * and register yourself with addObserver().
 *
 * @version $Id: FieldObserver.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface FieldObserver {

    public void notify(FieldGen field);
}
