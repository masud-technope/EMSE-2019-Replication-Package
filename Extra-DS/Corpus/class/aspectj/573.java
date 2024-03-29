/* *******************************************************************
 * Copyright (c) 2003 Contributors.
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Common Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html 
 *  
 * Contributors: 
 *     Mik Kersten     initial implementation 
 * ******************************************************************/
package org.aspectj.asm.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.aspectj.asm.AsmManager;
import org.aspectj.asm.IElementHandleProvider;
import org.aspectj.bridge.ISourceLocation;

/**
 * Not currently used - uses int keys rather than the full file path as the first part of the handle.
 */
public class OptimizedFullPathHandleProvider implements IElementHandleProvider {

    static final String ID_DELIM = "|";

    Map kToF = new HashMap();

    int key = 1;

    private Integer getKey(String file) {
        Integer k = null;
        if (kToF.values().contains(file)) {
            Set keys = kToF.keySet();
            for (Iterator iter = keys.iterator(); iter.hasNext() && k == null; ) {
                Integer element = (Integer) iter.next();
                if (kToF.get(element).equals(file)) {
                    k = element;
                }
            }
        } else {
            k = new Integer(key);
            kToF.put(k, file);
            key++;
        }
        return k;
    }

    public String createHandleIdentifier(ISourceLocation location) {
        StringBuffer sb = new StringBuffer();
        String file = AsmManager.getDefault().getCanonicalFilePath(location.getSourceFile());
        sb.append(getKey(file).intValue());
        sb.append(ID_DELIM);
        sb.append(location.getLine());
        sb.append(ID_DELIM);
        sb.append(location.getColumn());
        sb.append(ID_DELIM);
        sb.append(location.getOffset());
        return sb.toString();
    }

    public String createHandleIdentifier(File sourceFile, int line, int column, int offset) {
        StringBuffer sb = new StringBuffer();
        sb.append(getKey(AsmManager.getDefault().getCanonicalFilePath(sourceFile)).intValue());
        sb.append(ID_DELIM);
        sb.append(line);
        sb.append(ID_DELIM);
        sb.append(column);
        sb.append(ID_DELIM);
        sb.append(offset);
        return sb.toString();
    }

    public String getFileForHandle(String handle) {
        StringTokenizer st = new StringTokenizer(handle, ID_DELIM);
        String k = st.nextToken();
        return (String) kToF.get(new Integer(k));
    //        return file;
    }

    public int getLineNumberForHandle(String handle) {
        StringTokenizer st = new StringTokenizer(handle, ID_DELIM);
        // skip over the file
        st.nextToken();
        return new Integer(st.nextToken()).intValue();
    }

    public int getOffSetForHandle(String handle) {
        StringTokenizer st = new StringTokenizer(handle, ID_DELIM);
        // skip over the file
        st.nextToken();
        // skip over the line number
        st.nextToken();
        // skip over the column
        st.nextToken();
        return new Integer(st.nextToken()).intValue();
    }
}
