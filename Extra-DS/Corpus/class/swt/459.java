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
package org.eclipse.swt.internal.ole.win32;

public class IOleCommandTarget extends IUnknown {

    public  IOleCommandTarget(int address) {
        super(address);
    }

    public int Exec(// Pointer to command group
    GUID pguidCmdGroup, // Identifier of command to execute
    int nCmdID, // Options for executing the command
    int nCmdExecOpt, // Pointer to input arguments
    int pvaIn, // Pointer to command output
    int pvaOut) {
        return COM.VtblCall(4, address, pguidCmdGroup, nCmdID, nCmdExecOpt, pvaIn, pvaOut);
    }

    public int QueryStatus(// Pointer to command group
    GUID pguidCmdGroup, // Number of commands in prgCmds array
    int cCmds, // Array of commands
    OLECMD prgCmds, // Pointer to name or status of command
    OLECMDTEXT pCmdText) {
        // we only support querying for one command at a time
        if (cCmds > 1)
            return COM.E_INVALIDARG;
        return COM.VtblCall(3, address, pguidCmdGroup, cCmds, prgCmds, pCmdText);
    }
}
