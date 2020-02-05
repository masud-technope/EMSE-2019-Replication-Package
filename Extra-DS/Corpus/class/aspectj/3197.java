package org.aspectj.apache.bcel.verifier.exc;

import java.io.*;

/**
 * A utility class providing convenience methods concerning Throwable instances.
 * @version $Id: Utility.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 * @see java.lang.Throwable
 */
public final class Utility {

    /** This class is not instantiable. */
    private  Utility() {
    }

    /** This method returns the stack trace of a Throwable instance as a String. */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
}
