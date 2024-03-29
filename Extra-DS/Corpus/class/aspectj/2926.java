/* Copyright (c) 2002 Contributors.
 * 
 * This program and the accompanying materials are made available 
 * under the terms of the Common Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html 
 *  
 * Contributors: 
 *     PARC     initial implementation 
 */
package org.aspectj.weaver;

import java.io.IOException;
import java.util.Locale;
import junit.framework.TestCase;
import org.aspectj.apache.bcel.generic.Instruction;
import org.aspectj.apache.bcel.util.ByteSequence;

public class LocaleTest extends TestCase {

    public  LocaleTest(String name) {
        super(name);
    }

    public void testNormalLocale() {
        doBipush();
    }

    public void testTurkishLocale() {
        Locale def = Locale.getDefault();
        Locale.setDefault(new Locale("tr", ""));
        try {
            doBipush();
        } finally {
            Locale.setDefault(def);
        }
    }

    private static void doBipush() {
        try {
            Instruction.readInstruction(new ByteSequence(new byte[] { // bipush 
            (byte) 16, // data for bipush
            (byte) 3 }));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
