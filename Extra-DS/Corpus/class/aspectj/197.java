package org.aspectj.apache.bcel.verifier.statics;

import org.aspectj.apache.bcel.generic.Type;
import org.aspectj.apache.bcel.verifier.exc.*;

/**
 * A utility class holding the information about
 * the names and the types of the local variables in
 * a given method.
 *
 * @version $Id: LocalVariablesInfo.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class LocalVariablesInfo {

    /** The information about the local variables is stored here. */
    private LocalVariableInfo[] localVariableInfos;

    /** The constructor. */
     LocalVariablesInfo(int max_locals) {
        localVariableInfos = new LocalVariableInfo[max_locals];
        for (int i = 0; i < max_locals; i++) {
            localVariableInfos[i] = new LocalVariableInfo();
        }
    }

    /** Returns the LocalVariableInfo for the given slot. */
    public LocalVariableInfo getLocalVariableInfo(int slot) {
        if (slot < 0 || slot >= localVariableInfos.length) {
            throw new AssertionViolatedException("Slot number for local variable information out of range.");
        }
        return localVariableInfos[slot];
    }

    /**
	 * Adds information about the local variable in slot 'slot'. Automatically 
	 * adds information for slot+1 if 't' is Type.LONG or Type.DOUBLE.
	 * @throws LocalVariableInfoInconsistentException if the new information conflicts
	 *         with already gathered information.
	 */
    public void add(int slot, String name, int startpc, int length, Type t) throws LocalVariableInfoInconsistentException {
        if (slot < 0 || slot >= localVariableInfos.length) {
            throw new AssertionViolatedException("Slot number for local variable information out of range.");
        }
        localVariableInfos[slot].add(name, startpc, length, t);
        if (t == Type.LONG)
            localVariableInfos[slot + 1].add(name, startpc, length, LONG_Upper.theInstance());
        if (t == Type.DOUBLE)
            localVariableInfos[slot + 1].add(name, startpc, length, DOUBLE_Upper.theInstance());
    }
}
