package org.aspectj.apache.bcel.generic;

/**
 * Implement this interface if you're interested in changes to an InstructionList object
 * and register yourself with addObserver().
 *
 * @version $Id: InstructionListObserver.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface InstructionListObserver {

    public void notify(InstructionList list);
}
