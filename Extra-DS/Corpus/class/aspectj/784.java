package org.aspectj.apache.bcel.verifier.statics;

import org.aspectj.apache.bcel.Constants;
import org.aspectj.apache.bcel.generic.Type;

/**
 * This class represents the upper half of a DOUBLE variable.
 * @version $Id: DOUBLE_Upper.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public final class DOUBLE_Upper extends Type {

    /** The one and only instance of this class. */
    private static DOUBLE_Upper singleInstance = new DOUBLE_Upper();

    /** The constructor; this class must not be instantiated from the outside. */
    private  DOUBLE_Upper() {
        super(Constants.T_UNKNOWN, "Long_Upper");
    }

    /** Use this method to get the single instance of this class. */
    public static DOUBLE_Upper theInstance() {
        return singleInstance;
    }
}
