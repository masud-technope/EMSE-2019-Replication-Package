package org.aspectj.apache.bcel.generic;

/**
 * Thrown by InstructionList.remove() when one or multiple disposed instruction
 * are still being referenced by a InstructionTargeter object. I.e. the
 * InstructionTargeter has to be notified that (one of) the InstructionHandle it
 * is referencing is being removed from the InstructionList and thus not valid anymore.
 *
 * Making this an exception instead of a return value forces the user to handle
 * these case explicitely in a try { ... } catch. The following code illustrates
 * how this may be done:
 *
 * <PRE>
 *     ...
 *     try {
 *	il.delete(start_ih, end_ih);
 *     } catch(TargetLostException e) {
 *       InstructionHandle[] targets = e.getTargets();
 *	 for(int i=0; i < targets.length; i++) {
 *	   InstructionTargeter[] targeters = targets[i].getTargeters();
 *     
 *	   for(int j=0; j < targeters.length; j++)
 *	     targeters[j].updateTarget(targets[i], new_target);
 *       }
 *     }
 * </PRE>
 *
 * @see InstructionHandle
 * @see InstructionList
 * @see InstructionTargeter
 * @version $Id: TargetLostException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public final class TargetLostException extends Exception {

    private InstructionHandle[] targets;

     TargetLostException(InstructionHandle[] t, String mesg) {
        super(mesg);
        targets = t;
    }

    /**
   * @return list of instructions still being targeted.
   */
    public InstructionHandle[] getTargets() {
        return targets;
    }
}
