/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.internal.win32;

public class DROPFILES {

    // Offset of the file list from the beginning of this structure, in bytes.
    public int pFiles;

    //	POINT pt; // Drop point. The coordinates depend on fNC.
    public int pt_x;

    public int pt_y;

    // Nonclient area flag. If this member is TRUE, pt specifies the screen 
    public int fNC;

    // coordinates of a point in a window's nonclient area. If it is FALSE, 
    // pt specifies the client coordinates of a point in the client area. 
    // Value that indicates whether the file contains ANSI or Unicode 
    public int fWide;

    // characters. If it is zero, it contains ANSI characters. Otherwise, it 
    // contains Unicode characters.
    public static final int sizeof = 20;
}
