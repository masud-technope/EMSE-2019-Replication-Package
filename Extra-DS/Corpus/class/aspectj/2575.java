package org.aspectj.apache.bcel.verifier.structurals;

import org.aspectj.apache.bcel.*;
import org.aspectj.apache.bcel.generic.*;

/**
 * This class represents an uninitialized object type; see The Java
 * Virtual Machine Specification, Second Edition, page 147: 4.9.4 for
 * more details.
 *
 * @version $Id: UninitializedObjectType.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class UninitializedObjectType extends ReferenceType implements Constants {

    /** The "initialized" version. */
    private ObjectType initialized;

    /** Creates a new instance. */
    public  UninitializedObjectType(ObjectType t) {
        super(T_UNKNOWN, "<UNINITIALIZED OBJECT OF TYPE '" + t.getClassName() + "'>");
        initialized = t;
    }

    /**
	 * Returns the ObjectType of the same class as the one of the uninitialized object
	 * represented by this UninitializedObjectType instance.
	 */
    public ObjectType getInitialized() {
        return initialized;
    }

    /**
	 * Returns true on equality of this and o.
	 * Equality means the ObjectType instances of "initialized"
	 * equal one another in this and the o instance.
	 *
	 */
    public boolean equals(Object o) {
        if (!(o instanceof UninitializedObjectType))
            return false;
        return initialized.equals(((UninitializedObjectType) o).initialized);
    }
}
