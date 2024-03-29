/* *******************************************************************
 * Copyright (c) 2004 Contributors.
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Common Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html 
 *  
 * Contributors: 
 *    Andy Clement     Initial version
 * ******************************************************************/
package org.aspectj.ajde;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.aspectj.ajde.internal.CompilerAdapter;
import org.aspectj.util.FileUtil;

public class ReweavableTestCase extends AjdeTestCase {

    private CompilerAdapter compilerAdapter;

    public static final String PROJECT_DIR = "ReweavableTest";

    private static final boolean debugTests = false;

    public static final String binDir = "bin";

    public static final String indir1Name = "indir1";

    public static final String indir2Name = "indir2";

    public static final String injarName = "injar.jar";

    public static final String outjarName = "/bin/output.jar";

    /**
	 * Constructor for JarResourceCopyTestCase.
	 * @param arg0
	 */
    public  ReweavableTestCase(String arg0) {
        super(arg0);
    }

    /*
	 * Ensure the output directpry in clean
	 */
    protected void setUp() throws Exception {
        super.setUp(PROJECT_DIR);
        FileUtil.deleteContents(openFile(binDir));
    }

    /**
	 * Aim: Check we haven't damaged 'normal compilation' when not supplying -Xreweavable.  Also determines
	 *      baseline sizes for the compiled class files for later comparison.
	 * 
	 * Inputs to the compiler:
	 *   NonReweavable1.lst
	 *   -> CalculatePI.java
	 *   -> Logger.aj
	 *   -> -verbose
	 *   -> -noExit
	 * 
	 * Expected result = Compile successful, the types will not be reweavable and the weaver
	 *                   should not report it is running in reweavable mode.
	 */
    public void testNonReweavableCompile() {
        if (debugTests)
            System.out.println("testNonReweavableCompile: Building with NonReweavable1.lst");
        compilerAdapter = new CompilerAdapter();
        compilerAdapter.showInfoMessages(true);
        compilerAdapter.compile((String) openFile("NonReweavable1.lst").getAbsolutePath(), new BPM(), false);
        assertFalse("Did not expect to find a message about the weaver operating in reweavable mode", checkFor("weaver operating in reweavable mode"));
        File fCalc = openFile("bin/CalculatePI.class");
        File fLog = openFile("bin/Logger.class");
        assertTrue("bin/CalculatePI.class should exist?!?", fCalc.exists());
        assertTrue("bin/Logger.class should exist?!?", fLog.exists());
        if (debugTests)
            System.out.println("CalculatePI.class is of size: " + fCalc.length());
        if (debugTests)
            System.out.println("Logger.class is of size: " + fLog.length());
        if (debugTests)
            System.out.println("\n\n\n");
        /*nonreweavesize_CalculatePI = (int)*/
        fCalc.length();
        /*nonreweavesize_Logger = (int)*/
        fLog.length();
    }

    /**
	 * Aim: Basic call to -Xreweavable.  Weaver should report it is in reweavable mode and the
	 *      classes produced should be much larger than normal classes (those produced in the first
	 *      test).
	 * 
	 * Inputs to the compiler:
	 *   Reweavable1.lst
	 *   -> CalculatePI.java
	 *   -> Logger.aj
	 *   -> -Xreweavable
	 *   -> -verbose
	 *   -> -noExit
	 * 
	 * Expected result = Compile successful, the types will be reweavable and the weaver
	 *                   should report it is running in reweavable mode.  The files produced
	 *  				 should be larger than those created during the last test.
	 */
    public void testReweavableCompile() {
        if (debugTests)
            System.out.println("testReweavableCompile: Building with Reweavable1.lst");
        compilerAdapter = new CompilerAdapter();
        compilerAdapter.showInfoMessages(true);
        compilerAdapter.compile((String) openFile("Reweavable1.lst").getAbsolutePath(), new BPM(), false);
        assertTrue("Expected a message about operating in reweavable mode, but didn't get one", checkFor("weaver operating in reweavable mode"));
        File fCalc = openFile("bin/CalculatePI.class");
        File fLog = openFile("bin/Logger.class");
        assertTrue("bin/CalculatePI.class should exist?!?", fCalc.exists());
        assertTrue("bin/Logger.class should exist?!?", fLog.exists());
        if (debugTests)
            System.out.println("CalculatePI.class is of size: " + fCalc.length());
        if (debugTests)
            System.out.println("Logger.class is of size: " + fLog.length());
        // Temporarily remove these tests - it seems the order in which the testXXX methods are run cannot be relied upon
        // so reweavablesize_XXX fields might not have been set yet.
        //		assertTrue("Reweavable version should be larger than non-reweavable version of CalculatePI",
        //		  fCalc.length()>nonreweavesize_CalculatePI);
        //		assertTrue("Reweavable version should be larger than non-reweavable version of Logger",
        //		  fLog.length()>nonreweavesize_Logger);
        /*reweavablesize_CalculatePI = (int)*/
        fCalc.length();
        /*reweavablesize_Logger = (int)*/
        fLog.length();
        if (debugTests)
            System.out.println("\n\n\n");
    }

    /**
	 * Aim: Use the optional ':compress' modifier on -Xreweavable.  This causes some of the meta-data
	 *      for use in reweaving to be compressed.  It should succeed and produce class files smaller
	 *      than straight -Xreweavable but larger than without specifying -Xreweavable.
	 * 
	 * Inputs to the compiler:
	 *   ReweavableCompress1.lst
	 *   -> CalculatePI.java
	 *   -> Logger.aj
	 *   -> -Xreweavable:compress
	 *   -> -verbose
	 *   -> -noExit
	 * 
	 * Expected result = Compile successful, the types will be reweavable and the weaver
	 *                   should report it is running in reweavable mode.  The files created should
	 * 					 have a size between the non-reweavable versions and the reweavable (without
	 * 					 compression) versions.
	 */
    public void testReweavableCompressCompile() {
        if (debugTests)
            System.out.println("testReweavableCompressCompile: Building with ReweavableCompress1.lst");
        compilerAdapter = new CompilerAdapter();
        compilerAdapter.showInfoMessages(true);
        compilerAdapter.compile((String) openFile("ReweavableCompress1.lst").getAbsolutePath(), new BPM(), false);
        assertTrue("Expected a message about operating in reweavable mode, but didn't get one", checkFor("weaver operating in reweavable mode"));
        File fCalc = openFile("bin/CalculatePI.class");
        File fLog = openFile("bin/Logger.class");
        assertTrue("bin/CalculatePI.class should exist?!?", fCalc.exists());
        assertTrue("bin/Logger.class should exist?!?", fLog.exists());
        int calclen = (int) fCalc.length();
        int loglen = (int) fLog.length();
        if (debugTests)
            System.out.println("CalculatePI.class is of size: " + calclen);
        if (debugTests)
            System.out.println("Logger.class is of size: " + loglen);
        if (debugTests)
            System.out.println("\n\n\n");
    }

    /**
	 * Aim: The tests above have determined that reweaving appears to be behaving in terms of the .class
	 *      files it is creating.  Now lets actually attempt a reweave.  For this, we build two files
	 *      as reweavable and then build a single file whilst specifying an inpath that contains the
	 *      .class files from the first compile.  This should succeed.
	 * 
	 * Inputs to the first compile:
	 *   Reweavable1.lst
	 *   -> CalculatePI.java
	 *   -> Logger.aj
	 *   -> -Xreweavable
	 *   -> -verbose
	 *   -> -noExit
	 * 
	 * Input to the second compile:
	 *   Reweavable2.lst
	 *   -> SecondAspect.aj
	 *   -> -Xreweavable
	 *   -> -verbose
	 *   -> -noExit
	 *   -inpath bin\.
	 * 
	 * Expected result = Both compiles will succeed.
	 */
    public void testReweavableSimpleCompile() {
        if (debugTests)
            System.out.println("testReweavableSimpleCompile: Building with Reweavable1.lst");
        compilerAdapter = new CompilerAdapter();
        compilerAdapter.showInfoMessages(true);
        compilerAdapter.compile((String) openFile("Reweavable1.lst").getAbsolutePath(), new BPM(), false);
        assertTrue("Expected a message about operating in reweavable mode, but didn't get one", checkFor("weaver operating in reweavable mode"));
        if (debugTests)
            System.out.println("\ntestReweavableSimpleCompile: Building with Reweavable2.lst");
        Set paths = new HashSet();
        paths.add(openFile(binDir));
        ideManager.getProjectProperties().setInpath(paths);
        compilerAdapter.compile((String) openFile("Reweavable2.lst").getAbsolutePath(), new BPM(), false);
        String expMessage = "successfully verified type Logger exists";
        assertTrue("Expected message '" + expMessage + "' but did not find it", checkFor(expMessage));
        File fCalc = openFile("bin/CalculatePI.class");
        File fLog = openFile("bin/Logger.class");
        File fSec = openFile("bin/SecondAspect.class");
        assertTrue("bin/CalculatePI.class should exist?!?", fCalc.exists());
        assertTrue("bin/Logger.class should exist?!?", fLog.exists());
        assertTrue("bin/SecondAspect.class should exist?!?", fSec.exists());
        if (debugTests)
            System.out.println("\n\n\n");
    }

    /**
	 * Aim: Based on the test above, if we delete Logger.class between the first and second compiles
	 *      the second compile should fail because there is not enough information to reweave CalculatePI
	 * 
	 * Inputs to the first compile:
	 *   Reweavable1.lst
	 *   -> CalculatePI.java
	 *   -> Logger.aj
	 *   -> -Xreweavable
	 *   -> -verbose
	 *   -> -noExit
	 * 
	 * Input to the second compile:
	 *   Reweavable2.lst
	 *   -> SecondAspect.aj
	 *   -> -Xreweavable
	 *   -> -verbose
	 *   -> -noExit
	 *   -inpath bin\.
	 * 
	 * Expected result = Second compile will fail - reporting that Logger is missing (it 'touched' in the first compile CalculatePI)
	 */
    public void testForReweavableSimpleErrorCompile() {
        if (debugTests)
            System.out.println("testForReweavableSimpleErrorCompile: Building with Reweavable2.lst");
        compilerAdapter = new CompilerAdapter();
        compilerAdapter.showInfoMessages(true);
        compilerAdapter.compile((String) openFile("Reweavable1.lst").getAbsolutePath(), new BPM(), false);
        assertTrue("Expected a message about operating in reweavable mode, but didn't get one", checkFor("weaver operating in reweavable mode"));
        assertTrue("Could not delete bin/Logger.class??", openFile("bin/Logger.class").delete());
        if (debugTests)
            System.out.println("\ntestForReweavableSimpleErrorCompile: Building with Reweavable2.lst");
        Set paths = new HashSet();
        paths.add(openFile(binDir));
        ideManager.getProjectProperties().setInpath(paths);
        compilerAdapter.compile((String) openFile("Reweavable2.lst").getAbsolutePath(), new BPM(), false);
        String expMessage = "type Logger is needed by reweavable type CalculatePI";
        assertTrue("Expected message '" + expMessage + "' but did not find it", checkFor(expMessage));
        File fCalc = openFile("bin/CalculatePI.class");
        File fLog = openFile("bin/Logger.class");
        File fSec = openFile("bin/SecondAspect.class");
        assertTrue("bin/CalculatePI.class should exist!", fCalc.exists());
        assertTrue("bin/Logger.class should not exist!", !fLog.exists());
        assertTrue("bin/SecondAspect.class should not exist!", fSec.exists());
        if (debugTests)
            System.out.println("\n\n\n");
    }

    /**
	 * Aim: Based on the test above, if we delete Logger.class between the first and second compiles
	 *      the second compile should fail because there is not enough information to reweave CalculatePI
	 * 
	 * Inputs to the first compile:
	 *   TJP1.lst
	 *   -> tjp/Demo.java
	 *   -> tjp/GetInfo.java
	 *   -> -Xreweavable
	 *   -> -verbose
	 *   -> -noExit
	 * 
	 * Now, delete bin\tjp\GetInfo.class and do a compile with:
	 *   TJP2.lst
	 *   -> -Xreweavable
	 *   -> -verbose
	 *   -> -noExit
	 *   -inpath bin\.
	 * 
	 * Expected result = Second compile will fail - reporting that tjp.GetInfo is missing (it 'touched' in the first compile tjp.Demo)
	 */
    public void testErrorScenario2Compile() {
        if (debugTests)
            System.out.println("testErrorScenario2: Building with TJP1.lst");
        compilerAdapter = new CompilerAdapter();
        compilerAdapter.showInfoMessages(true);
        compilerAdapter.compile((String) openFile("TJP1.lst").getAbsolutePath(), new BPM(), false);
        assertTrue("Expected a message about operating in reweavable mode, but didn't get one", checkFor("weaver operating in reweavable mode"));
        assertTrue("Could not delete bin/tjp/GetInfo.class??", openFile("bin/tjp/GetInfo.class").delete());
        if (debugTests)
            System.out.println("\ntestErrorScenario2: Building with TJP2.lst");
        Set paths = new HashSet();
        paths.add(openFile(binDir));
        ideManager.getProjectProperties().setInpath(paths);
        compilerAdapter.compile((String) openFile("TJP2.lst").getAbsolutePath(), new BPM(), false);
        String expMessage = "type tjp.GetInfo is needed by reweavable type tjp.Demo";
        assertTrue("Expected message '" + expMessage + "' but did not find it", checkFor(expMessage));
        File fDemo = openFile("bin/tjp/Demo.class");
        File fGetInfo = openFile("bin/tjp/GetInfo.class");
        assertTrue("bin/tjp/Demo.class should exist!", fDemo.exists());
        assertTrue("bin/tjp/GetInfo.class should not exist!", !fGetInfo.exists());
        if (debugTests)
            System.out.println("\n\n\n");
    }

    public void testWorkingScenario2Compile() {
        if (debugTests)
            System.out.println("testWorkingScenario2: Building with TJP1.lst");
        compilerAdapter = new CompilerAdapter();
        compilerAdapter.showInfoMessages(true);
        compilerAdapter.compile((String) openFile("TJP1.lst").getAbsolutePath(), new BPM(), false);
        assertTrue("Expected a message about operating in reweavable mode, but didn't get one", checkFor("weaver operating in reweavable mode"));
        if (debugTests)
            System.out.println("\ntestWorkingScenario2: Building with TJP2.lst");
        Set paths = new HashSet();
        paths.add(openFile(binDir));
        ideManager.getProjectProperties().setInpath(paths);
        compilerAdapter.compile((String) openFile("TJP2.lst").getAbsolutePath(), new BPM(), false);
        String expMessage = "successfully verified type tjp.GetInfo exists";
        assertTrue("Expected message '" + expMessage + "' but did not find it", checkFor(expMessage));
        File fGetInfo = openFile("bin/tjp/GetInfo.class");
        File fDemo = openFile("bin/tjp/Demo.class");
        assertTrue("bin/tjp/GetInfo.class should exist!", fGetInfo.exists());
        assertTrue("bin/tjp/Demo.class should not exist!", fDemo.exists());
        if (debugTests)
            System.out.println("\n\n\n");
    }

    private class BPM implements BuildProgressMonitor {

        public void start(String configFile) {
        }

        public void setProgressText(String text) {
        }

        public void setProgressBarVal(int newVal) {
        }

        public void incrementProgressBarVal() {
        }

        public void setProgressBarMax(int maxVal) {
        }

        public int getProgressBarMax() {
            return 0;
        }

        public void finish() {
        }
    }

    private boolean checkFor(String what) {
        List ll = ideManager.getCompilationSourceLineTasks();
        for (Iterator iter = ll.iterator(); iter.hasNext(); ) {
            Object element = (Object) iter.next();
            if (element.toString().indexOf(what) != -1)
                return true;
        }
        return false;
    }
}
