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

public class PRINTDLG {

    // DWORD
    public int lStructSize;

    // HWND
    public int hwndOwner;

    // HGLOBAL
    public int hDevMode;

    // HGLOBAL
    public int hDevNames;

    // HDC
    public int hDC;

    // DWORD
    public int Flags;

    // WORD
    public short nFromPage;

    // WORD
    public short nToPage;

    // WORD
    public short nMinPage;

    // WORD
    public short nMaxPage;

    // WORD
    public short nCopies;

    // HINSTANCE
    public int hInstance;

    // LPARAM
    public int lCustData;

    // LPPRINTHOOKPROC
    public int lpfnPrintHook;

    // LPSETUPHOOKPROC
    public int lpfnSetupHook;

    // LPCTSTR
    public int lpPrintTemplateName;

    // LPCTSTR
    public int lpSetupTemplateName;

    // HGLOBAL
    public int hPrintTemplate;

    // HGLOBAL
    public int hSetupTemplate;

    public static final int sizeof = 66;
}
