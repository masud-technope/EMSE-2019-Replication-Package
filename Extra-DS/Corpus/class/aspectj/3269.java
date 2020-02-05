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

/**
 * @author Mik Kersten
 */
public abstract class HierarchyWalker {

    public  HierarchyWalker() {
        super();
    }

    public  HierarchyWalker(IHierarchy hierarchy) {
    //		this.hierarchy = hierarchy;
    }

    protected void preProcess(IProgramElement node) {
    }

    protected void postProcess(IProgramElement node) {
    }

    public IProgramElement process(IProgramElement node) {
        preProcess(node);
        node.walk(this);
        postProcess(node);
        return node;
    }
}