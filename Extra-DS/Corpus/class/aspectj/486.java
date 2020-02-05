/* *******************************************************************
 * Copyright (c) 2004 IBM Corporation
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Common Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html 
 *  
 * Contributors: 
 *     Adrian Colyer, 
 * ******************************************************************/
package org.aspectj.tools.ajc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import junit.framework.TestCase;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.testing.util.TestUtil;
import org.aspectj.weaver.loadtime.WeavingURLClassLoader;

/**
 * A TestCase class that acts as the superclass for all test cases wishing
 * to drive the ajc compiler.
 * <p>
 * This class provides a number of utility methods that make programmatic 
 * testing of the compiler easy. See AjcTestCaseTest for a couple of simple
 * tests written using this class.
 * </p>
 * <p>
 * See the XMLBasedAjcTestCase subclass for TestCase class that can be 
 * used to drive compiler tests based on an ajcTests.xml format test
 * specification file.</p>
 * @see org.aspectj.tools.ajc.AjcTestCase.Message
 * @see org.aspectj.tools.ajc.AjcTestCase.MessageSpec
 * @see org.aspectj.tools.ajc.AjcTestCase.RunResult
 * @see org.aspectj.tools.ajc.AjcTestCaseTest
 * @see org.aspectj.testing.XMLBasedAjcTestCase
 */
public class AjcTestCase extends TestCase {

    private RunResult lastRunResult;

    /**
	 * The Ajc (compiler) instance used for thet test. Created afresh
	 * during the test setup.
	 */
    protected Ajc ajc;

    public static final String DEFAULT_CLASSPATH_ENTRIES = File.pathSeparator + ".." + File.separator + "runtime" + File.separator + "bin" + File.pathSeparator + ".." + File.separator + "testing-client" + File.separator + "bin" + File.pathSeparator + ".." + File.separator + "bridge" + File.separator + "bin" + File.pathSeparator + ".." + File.separator + "util" + File.separator + "bin" + File.pathSeparator + ".." + File.separator + "aspectj5rt" + File.separator + "bin" + File.pathSeparator + ".." + File.separator + "lib" + File.separator + "junit" + File.separator + "junit.jar" + File.pathSeparator + ".." + File.separator + "loadtime" + File.separator + "bin" + File.pathSeparator + ".." + File.separator + "weaver" + File.separator + "bin" + File.pathSeparator + ".." + File.separator + "weaver5" + File.separator + "bin" + // bin directories.  This means for the necessary types to be found we have to put these jars on the classpath:
    File.pathSeparator + ".." + File.separator + "aj-build" + File.separator + "jars" + File.separator + "bridge.jar" + File.pathSeparator + ".." + File.separator + "aj-build" + File.separator + "jars" + File.separator + "util.jar" + File.pathSeparator + ".." + File.separator + "aj-build" + File.separator + "jars" + File.separator + "loadtime.jar" + File.pathSeparator + ".." + File.separator + "aj-build" + File.separator + "jars" + File.separator + "weaver.jar" + File.pathSeparator + ".." + File.separator + "aj-build" + File.separator + "jars" + File.separator + "weaver5.jar" + File.pathSeparator + ".." + File.separator + "aj-build" + File.separator + "jars" + File.separator + "asm.jar" + File.pathSeparator + ".." + File.separator + "lib" + File.separator + "test" + File.separator + "testing-client.jar" + // hmmm, this next one should perhaps point to an aj-build jar...
    File.pathSeparator + ".." + File.separator + "lib" + File.separator + "test" + File.separator + "aspectjrt.jar";

    /*
	 * Save reference to real stderr and stdout before starting redirection
	 */
    public static final PrintStream err = System.err;

    public static final PrintStream out = System.out;

    private static final DelegatingOutputStream delegatingErr;

    private static final DelegatingOutputStream delegatingOut;

    //getBoolean("org.aspectj.tools.ajc.AjcTestCase.verbose",false); 
    public static final boolean DEFAULT_VERBOSE = false;

    public static final boolean DEFAULT_ERR_VERBOSE = getBoolean("org.aspectj.tools.ajc.AjcTestCase.verbose.err", DEFAULT_VERBOSE);

    public static final boolean DEFAULT_OUT_VERBOSE = getBoolean("org.aspectj.tools.ajc.AjcTestCase.verbose.out", DEFAULT_VERBOSE);

    /**
	 * Helper class that represents the specification of an individual
	 * message expected to be produced during a compilation run.
	 * <p>
	 * Message objects are combined in a MessageSpec which can then be 
	 * passed to the various assertMessage methods.</p>
	 * @see org.aspectj.tools.ajc.AjcTestCase.MessageSpec
	 */
    public static class Message {

        private int line = -1;

        private String text;

        private String sourceFileName;

        private ISourceLocation[] seeAlsos;

        /**
		 * Create a message that will match any compiler message on
		 * the given line.
		 */
        public  Message(int line) {
            this.line = line;
        }

        /**
		 * Create a message that will match any compiler message on
		 * the given line, where the message text contains <code>text</code>.
		 */
        public  Message(int line, String text) {
            this.line = line;
            this.text = text;
        }

        /**
		 * Create a message that will match any compiler message on
		 * the given line, where the message text contains <code>text</code>.
		 * <p>
		 * If srcFile is non-null, the source file location of the message must
		 * end with <code>srcFile</code>.
		 * </p>
		 * <p>
		 * If <code>seeAlso</code> is non-null, each source location in seeAlso
		 * must be matched by an extraSourceLocation in the message.
		 * </p>
		 */
        public  Message(int line, String srcFile, String text, ISourceLocation[] seeAlso) {
            this.line = line;
            StringBuffer srcFileName = new StringBuffer();
            if (srcFile != null) {
                char[] chars = srcFile.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if ((chars[i] == '\\') || (chars[i] == '/')) {
                        srcFileName.append(File.separator);
                    } else {
                        srcFileName.append(chars[i]);
                    }
                }
                this.sourceFileName = srcFileName.toString();
            }
            this.text = text;
            this.seeAlsos = seeAlso;
        }

        public  Message(String text) {
            this.text = text;
        }

        public boolean matches(IMessage message) {
            ISourceLocation loc = message.getSourceLocation();
            if ((loc == null) && ((line != -1) || (sourceFileName != null))) {
                return false;
            }
            if (line != -1) {
                if (loc.getLine() != line) {
                    return false;
                }
            }
            if (sourceFileName != null) {
                if (!loc.getSourceFile().getPath().endsWith(sourceFileName)) {
                    return false;
                }
            }
            if (text != null) {
                if (message.getMessage().indexOf(text) == -1) {
                    return false;
                }
            }
            if (seeAlsos != null) {
                List extraLocations = message.getExtraSourceLocations();
                if (extraLocations.size() != seeAlsos.length) {
                    return false;
                }
                for (int i = 0; i < seeAlsos.length; i++) {
                    if (!hasAMatch(extraLocations, seeAlsos[i])) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean hasAMatch(List srcLocations, ISourceLocation sLoc) {
            for (Iterator iter = srcLocations.iterator(); iter.hasNext(); ) {
                ISourceLocation thisLoc = (ISourceLocation) iter.next();
                if (thisLoc.getLine() == sLoc.getLine()) {
                    if (thisLoc.getSourceFile().getPath().equals(sLoc.getSourceFile().getPath())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public String toString() {
            StringBuffer buff = new StringBuffer();
            buff.append("message ");
            if (sourceFileName != null) {
                buff.append("in file ");
                buff.append(sourceFileName);
                buff.append(" ");
            }
            if (line != -1) {
                buff.append("on line ");
                buff.append(line);
                buff.append(" ");
            }
            if (text != null) {
                buff.append("containing text '");
                buff.append(text);
                buff.append("' ");
            }
            if (seeAlsos != null) {
                buff.append("\n\twith see alsos:");
                for (int i = 0; i < seeAlsos.length; i++) {
                    buff.append("\t\t");
                    buff.append(seeAlsos[i].getSourceFile().getPath());
                    buff.append(":");
                    buff.append(seeAlsos[i].getLine());
                }
            }
            return buff.toString();
        }
    }

    public static class MessageSpec {

        public static final MessageSpec EMPTY_MESSAGE_SET = new MessageSpec(null, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST);

        boolean ignoreInfos = true;

        public List fails;

        public List infos;

        public List warnings;

        public List errors;

        public List weaves;

        public void setInfoComparison(boolean enabled) {
            this.ignoreInfos = !enabled;
        }

        public boolean isIgnoringInfoMessages() {
            return ignoreInfos;
        }

        public  MessageSpec(List infos, List warnings, List errors, List fails, List weaves) {
            if (infos != null) {
                this.infos = infos;
                ignoreInfos = false;
            } else {
                this.infos = Collections.EMPTY_LIST;
            }
            this.warnings = ((warnings == null) ? Collections.EMPTY_LIST : warnings);
            this.errors = ((errors == null) ? Collections.EMPTY_LIST : errors);
            this.fails = ((fails == null) ? Collections.EMPTY_LIST : fails);
            this.weaves = ((weaves == null) ? Collections.EMPTY_LIST : weaves);
        }

        public  MessageSpec(List infos, List warnings, List errors) {
            this(infos, warnings, errors, null, null);
        }

        public  MessageSpec(List warnings, List errors) {
            this(null, warnings, errors, null, null);
        }
    }

    public static class EmptyMessageSpec extends MessageSpec {

        public  EmptyMessageSpec() {
            super(null, null);
        }
    }

    public static class RunResult {

        private String command;

        private String stdOut;

        private String stdErr;

        protected  RunResult(String command, String stdOut, String stdErr) {
            this.command = command;
            this.stdOut = stdOut;
            this.stdErr = stdErr;
        }

        public String getCommand() {
            return command;
        }

        public String getStdOut() {
            return stdOut;
        }

        public String getStdErr() {
            return stdErr;
        }

        public String toString() {
            return command;
        }
    }

    public void assertNoMessages(CompilationResult result) {
        assertNoMessages(result, "Not expecting any compiler messages to be produced");
    }

    public void assertNoMessages(CompilationResult result, String message) {
        assertMessages(result, message, MessageSpec.EMPTY_MESSAGE_SET);
    }

    public void assertMessages(CompilationResult result, MessageSpec expected) {
        assertMessages(result, "Compilation results did not meet expected messages specification", expected);
    }

    public void assertMessages(CompilationResult result, String message, MessageSpec expected) {
        if (result == null)
            fail("Attempt to compare null compilation results against expected.");
        List missingFails = copyAll(expected.fails);
        List missingInfos = copyAll(expected.infos);
        List missingWarnings = copyAll(expected.warnings);
        List missingErrors = copyAll(expected.errors);
        List missingWeaves = copyAll(expected.weaves);
        List extraFails = copyAll(result.getFailMessages());
        List extraInfos = copyAll(result.getInfoMessages());
        List extraWarnings = copyAll(result.getWarningMessages());
        List extraErrors = copyAll(result.getErrorMessages());
        List extraWeaves = copyAll(result.getWeaveMessages());
        compare(expected.fails, result.getFailMessages(), missingFails, extraFails);
        compare(expected.warnings, result.getWarningMessages(), missingWarnings, extraWarnings);
        compare(expected.errors, result.getErrorMessages(), missingErrors, extraErrors);
        if (!expected.isIgnoringInfoMessages()) {
            compare(expected.infos, result.getInfoMessages(), missingInfos, extraInfos);
        }
        compare(expected.weaves, result.getWeaveMessages(), missingWeaves, extraWeaves);
        boolean infosEmpty = expected.isIgnoringInfoMessages() ? true : (missingInfos.isEmpty() && extraInfos.isEmpty());
        if (!(missingFails.isEmpty() && missingWarnings.isEmpty() && missingErrors.isEmpty() && missingWeaves.isEmpty() && extraFails.isEmpty() && extraWarnings.isEmpty() && extraErrors.isEmpty() && extraWeaves.isEmpty() && infosEmpty)) {
            StringBuffer failureReport = new StringBuffer(message);
            failureReport.append("\n");
            if (!expected.isIgnoringInfoMessages()) {
                addMissing(failureReport, "info", missingInfos);
            }
            addMissing(failureReport, "warning", missingWarnings);
            addMissing(failureReport, "error", missingErrors);
            addMissing(failureReport, "fail", missingFails);
            addMissing(failureReport, "weaveInfo", missingWeaves);
            if (!expected.isIgnoringInfoMessages()) {
                addExtra(failureReport, "info", extraInfos);
            }
            addExtra(failureReport, "warning", extraWarnings);
            addExtra(failureReport, "error", extraErrors);
            addExtra(failureReport, "fail", extraFails);
            addExtra(failureReport, "weaveInfo", extraWeaves);
            failureReport.append("\ncommand was: ajc");
            String[] args = result.getArgs();
            for (int i = 0; i < args.length; i++) {
                failureReport.append(" ");
                failureReport.append(args[i]);
            }
            String report = failureReport.toString();
            System.err.println(failureReport);
            fail(message + "\n" + report);
        }
    }

    protected List newMessageList(Message m1) {
        List ret = new ArrayList();
        ret.add(m1);
        return ret;
    }

    protected List newMessageList(Message m1, Message m2) {
        List ret = new ArrayList();
        ret.add(m1);
        ret.add(m2);
        return ret;
    }

    protected List newMessageList(Message m1, Message m2, Message m3) {
        List ret = new ArrayList();
        ret.add(m1);
        ret.add(m2);
        ret.add(m3);
        return ret;
    }

    protected List newMessageList(Message[] messages) {
        List ret = new ArrayList();
        for (int i = 0; i < messages.length; i++) {
            ret.add(messages[i]);
        }
        return ret;
    }

    public CompilationResult ajc(File baseDir, String[] args) {
        try {
            ajc.setBaseDir(baseDir);
            args = fixupArgs(args);
            return ajc.compile(args);
        } catch (IOException ioEx) {
            fail("IOException thrown during compilation: " + ioEx);
        }
        return null;
    }

    public File getSandboxDirectory() {
        return ajc.getSandboxDirectory();
    }

    public void setShouldEmptySandbox(boolean empty) {
        ajc.setShouldEmptySandbox(empty);
    }

    public RunResult getLastRunResult() {
        return lastRunResult;
    }

    public void testNothingForAntJUnit() {
    }

    public RunResult run(String className) {
        return run(className, new String[0], null);
    }

    public RunResult run(String className, String[] args, String classpath) {
        return run(className, args, null, false);
    }

    public RunResult run(String className, String[] args, String classpath, boolean useLTW) {
        lastRunResult = null;
        StringBuffer cp = new StringBuffer();
        if (classpath != null) {
            cp.append(classpath);
            cp.append(File.pathSeparator);
        }
        cp.append(ajc.getSandboxDirectory().getAbsolutePath());
        cp.append(DEFAULT_CLASSPATH_ENTRIES);
        getAnyJars(ajc.getSandboxDirectory(), cp);
        classpath = cp.toString();
        StringBuffer command = new StringBuffer("java -classpath ");
        command.append(classpath);
        command.append(" ");
        command.append(className);
        for (int i = 0; i < args.length; i++) {
            command.append(" ");
            command.append(args[i]);
        }
        ByteArrayOutputStream baosOut = new ByteArrayOutputStream();
        ByteArrayOutputStream baosErr = new ByteArrayOutputStream();
        StringTokenizer strTok = new StringTokenizer(classpath, File.pathSeparator);
        URL[] urls = new URL[strTok.countTokens()];
        try {
            for (int i = 0; i < urls.length; i++) {
                urls[i] = new File(strTok.nextToken()).getCanonicalFile().toURL();
            }
        } catch (Exception malEx) {
            fail("Bad classpath specification: " + classpath);
        }
        URLClassLoader cLoader;
        if (useLTW) {
            ClassLoader parent = getClass().getClassLoader();
            cLoader = new WeavingURLClassLoader(urls, parent);
        } else {
            cLoader = new URLClassLoader(urls, null);
        }
        try {
            try {
                Class testerClass = cLoader.loadClass("org.aspectj.testing.Tester");
                Method setBaseDir = testerClass.getDeclaredMethod("setBASEDIR", new Class[] { File.class });
                setBaseDir.invoke(null, new Object[] { ajc.getSandboxDirectory() });
            } catch (Exception ex) {
                fail("Unable to prepare org.aspectj.testing.Tester for test run: " + ex);
            }
            startCapture(baosErr, baosOut);
            Class toRun = cLoader.loadClass(className);
            Method mainMethod = toRun.getMethod("main", new Class[] { String[].class });
            mainMethod.invoke(null, new Object[] { args });
            lastRunResult = new RunResult(command.toString(), new String(baosOut.toByteArray()), new String(baosErr.toByteArray()));
        } catch (ClassNotFoundException cnf) {
            fail("Can't find class: " + className);
        } catch (NoSuchMethodException nsm) {
            fail(className + " does not have a main method");
        } catch (IllegalAccessException illEx) {
            fail("main method in class " + className + " is not public");
        } catch (InvocationTargetException invTgt) {
            fail("Exception thrown by " + className + ".main(String[]) :" + invTgt.getTargetException());
        } finally {
            stopCapture(baosErr, baosOut);
        }
        return lastRunResult;
    }

    protected String[] fixupArgs(String[] args) {
        if (null == args) {
            return null;
        }
        int cpIndex = -1;
        boolean hasruntime = false;
        for (int i = 0; i < args.length - 1; i++) {
            args[i] = adaptToPlatform(args[i]);
            if ("-classpath".equals(args[i])) {
                cpIndex = i;
                String next = args[i + 1];
                hasruntime = ((null != next) && (-1 != next.indexOf("aspectjrt.jar")));
            }
        }
        if (-1 == cpIndex) {
            String[] newargs = new String[args.length + 2];
            newargs[0] = "-classpath";
            newargs[1] = TestUtil.aspectjrtPath().getPath();
            System.arraycopy(args, 0, newargs, 2, args.length);
            args = newargs;
        } else {
            if (!hasruntime) {
                cpIndex++;
                String[] newargs = new String[args.length];
                System.arraycopy(args, 0, newargs, 0, args.length);
                newargs[cpIndex] = args[cpIndex] + File.pathSeparator + TestUtil.aspectjrtPath().getPath();
                args = newargs;
            }
        }
        return args;
    }

    private String adaptToPlatform(String s) {
        String ret = s.replace(';', File.pathSeparatorChar);
        return ret;
    }

    private List copyAll(List in) {
        if (in == Collections.EMPTY_LIST)
            return in;
        List out = new ArrayList();
        for (Iterator iter = in.iterator(); iter.hasNext(); ) {
            out.add(iter.next());
        }
        return out;
    }

    private void compare(List expected, List actual, List missingElements, List extraElements) {
        for (Iterator expectedIter = expected.iterator(); expectedIter.hasNext(); ) {
            Message expectedMessage = (Message) expectedIter.next();
            for (Iterator actualIter = actual.iterator(); actualIter.hasNext(); ) {
                IMessage actualMessage = (IMessage) actualIter.next();
                if (expectedMessage.matches(actualMessage)) {
                    missingElements.remove(expectedMessage);
                    extraElements.remove(actualMessage);
                }
            }
        }
    }

    private void addMissing(StringBuffer buff, String type, List messages) {
        if (!messages.isEmpty()) {
            buff.append("Missing expected ");
            buff.append(type);
            buff.append(" messages:\n");
            for (Iterator iter = messages.iterator(); iter.hasNext(); ) {
                buff.append("\t");
                buff.append(iter.next().toString());
                buff.append("\n");
            }
        }
    }

    private void addExtra(StringBuffer buff, String type, List messages) {
        if (!messages.isEmpty()) {
            buff.append("Unexpected ");
            buff.append(type);
            buff.append(" messages:\n");
            for (Iterator iter = messages.iterator(); iter.hasNext(); ) {
                buff.append("\t");
                buff.append(iter.next().toString());
                buff.append("\n");
            }
        }
    }

    private void getAnyJars(File dir, StringBuffer buff) {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().endsWith(".jar")) {
                buff.append(File.pathSeparator);
                buff.append(files[i].getAbsolutePath());
            } else if (files[i].isDirectory()) {
                getAnyJars(files[i], buff);
            }
        }
    }

    private static void startCapture(OutputStream errOS, OutputStream outOS) {
        delegatingErr.add(errOS);
        delegatingOut.add(outOS);
        delegatingErr.setVerbose(DEFAULT_ERR_VERBOSE);
        delegatingOut.setVerbose(DEFAULT_OUT_VERBOSE);
    }

    private static void stopCapture(OutputStream errOS, OutputStream outOS) {
        delegatingErr.setVerbose(true);
        delegatingOut.setVerbose(true);
        delegatingErr.remove(errOS);
        delegatingOut.remove(outOS);
    }

    private static boolean getBoolean(String name, boolean def) {
        String defaultValue = String.valueOf(def);
        String value = System.getProperty(name, defaultValue);
        return Boolean.valueOf(value).booleanValue();
    }

    protected void setUp() throws Exception {
        super.setUp();
        ajc = new Ajc();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    static {
        delegatingErr = new DelegatingOutputStream(err);
        System.setErr(new PrintStream(delegatingErr));
        delegatingOut = new DelegatingOutputStream(out);
        System.setOut(new PrintStream(delegatingOut));
    }
}
