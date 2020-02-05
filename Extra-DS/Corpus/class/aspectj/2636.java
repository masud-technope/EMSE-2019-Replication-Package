package org.aspectj.apache.bcel.verifier.exc;

/**
 * Instances of this class are thrown by BCEL's class file verifier "JustIce" when
 * a class file to verify does not pass the verification pass 3 because of a violation
 * of a static constraint as described in the Java Virtual Machine Specification,
 * Second edition, 4.8.1, pages 133-137. The static constraints checking part of pass 3
 * is called pass 3a in JustIce.
 * Static constraints on the operands of instructions in the code array are checked late in
 * pass 3a and are described on page 134-137 in the Java Virtual Machine Specification,
 * Second Edition.
 *
 * @version $Id: StaticCodeInstructionOperandConstraintException.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class StaticCodeInstructionOperandConstraintException extends StaticCodeConstraintException {

    public  StaticCodeInstructionOperandConstraintException(String message) {
        super(message);
    }
}
