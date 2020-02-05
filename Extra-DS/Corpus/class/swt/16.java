/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.events;

import org.eclipse.swt.widgets.Event;

public final class MouseEvent extends TypedEvent {

    /**
	 * the button that was pressed or released; 1 for the
	 * first button, 2 for the second button, and 3 for the
	 * third button, etc.
	 */
    public int button;

    /**
	 * the state of the keyboard modifier keys at the time
	 * the event was generated
	 */
    public int stateMask;

    /**
	 * the widget-relative, x coordinate of the pointer
	 * at the time the mouse button was pressed or released
	 */
    public int x;

    /**
	 * the widget-relative, y coordinate of the pointer
	 * at the time the mouse button was pressed or released
	 */
    public int y;

    static final long serialVersionUID = 3257288037011566898L;

    /**
 * Constructs a new instance of this class based on the
 * information in the given untyped event.
 *
 * @param e the untyped event containing the information
 */
    public  MouseEvent(Event e) {
        super(e);
        this.x = e.x;
        this.y = e.y;
        this.button = e.button;
        this.stateMask = e.stateMask;
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
        string.substring(0, string.length() - 1) + " button=" + button + " stateMask=" + stateMask + " x=" + x + " y=" + y + "}";
    }
}
