/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt;

import org.eclipse.swt.internal.*;

public class SWTError extends Error {

    /**
     * The SWT error code, one of SWT.ERROR_*.
     */
    public int code;

    /**
	 * The underlying throwable that caused the problem,
	 * or null if this information is not available.
	 */
    public Throwable throwable;

    static final long serialVersionUID = 3833467327105808433L;

    /**
 * Constructs a new instance of this class with its 
 * stack trace filled in. The error code is set to an
 * unspecified value.
 */
    public  SWTError() {
        this(SWT.ERROR_UNSPECIFIED);
    }

    /**
 * Constructs a new instance of this class with its 
 * stack trace and message filled in. The error code is
 * set to an unspecified value.  Specifying <code>null</code>
 * as the message is equivalent to specifying an empty string.
 *
 * @param message the detail message for the exception
 */
    public  SWTError(String message) {
        this(SWT.ERROR_UNSPECIFIED, message);
    }

    /**
 * Constructs a new instance of this class with its 
 * stack trace and error code filled in.
 *
 * @param code the SWT error code
 */
    public  SWTError(int code) {
        this(code, SWT.findErrorText(code));
    }

    /**
 * Constructs a new instance of this class with its 
 * stack trace, error code and message filled in.
 * Specifying <code>null</code> as the message is
 * equivalent to specifying an empty string.
 * 
 * @param code the SWT error code
 * @param message the detail message for the exception
 */
    public  SWTError(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
 * Returns the underlying throwable that caused the problem,
 * or null if this information is not available.
 * <p>
 * NOTE: This method overrides Throwable.getCause() that was
 * added to JDK1.4. It is necessary to override this method
 * in order for inherited printStackTrace() methods to work.
 * </p>
 * @return the underlying throwable
 * 
 * @since 3.1
 */
    public Throwable getCause() {
        return throwable;
    }

    /**
 *  Returns the string describing this SWTError object.
 *  <p>
 *  It is combined with the message string of the Throwable
 *  which caused this SWTError (if this information is available).
 *  </p>
 *  @return the error message string of this SWTError object
 */
    public String getMessage() {
        if (throwable == null)
            return super.getMessage();
        //$NON-NLS-1$ //$NON-NLS-2$
        return super.getMessage() + " (" + throwable.toString() + ")";
    }

    /**
 * Outputs a printable representation of this error's
 * stack trace on the standard error stream.
 * <p>
 * Note: printStackTrace(PrintStream) and printStackTrace(PrintWriter)
 * are not provided in order to maintain compatibility with CLDC.
 * </p>
 */
    public void printStackTrace() {
        super.printStackTrace();
        if (Library.JAVA_VERSION < Library.JAVA_VERSION(1, 4, 0) && throwable != null) {
            //$NON-NLS-1$
            System.err.println("*** Stack trace of contained error ***");
            throwable.printStackTrace();
        }
    }
}
