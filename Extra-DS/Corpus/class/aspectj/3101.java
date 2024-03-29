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
package org.aspectj.asm;

import java.io.Serializable;
import java.util.*;
import org.aspectj.asm.internal.ProgramElement;
import org.aspectj.bridge.ISourceLocation;

/**
 * @author Mik Kersten
 */
public interface IHierarchy extends Serializable {

    public static final IProgramElement NO_STRUCTURE = new ProgramElement("<build to view structure>", IProgramElement.Kind.ERROR, null);

    public IProgramElement getElement(String handle);

    public IProgramElement getRoot();

    public void setRoot(IProgramElement root);

    public void addToFileMap(Object key, Object value);

    public boolean removeFromFileMap(Object key);

    public void setFileMap(HashMap fileMap);

    public Object findInFileMap(Object key);

    public Set getFileMapEntrySet();

    public boolean isValid();

    /**
	 * @return	null if not found
	 */
    public IProgramElement findElementForHandle(String handle);

    /** 
	 * Returns the first match
	 * 
	 * @param parent
	 * @param kind		not null
	 * @return null if not found
	 */
    public IProgramElement findElementForSignature(IProgramElement parent, IProgramElement.Kind kind, String signature);

    /** 
	 * Returns the first match
	 * 
	 * @param parent
	 * @param kind		not null
	 * @return null if not found
	 */
    public IProgramElement findElementForLabel(IProgramElement parent, IProgramElement.Kind kind, String label);

    /**
	 * @param packageName	if null default package is searched
	 * @param className 	can't be null
	 */
    public IProgramElement findElementForType(String packageName, String typeName);

    /**
	 * @param		sourceFilePath	modified to '/' delimited path for consistency
	 * @return		a new structure node for the file if it was not found in the model
	 */
    public IProgramElement findElementForSourceFile(String sourceFile);

    /**
	 * TODO: discriminate columns
	 */
    public IProgramElement findElementForSourceLine(ISourceLocation location);

    /**
	 * Never returns null 
	 * 
	 * @param		sourceFilePath	canonicalized path for consistency
	 * @param 		lineNumber		if 0 or 1 the corresponding file node will be returned
	 * @return		a new structure node for the file if it was not found in the model
	 */
    public IProgramElement findElementForSourceLine(String sourceFilePath, int lineNumber);

    public IProgramElement findElementForOffSet(String sourceFilePath, int lineNumber, int offSet);

    public String getConfigFile();

    public void setConfigFile(String configFile);

    public void flushTypeMap();

    public void flushHandleMap();

    public void updateHandleMap(Set deletedFiles);
}
