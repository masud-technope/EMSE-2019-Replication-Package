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

public class IStorage extends IUnknown {

    public  IStorage(int address) {
        super(address);
    }

    public int Commit(int grfCommitFlag) {
        return COM.VtblCall(9, address, grfCommitFlag);
    }

    public int CopyTo(//Number of elements in rgiidExclude
    int ciidExclude, //Array of interface identifiers (IIDs)
    GUID rgiidExclude, //Points to a block of stream names in the storage object
    String[] snbExclude, //Points to destination storage object
    int pstgDest) {
        // we only support snbExclude = null
        if (snbExclude != null) {
            return COM.E_INVALIDARG;
        }
        return COM.VtblCall(7, address, ciidExclude, rgiidExclude, 0, pstgDest);
    }

    public int CreateStorage(//Pointer to the name of the new storage object
    String pwcsName, //Access mode for the new storage object  
    int grfMode, //Reserved; must be zero
    int reserved1, //Reserved; must be zero
    int reserved2, //Pointer to new storage object
    int[] ppStg) {
        // create a null terminated array of char
        char[] buffer = null;
        if (pwcsName != null) {
            buffer = (pwcsName + "\0").toCharArray();
        }
        return COM.VtblCall(5, address, buffer, grfMode, reserved1, reserved2, ppStg);
    }

    public int CreateStream(//Pointer to the name of the new stream
    String pwcsName, //Access mode for the new stream  
    int grfMode, //Reserved; must be zero  
    int reserved1, //Reserved; must be zero  
    int reserved2, //Pointer to new stream object
    int[] ppStm) {
        // create a null terminated array of char
        char[] buffer = null;
        if (pwcsName != null) {
            buffer = (pwcsName + "\0").toCharArray();
        }
        return COM.VtblCall(3, address, buffer, grfMode, reserved1, reserved2, ppStm);
    }

    public int DestroyElement(String pwcsName) {
        // create a null terminated array of char
        char[] buffer = null;
        if (pwcsName != null) {
            buffer = (pwcsName + "\0").toCharArray();
        }
        return COM.VtblCall(12, address, buffer);
    }

    public int EnumElements(//Reserved; must be zero
    int reserved1, //Reserved; must be NULL
    int reserved2, //Reserved; must be zero
    int reserved3, //Pointer to output variable that
    int[] ppenum) // receives the IEnumSTATSTG interface 
    {
        return COM.VtblCall(11, address, reserved1, reserved2, reserved3, ppenum);
    }

    public int OpenStorage(//Pointer to the name of the                           
    String pwcsName, //Must be NULL.
    int pstgPriority, //Access mode for the new storage object
    int grfMode, //Must be NULL.
    String snbExclude[], //Reserved; must be zero
    int reserved, //Pointer to opened storage object
    int[] ppStg) {
        // create a null terminated array of char
        char[] buffer = null;
        if (pwcsName != null) {
            buffer = (pwcsName + "\0").toCharArray();
        }
        // we only support the case where snbExclude = null
        if (snbExclude != null) {
            return COM.E_INVALIDARG;
        }
        return COM.VtblCall(6, address, buffer, pstgPriority, grfMode, 0, reserved, ppStg);
    }

    public int OpenStream(//Pointer to name of stream to open
    String pwcsName, //Reserved; must be NULL  
    int reserved1, //Access mode for the new stream  
    int grfMode, //Reserved; must be zero
    int reserved2, //Pointer to output variable
    int[] ppStm) // that receives the IStream interface pointer
    {
        // create a null terminated array of char
        char[] buffer = null;
        if (pwcsName != null) {
            buffer = (pwcsName + "\0").toCharArray();
        }
        return COM.VtblCall(4, address, buffer, reserved1, grfMode, reserved2, ppStm);
    }

    public int RenameElement(//Pointer to the name of the
    String pwcsOldName, //Pointer to the new name for
    String pwcsNewName) // the specified element
    {
        // create a null terminated array of char
        char[] buffer1 = null;
        if (pwcsOldName != null) {
            buffer1 = (pwcsOldName + "\0").toCharArray();
        }
        // create a null terminated array of char
        char[] buffer2 = null;
        if (pwcsNewName != null) {
            buffer2 = (pwcsNewName + "\0").toCharArray();
        }
        return COM.VtblCall(13, address, buffer1, buffer2);
    }

    public int Revert() {
        return COM.VtblCall(10, address);
    }

    public int SetClass(//CLSID to be assigned to the storage object
    GUID clsid) {
        return COM.VtblCall(15, address, clsid);
    }
}
