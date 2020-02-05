package org.aspectj.apache.bcel.verifier.exc;

/**
 * Instances of this class are thrown by BCEL's class file verifier "JustIce" when
 * a class file to verify does not pass the verification pass 3 because of a violation
 * of a constraint that is usually only verified at run-time (pass 4).
 * The Java Virtual Machine Specification, 2nd edition, states that certain constraints
 * are usually verified at run-time for performance reasons (the verification of those
 * constraints requires loading in and recursively verifying referenced classes) that
 * conceptually belong to pass 3; to be precise, that conceptually belong to the
 * data flow analysis of pass 3 (called pass 3b in JustIce).
 * These are the checks necessary for resolution: Compare pages 142-143 ("4.9.1 The
 * Verification Process") and pages 50-51 ("2.17.3 Linking: Verification, Preparation,
 * and Resolution") of the above mentioned book.
 * <B>TODO: At this time, this class is not used in JustIce.</B>
 *
 * @version $Id: LinkingConstraintException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class LinkingConstraintException extends StructuralCodeConstraintException {
}
