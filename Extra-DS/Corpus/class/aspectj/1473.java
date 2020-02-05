package org.aspectj.apache.bcel.generic;

/**
 * Denote entity that refers to an index, e.g. local variable instructions,
 * RET, CPInstruction, etc.
 *
 * @version $Id: IndexedInstruction.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface IndexedInstruction {

    public int getIndex();

    public void setIndex(int index);
}
