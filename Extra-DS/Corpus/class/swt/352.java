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
package org.eclipse.swt.events;

import org.eclipse.swt.widgets.*;

public final class TraverseEvent extends KeyEvent {

    /**
	 * The traversal type.
	 * <p><ul>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_NONE}</li>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_ESCAPE}</li>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_RETURN}</li>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_TAB_NEXT}</li>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_TAB_PREVIOUS}</li>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_ARROW_NEXT}</li>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_ARROW_PREVIOUS}</li>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_MNEMONIC}</li>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_PAGE_NEXT}</li>
	 * <li>{@link org.eclipse.swt.SWT#TRAVERSE_PAGE_PREVIOUS}</li>
	 * </ul></p>
	 * 
	 * Setting this field will change the type of traversal.
	 * For example, setting the detail to <code>TRAVERSE_NONE</code>
	 * causes no traversal action to be taken.
	 * 
	 * When used in conjuction with the <code>doit</code> field, the
	 * traversal detail field can be useful when overriding the default
	 * traversal mechanism for a control. For example, setting the doit
	 * field to <code>false</code> will cancel the operation and allow
	 * the traversal key stroke to be delivered to the control. Setting
	 * the doit field to <code>true</code> indicates that the traversal
	 * described by the detail field is to be performed.
	 */
    public int detail;

    static final long serialVersionUID = 3257565105301239349L;

    /**
 * Constructs a new instance of this class based on the
 * information in the given untyped event.
 *
 * @param e the untyped event containing the information
 */
    public  TraverseEvent(Event e) {
        super(e);
        this.detail = e.detail;
    }

    /**
 * Returns a string containing a concise, human-readable
 * description of the receiver.
 *
 * @return a string representation of the event
 */
    public String toString() {
        String string = super.toString();
        return // remove trailing '}'
        string.substring(0, string.length() - 1) + " detail=" + detail + "}";
    }
}
