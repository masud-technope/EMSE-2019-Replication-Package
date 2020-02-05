/*
 * Copyright 2007 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.zxing;

/**
 * The general exception class throw when something goes wrong during decoding of a barcode.
 * This includes, but is not limited to, failing checksums / error correction algorithms, being
 * unable to locate finder timing patterns, and so on.
 *
 * @author Sean Owen
 */
public abstract class ReaderException extends Exception {

     ReaderException() {
    // do nothing
    }

    //public static ReaderException getInstance() {
    //    Exception e = new Exception();
    //    // Take the stack frame before this one.
    //    StackTraceElement stack = e.getStackTrace()[1];
    //    String key = stack.getClassName() + "." + stack.getMethodName() + "(), line " +
    //        stack.getLineNumber();
    //    if (throwers.containsKey(key)) {
    //      Integer value = throwers.get(key);
    //      value++;
    //      throwers.put(key, value);
    //    } else {
    //      throwers.put(key, 1);
    //    }
    //    exceptionCount++;
    //return instance;
    //}
    //  public static int getExceptionCountAndReset() {
    //    int temp = exceptionCount;
    //    exceptionCount = 0;
    //    return temp;
    //  }
    //
    //  public static String getThrowersAndReset() {
    //    StringBuilder builder = new StringBuilder(1024);
    //    Object[] keys = throwers.keySet().toArray();
    //    for (int x = 0; x < keys.length; x++) {
    //      String key = (String) keys[x];
    //      Integer value = throwers.get(key);
    //      builder.append(key);
    //      builder.append(": ");
    //      builder.append(value);
    //      builder.append("\n");
    //    }
    //    throwers.clear();
    //    return builder.toString();
    //  }
    // Prevent stack traces from being taken
    // srowen says: huh, my IDE is saying this is not an override. native methods can't be overridden?
    // This, at least, does not hurt. Because we use a singleton pattern here, it doesn't matter anyhow.
    public final Throwable fillInStackTrace() {
        return null;
    }
}
