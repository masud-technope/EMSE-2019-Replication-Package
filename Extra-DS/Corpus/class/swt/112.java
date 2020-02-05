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
package org.eclipse.swt.custom;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class StackLayout extends Layout {

    /**
	 * marginWidth specifies the number of pixels of horizontal margin
	 * that will be placed along the left and right edges of the layout.
	 *
	 * The default value is 0.
	 */
    public int marginWidth = 0;

    /**
	 * marginHeight specifies the number of pixels of vertical margin
	 * that will be placed along the top and bottom edges of the layout.
	 *
	 * The default value is 0.
	 */
    public int marginHeight = 0;

    /**
 	 * topControl the Control that is displayed at the top of the stack.
 	 * All other controls that are children of the parent composite will not be visible.
 	 */
    public Control topControl;

    protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
        Control children[] = composite.getChildren();
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < children.length; i++) {
            Point size = children[i].computeSize(wHint, hHint, flushCache);
            maxWidth = Math.max(size.x, maxWidth);
            maxHeight = Math.max(size.y, maxHeight);
        }
        int width = maxWidth + 2 * marginWidth;
        int height = maxHeight + 2 * marginHeight;
        if (wHint != SWT.DEFAULT)
            width = wHint;
        if (hHint != SWT.DEFAULT)
            height = hHint;
        return new Point(width, height);
    }

    protected boolean flushCache(Control control) {
        return true;
    }

    protected void layout(Composite composite, boolean flushCache) {
        Control children[] = composite.getChildren();
        Rectangle rect = composite.getClientArea();
        rect.x += marginWidth;
        rect.y += marginHeight;
        rect.width -= 2 * marginWidth;
        rect.height -= 2 * marginHeight;
        for (int i = 0; i < children.length; i++) {
            children[i].setBounds(rect);
            children[i].setVisible(children[i] == topControl);
        }
    }

    String getName() {
        String string = getClass().getName();
        int index = string.lastIndexOf('.');
        if (index == -1)
            return string;
        return string.substring(index + 1, string.length());
    }

    /**
 * Returns a string containing a concise, human-readable
 * description of the receiver.
 *
 * @return a string representation of the event
 */
    public String toString() {
        String string = getName() + " {";
        if (marginWidth != 0)
            string += "marginWidth=" + marginWidth + " ";
        if (marginHeight != 0)
            string += "marginHeight=" + marginHeight + " ";
        if (topControl != null)
            string += "topControl=" + topControl + " ";
        string = string.trim();
        string += "}";
        return string;
    }
}
