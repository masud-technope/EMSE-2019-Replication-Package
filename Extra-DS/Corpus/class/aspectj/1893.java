package org.aspectj.apache.bcel.generic;

/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Apache" and "Apache Software Foundation" and
 *    "Apache BCEL" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    "Apache BCEL", nor may "Apache" appear in their name, without
 *    prior written permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
import java.io.*;
import org.aspectj.apache.bcel.util.ByteSequence;

/**
 * IINC - Increment local variable by constant
 *
 * @version $Id: IINC.java,v 1.3 2005/08/12 15:58:50 acolyer Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class IINC extends LocalVariableInstruction {

    private boolean wide;

    private int c;

    /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   */
     IINC() {
    }

    /**
   * @param n index of local variable
   * @param c increment factor
   */
    public  IINC(int n, int c) {
        // Default behaviour of LocalVariableInstruction causes error
        super();
        this.opcode = org.aspectj.apache.bcel.Constants.IINC;
        this.length = (short) 3;
        // May set wide as side effect
        setIndex(n);
        setIncrement(c);
    }

    /**
   * Dump instruction as byte code to stream out.
   * @param out Output stream
   */
    public void dump(DataOutputStream out) throws IOException {
        if (// Need WIDE prefix ?
        wide)
            out.writeByte(org.aspectj.apache.bcel.Constants.WIDE);
        out.writeByte(opcode);
        if (wide) {
            out.writeShort(n);
            out.writeShort(c);
        } else {
            out.writeByte(n);
            out.writeByte(c);
        }
    }

    private final void setWide() {
        if (wide = ((n > org.aspectj.apache.bcel.Constants.MAX_BYTE) || (Math.abs(c) > Byte.MAX_VALUE)))
            // wide byte included  
            length = 6;
        else
            length = 3;
    }

    /**
   * Read needed data (e.g. index) from file.
   */
    protected void initFromFile(ByteSequence bytes, boolean wide) throws IOException {
        this.wide = wide;
        if (wide) {
            length = 6;
            n = bytes.readUnsignedShort();
            c = bytes.readShort();
        } else {
            length = 3;
            n = bytes.readUnsignedByte();
            c = bytes.readByte();
        }
    }

    /**
   * @return mnemonic for instruction
   */
    public String toString(boolean verbose) {
        return super.toString(verbose) + " " + c;
    }

    /**
   * Set index of local variable.
   */
    public final void setIndex(int n) {
        if (n < 0)
            throw new ClassGenException("Negative index value: " + n);
        this.n = n;
        setWide();
    }

    /**
   * @return increment factor
   */
    public final int getIncrement() {
        return c;
    }

    /**
   * Set increment factor.
   */
    public final void setIncrement(int c) {
        this.c = c;
        setWide();
    }

    /** @return int type
   */
    public Type getType(ConstantPoolGen cp) {
        return Type.INT;
    }

    /**
   * Call corresponding visitor method(s). The order is:
   * Call visitor methods of implemented interfaces first, then
   * call methods according to the class hierarchy in descending order,
   * i.e., the most specific visitXXX() call comes last.
   *
   * @param v Visitor object
   */
    public void accept(Visitor v) {
        v.visitLocalVariableInstruction(this);
        v.visitIINC(this);
    }
}
