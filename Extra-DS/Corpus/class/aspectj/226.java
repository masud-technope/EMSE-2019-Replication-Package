/* *******************************************************************
 * Copyright (c) 1999-2000 Xerox Corporation. 
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Common Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html 
 *  
 * Contributors: 
 *     Xerox/PARC     initial implementation 
 * ******************************************************************/
package org.aspectj.testing.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import org.aspectj.bridge.AbortException;
import org.aspectj.bridge.IMessage;

/** 
 * misc lang utilities
 */
public class LangUtil {

    /** Delimiter used by split(String) (and ArrayList.toString()?) */
    public static final String SPLIT_DELIM = ", ";

    /** prefix used by split(String) (and ArrayList.toString()?) */
    public static final String SPLIT_START = "[";

    /** suffix used by split(String) (and ArrayList.toString()?) */
    public static final String SPLIT_END = "]";

    /** system-dependent classpath separator */
    public static final String CLASSPATH_SEP;

    private static final String[] NONE = new String[0];

    /** bad: hard-wired unix, windows, mac path separators */
    private static final char[] SEPS = new char[] { '/', '\\', ':' };

    static {
        String ps = ";";
        try {
            ps = System.getProperty("path.separator");
            if (null == ps) {
                ps = ";";
                String cp = System.getProperty("java.class.path");
                if (null != cp) {
                    if (-1 != cp.indexOf(";")) {
                        ps = ";";
                    } else if (-1 != cp.indexOf(":")) {
                        ps = ":";
                    }
                }
            }
        } catch (Throwable t) {
        } finally {
            CLASSPATH_SEP = ps;
        }
    }

    public static String escape(String input, String target, String escape) {
        if (isEmpty(input) || isEmpty(target) || isEmpty(escape)) {
            return input;
        }
        StringBuffer sink = new StringBuffer();
        escape(input, target, escape, sink);
        return sink.toString();
    }

    public static void escape(String input, String target, String escape, StringBuffer sink) {
        if ((null == sink) || isEmpty(input) || isEmpty(target) || isEmpty(escape)) {
            return;
        } else if (-1 == input.indexOf(target)) {
            sink.append(input);
            return;
        }
        throw new Error("unimplemented");
    }

    public static void flatten(List list, FlattenSpec spec, StringBuffer sink) {
        throwIaxIfNull(spec, "spec");
        final FlattenSpec s = spec;
        flatten(list, s.prefix, s.nullFlattened, s.escape, s.delim, s.suffix, sink);
    }

    public static void flatten(List list, String prefix, String nullFlattened, String escape, String delim, String suffix, StringBuffer sink) {
        throwIaxIfNull(list, "list");
        Object[] ra = list.toArray();
        String[] result;
        if (String.class == ra.getClass().getComponentType()) {
            result = (String[]) ra;
        } else {
            result = new String[ra.length];
            for (int i = 0; i < result.length; i++) {
                if (null != ra[i]) {
                    result[i] = ra[i].toString();
                }
            }
        }
        flatten(result, prefix, nullFlattened, escape, delim, suffix, sink);
    }

    public static void flatten(String[] input, FlattenSpec spec, StringBuffer sink) {
        throwIaxIfNull(spec, "spec");
        final FlattenSpec s = spec;
        flatten(input, s.prefix, s.nullFlattened, s.escape, s.delim, s.suffix, sink);
    }

    public static void flatten(String[] strings, String prefix, String nullFlattened, String escape, String delim, String suffix, StringBuffer sink) {
        throwIaxIfNull(strings, "strings");
        if (null == sink) {
            return;
        }
        final boolean haveDelim = (!isEmpty(delim));
        final boolean haveNullFlattened = (null != nullFlattened);
        final boolean escaping = (haveDelim && (null != escape));
        final int numStrings = (null == strings ? 0 : strings.length);
        if (null != prefix) {
            sink.append(prefix);
        }
        for (int i = 0; i < numStrings; i++) {
            String s = strings[i];
            if (null == s) {
                if (!haveNullFlattened) {
                    continue;
                }
                if (haveDelim && (i > 0)) {
                    sink.append(delim);
                }
                sink.append(nullFlattened);
            } else {
                if (haveDelim && (i > 0)) {
                    sink.append(delim);
                }
                if (escaping) {
                    escape(s, delim, escape, sink);
                } else {
                    sink.append(s);
                }
            }
        }
        if (null != suffix) {
            sink.append(suffix);
        }
    }

    public static String invalidComponents(Object[] ra, Class superType) {
        if (null == ra) {
            return "null input array";
        } else if (0 == ra.length) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        final String cname = LangUtil.unqualifiedClassName(superType);
        for (int i = 0; i < ra.length; i++) {
            if (null == ra[i]) {
                result.append(", [" + i + "] null");
            } else if ((null != superType) && !superType.isAssignableFrom(ra[i].getClass())) {
                result.append(", [" + i + "] not " + cname);
            }
        }
        if (0 == result.length()) {
            return null;
        } else {
            return result.toString().substring(2);
        }
    }

    public static boolean isEmpty(Object[] ra) {
        return ((null == ra) || (0 == ra.length));
    }

    public static boolean isEmpty(String s) {
        return ((null == s) || (0 == s.length()));
    }

    public static final void throwIaxIfComponentsBad(final Object[] input, final String name, final Class superType) {
        String errs = invalidComponents(input, superType);
        if (null != errs) {
            String err = name + " invalid entries: " + errs;
            throw new IllegalArgumentException(err);
        }
    }

    public static final void throwIaxIfFalse(final boolean test, final String message) {
        if (!test) {
            throw new IllegalArgumentException(message);
        }
    }

    public static final void throwIaxIfNull(final Object o, final String name) {
        if (null == o) {
            String message = "null " + (null == name ? "input" : name);
            throw new IllegalArgumentException(message);
        }
    }

    public static ArrayList unflatten(String input, FlattenSpec spec) {
        throwIaxIfNull(spec, "spec");
        final FlattenSpec s = spec;
        return unflatten(input, s.prefix, s.nullFlattened, s.escape, s.delim, s.suffix, s.emptyUnflattened);
    }

    public static ArrayList unflatten(String input, String prefix, String nullFlattened, String escape, String delim, String suffix, String emptyUnflattened) {
        throwIaxIfNull(input, "input");
        final boolean haveDelim = (!isEmpty(delim));
        if (!isEmpty(prefix)) {
            if (input.startsWith(prefix)) {
                input = input.substring(prefix.length());
            } else {
                String s = "expecting \"" + prefix + "\" at start of " + input + "\"";
                throw new IllegalArgumentException(s);
            }
        }
        if (!isEmpty(suffix)) {
            if (input.endsWith(suffix)) {
                input = input.substring(0, input.length() - suffix.length());
            } else {
                String s = "expecting \"" + suffix + "\" at end of " + input + "\"";
                throw new IllegalArgumentException(s);
            }
        }
        final ArrayList result = new ArrayList();
        if (isEmpty(input)) {
            return result;
        }
        if ((!haveDelim) || (-1 == input.indexOf(delim))) {
            result.add(input);
            return result;
        }
        StringTokenizer st = new StringTokenizer(input, delim, true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println("reading " + token);
            if (delim.equals(token)) {
            } else {
                result.add(token);
            }
        }
        return result;
    }

    public static String[] combine(String[] one, String[] two) {
        ArrayList twoList = new ArrayList();
        twoList.addAll(org.aspectj.util.LangUtil.arrayAsList(two));
        ArrayList result = new ArrayList();
        if (null != one) {
            for (int i = 0; i < one.length; i++) {
                if (null != one[i]) {
                    twoList.remove(one[i]);
                    result.add(one[i]);
                }
            }
        }
        for (Iterator iterator = twoList.iterator(); iterator.hasNext(); ) {
            String element = (String) iterator.next();
            if (null != element) {
                result.add(element);
            }
        }
        return (String[]) result.toArray(NONE);
    }

    public static Properties combine(Properties dest, Properties add, boolean respectExisting) {
        if (null == add)
            return dest;
        if (null == dest)
            return add;
        for (Iterator iterator = add.keySet().iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            if (null == key) {
                continue;
            }
            String value = add.getProperty(key);
            if (null == value) {
                continue;
            }
            if (!respectExisting || (null == dest.getProperty(key))) {
                dest.setProperty(key, value);
            }
        }
        return dest;
    }

    public static List arrayAsList(Object[] ra) {
        return org.aspectj.util.LangUtil.arrayAsList(ra);
    }

    public static String[] classesIn(File dir) {
        boolean alwaysTrue = true;
        FileFilter filter = ValidFileFilter.CLASS_FILE;
        CollectorFileFilter collector = new CollectorFileFilter(filter, alwaysTrue);
        FileUtil.descendFileTree(dir, collector);
        List list = collector.getFiles();
        String[] result = new String[list.size()];
        Iterator it = list.iterator();
        String dirPrefix = dir.getPath();
        for (int i = 0; i < result.length; i++) {
            if (!it.hasNext()) {
                throw new Error("unexpected end of list at " + i);
            }
            result[i] = fileToClassname((File) it.next(), dirPrefix);
        }
        return result;
    }

    public static String unsplit(String[] input, StringBuffer errs) {
        StringBuffer sb = new StringBuffer();
        sb.append(SPLIT_START);
        for (int i = 0; i < input.length; i++) {
            if (-1 != input[i].indexOf(SPLIT_DELIM)) {
                if (null != errs) {
                    errs.append("\nLangUtil.unsplit(..) - item " + i + ": \"" + input[i] + " contains \"" + SPLIT_DELIM + "\"");
                }
            } else {
                sb.append(input[i]);
                if (1 + i < input.length) {
                    sb.append(SPLIT_DELIM);
                }
            }
        }
        sb.append(SPLIT_END);
        return sb.toString();
    }

    public static String[] split(String s) {
        if (null == s) {
            return null;
        }
        if ((!s.startsWith(SPLIT_START)) || (!s.endsWith(SPLIT_END))) {
            return new String[] { s };
        }
        s = s.substring(SPLIT_START.length(), s.length() - SPLIT_END.length());
        final int LEN = s.length();
        int start = 0;
        final ArrayList result = new ArrayList();
        final String DELIM = ", ";
        int loc = s.indexOf(SPLIT_DELIM, start);
        while ((start < LEN) && (-1 != loc)) {
            result.add(s.substring(start, loc));
            start = DELIM.length() + loc;
            loc = s.indexOf(SPLIT_DELIM, start);
        }
        result.add(s.substring(start));
        return (String[]) result.toArray(new String[0]);
    }

    public static String[] strip(String[] src, String[] toStrip) {
        if (null == toStrip) {
            return strip(src, NONE);
        } else if (null == src) {
            return strip(NONE, toStrip);
        }
        List slist = org.aspectj.util.LangUtil.arrayAsList(src);
        List tlist = org.aspectj.util.LangUtil.arrayAsList(toStrip);
        slist.removeAll(tlist);
        return (String[]) slist.toArray(NONE);
    }

    public static void loadClasses(String[] args, StringBuffer out, StringBuffer err) {
        if (null != args) {
            for (int i = 0; i < args.length; i++) {
                try {
                    Class c = Class.forName(args[i]);
                    if (null != out) {
                        out.append("\n");
                        out.append(args[i]);
                        out.append(": ");
                        out.append(c.getName());
                    }
                } catch (Throwable t) {
                    if (null != err) {
                        err.append("\n");
                        FileUtil.render(t, err);
                    }
                }
            }
        }
    }

    private static String fileToClassname(File f, String prefix) {
        String path = f.getPath();
        if (!path.startsWith(prefix)) {
            String err = "!\"" + path + "\".startsWith(\"" + prefix + "\")";
            throw new IllegalArgumentException(err);
        }
        int length = path.length() - ".class".length();
        path = path.substring(prefix.length() + 1, length);
        for (int i = 0; i < SEPS.length; i++) {
            path = path.replace(SEPS[i], '.');
        }
        return path;
    }

    public static void main(String[] args) {
        StringBuffer err = new StringBuffer();
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            String[] names = classesIn(new File(args[i]));
            System.err.println(args[i] + " -> " + render(names));
            loadClasses(names, out, err);
        }
        if (0 < err.length()) {
            System.err.println(err.toString());
        }
        if (0 < out.length()) {
            System.out.println(out.toString());
        }
    }

    public static String render(String[] args) {
        if ((null == args) || (1 > args.length)) {
            return "[]";
        }
        boolean longFormat = (args.length < 10);
        String sep = (longFormat ? ", " : "\n\t");
        StringBuffer sb = new StringBuffer();
        if (!longFormat)
            sb.append("[");
        for (int i = 0; i < args.length; i++) {
            if (0 < i)
                sb.append(sep);
            sb.append(args[i]);
        }
        sb.append(longFormat ? "\n" : "]");
        return sb.toString();
    }

    public static String debugStr(Throwable thrown) {
        if (null == thrown) {
            return "((Throwable) null)";
        } else if (thrown instanceof InvocationTargetException) {
            return debugStr(((InvocationTargetException) thrown).getTargetException());
        } else if (thrown instanceof AbortException) {
            IMessage m = ((AbortException) thrown).getIMessage();
            if (null != m) {
                return "" + m;
            }
        }
        StringWriter buf = new StringWriter();
        PrintWriter writer = new PrintWriter(buf);
        writer.println(thrown.getMessage());
        thrown.printStackTrace(writer);
        try {
            buf.close();
        } catch (IOException ioe) {
        }
        return buf.toString();
    }

    public static String debugStr(Object o) {
        return debugStr(o, false);
    }

    public static String debugStr(Object o, boolean recurse) {
        if (null == o) {
            return "null";
        } else if (recurse) {
            ArrayList rendering = new ArrayList();
            rendering.add(o);
            return debugStr(o, rendering);
        } else {
            Class c = o.getClass();
            Field[] fields = c.getDeclaredFields();
            Object[] values = new Object[fields.length];
            String[] names = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                names[i] = field.getName();
                try {
                    values[i] = field.get(o);
                    if (field.getType().isArray()) {
                        List list = org.aspectj.util.LangUtil.arrayAsList((Object[]) values[i]);
                        values[i] = list.toString();
                    }
                } catch (IllegalAccessException e) {
                    values[i] = "<IllegalAccessException>";
                }
            }
            return debugStr(c, names, values);
        }
    }

    private static String debugStr(Object o, ArrayList rendering) {
        if (null == o) {
            return "null";
        } else if (!rendering.contains(o)) {
            throw new Error("o not in rendering");
        }
        Class c = o.getClass();
        if (c.isArray()) {
            Object[] ra = (Object[]) o;
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            for (int i = 0; i < ra.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                rendering.add(ra[i]);
                sb.append(debugStr(ra[i], rendering));
            }
            sb.append("]");
            return sb.toString();
        }
        Field[] fields = nonStaticFields(c.getFields());
        Object[] values = new Object[fields.length];
        String[] names = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            names[i] = field.getName();
            Object value = privilegedGetField(field, o);
            if (null == value) {
                values[i] = "null";
            } else if (rendering.contains(value)) {
                values[i] = "<recursion>";
            } else {
                rendering.add(value);
                values[i] = debugStr(value, rendering);
            }
        }
        return debugStr(c, names, values);
    }

    private static Object privilegedGetField(final Field field, final Object o) {
        try {
            return AccessController.doPrivileged(new PrivilegedExceptionAction() {

                public Object run() {
                    try {
                        return field.get(o);
                    } catch (IllegalAccessException e) {
                        return "<IllegalAccessException>";
                    }
                }
            });
        } catch (PrivilegedActionException e) {
            return "<IllegalAccessException>";
        }
    }

    private static Field[] nonStaticFields(Field[] fields) {
        if (null == fields) {
            return new Field[0];
        }
        int to = 0;
        int from = 0;
        while (from < fields.length) {
            if (!Modifier.isStatic(fields[from].getModifiers())) {
                if (to != from) {
                    fields[to] = fields[from];
                }
                to++;
            }
            from++;
        }
        if (to < from) {
            Field[] result = new Field[to];
            if (to > 0) {
                System.arraycopy(fields, 0, result, 0, to);
            }
            fields = result;
        }
        return fields;
    }

    public static String debugStr(Class source, String[] names, Object[] items) {
        return debugStr(source, null, names, null, items, null, null);
    }

    public static String debugStr(Class source, String prefix, String[] names, String infix, Object[] items, String delimiter, String suffix) {
        if (null == delimiter) {
            delimiter = SPLIT_DELIM;
        }
        if (null == prefix) {
            prefix = SPLIT_START;
        }
        if (null == infix) {
            infix = "=";
        }
        if (null == suffix) {
            suffix = SPLIT_END;
        }
        StringBuffer sb = new StringBuffer();
        if (null != source) {
            sb.append(org.aspectj.util.LangUtil.unqualifiedClassName(source));
        }
        sb.append(prefix);
        if (null == names) {
            names = NONE;
        }
        if (null == items) {
            items = NONE;
        }
        final int MAX = (names.length > items.length ? names.length : items.length);
        for (int i = 0; i < MAX; i++) {
            if (i > 0) {
                sb.append(delimiter);
            }
            if (i < names.length) {
                sb.append(names[i]);
            }
            if (i < items.length) {
                if (i < names.length) {
                    sb.append(infix);
                }
                sb.append(items[i] + "");
            }
        }
        sb.append(suffix);
        return sb.toString();
    }

    public static String unqualifiedClassName(Object o) {
        return unqualifiedClassName(null == o ? null : o.getClass());
    }

    public static String unqualifiedClassName(Class c) {
        if (null == c) {
            return "null";
        }
        String name = c.getName();
        int loc = name.lastIndexOf(".");
        if (-1 != loc)
            name = name.substring(1 + loc);
        return name;
    }

    public static void makeDiffs(List expectedListIn, List actualListIn, List missingListOut, List extraListOut) {
        if ((null == missingListOut) && (null == extraListOut)) {
            return;
        }
        if (null == expectedListIn) {
            expectedListIn = Collections.EMPTY_LIST;
        }
        if (null == actualListIn) {
            actualListIn = Collections.EMPTY_LIST;
        }
        if ((0 == actualListIn.size()) && (0 == expectedListIn.size())) {
            return;
        }
        BitSet actualExpected = new BitSet();
        for (int i = 0; i < expectedListIn.size(); i++) {
            Object expect = expectedListIn.get(i);
            int loc = actualListIn.indexOf(expect);
            if (-1 == loc) {
                if (null != missingListOut) {
                    missingListOut.add(expect);
                }
            } else {
                actualExpected.set(loc);
            }
        }
        if (null != extraListOut) {
            for (int i = 0; i < actualListIn.size(); i++) {
                if (!actualExpected.get(i)) {
                    extraListOut.add(actualListIn.get(i));
                }
            }
        }
    }

    public static void makeSoftDiffs(List expectedListIn, List actualListIn, List missingListOut, List extraListOut, Comparator comparator) {
        if ((null == missingListOut) && (null == extraListOut)) {
            return;
        }
        if (null == comparator) {
            throw new IllegalArgumentException("null comparator");
        }
        if (null == expectedListIn) {
            expectedListIn = Collections.EMPTY_LIST;
        }
        if (null == actualListIn) {
            actualListIn = Collections.EMPTY_LIST;
        }
        if ((0 == actualListIn.size()) && (0 == expectedListIn.size())) {
            return;
        }
        ArrayList expected = new ArrayList();
        expected.addAll(expectedListIn);
        Collections.sort(expected, comparator);
        ArrayList actual = new ArrayList();
        actual.addAll(actualListIn);
        Collections.sort(actual, comparator);
        Iterator actualIter = actual.iterator();
        Object act = null;
        if (missingListOut != null) {
            missingListOut.addAll(expectedListIn);
        }
        if (extraListOut != null) {
            extraListOut.addAll(actualListIn);
        }
        while (actualIter.hasNext()) {
            act = actualIter.next();
            for (Iterator expectedIter = expected.iterator(); expectedIter.hasNext(); ) {
                Object exp = expectedIter.next();
                int diff = comparator.compare(exp, act);
                if (diff == 0) {
                    extraListOut.remove(act);
                    missingListOut.remove(exp);
                } else if (diff > 0) {
                    break;
                }
            }
        }
    }

    public static class FlattenSpec {

        public static final String UNFLATTEN_EMPTY_ERROR = "empty items not permitted when unflattening";

        public static final String UNFLATTEN_EMPTY_AS_NULL = "unflatten empty items as null";

        public static final String SKIP_EMPTY_IN_UNFLATTEN = "skip empty items when unflattening";

        public static final FlattenSpec COMMA = new FlattenSpec(null, "", "\\", ",", null, "") {

            public String toString() {
                return "FlattenSpec.COMMA";
            }
        };

        public static final FlattenSpec LIST = new FlattenSpec("[", "", null, ", ", "]", UNFLATTEN_EMPTY_ERROR) {

            public String toString() {
                return "FlattenSpec.LIST";
            }
        };

        public static final String NULL = "<null>";

        private static String r(String s) {
            return (null == s ? NULL : s);
        }

        public final String prefix;

        public final String nullFlattened;

        public final String escape;

        public final String delim;

        public final String suffix;

        public final String emptyUnflattened;

        private transient String toString;

        public  FlattenSpec(String prefix, String nullRendering, String escape, String delim, String suffix, String emptyUnflattened) {
            this.prefix = prefix;
            this.nullFlattened = nullRendering;
            this.escape = escape;
            this.delim = delim;
            this.suffix = suffix;
            this.emptyUnflattened = emptyUnflattened;
            throwIaxIfNull(emptyUnflattened, "use UNFLATTEN_EMPTY_AS_NULL");
        }

        public String toString() {
            if (null == toString) {
                toString = "FlattenSpec(" + "prefix=" + r(prefix) + ", nullRendering=" + r(nullFlattened) + ", escape=" + r(escape) + ", delim=" + r(delim) + ", suffix=" + r(suffix) + ", emptyUnflattened=" + r(emptyUnflattened) + ")";
            }
            return toString;
        }
    }
}
