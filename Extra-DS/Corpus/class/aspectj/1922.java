package org.aspectj.apache.bcel.verifier.statics;

import org.aspectj.apache.bcel.classfile.Code;
import org.aspectj.apache.bcel.classfile.CodeException;
import org.aspectj.apache.bcel.classfile.ConstantClass;
import org.aspectj.apache.bcel.classfile.ConstantDouble;
import org.aspectj.apache.bcel.classfile.ConstantFieldref;
import org.aspectj.apache.bcel.classfile.ConstantFloat;
import org.aspectj.apache.bcel.classfile.ConstantInteger;
import org.aspectj.apache.bcel.classfile.ConstantInterfaceMethodref;
import org.aspectj.apache.bcel.classfile.ConstantLong;
import org.aspectj.apache.bcel.classfile.ConstantMethodref;
import org.aspectj.apache.bcel.classfile.ConstantNameAndType;
import org.aspectj.apache.bcel.classfile.ConstantPool;
import org.aspectj.apache.bcel.classfile.ConstantString;
import org.aspectj.apache.bcel.classfile.ConstantUtf8;
import org.aspectj.apache.bcel.classfile.ConstantValue;
import org.aspectj.apache.bcel.classfile.Deprecated;
import org.aspectj.apache.bcel.classfile.ExceptionTable;
import org.aspectj.apache.bcel.classfile.Field;
import org.aspectj.apache.bcel.classfile.InnerClass;
import org.aspectj.apache.bcel.classfile.InnerClasses;
import org.aspectj.apache.bcel.classfile.JavaClass;
import org.aspectj.apache.bcel.classfile.LineNumber;
import org.aspectj.apache.bcel.classfile.LineNumberTable;
import org.aspectj.apache.bcel.classfile.LocalVariable;
import org.aspectj.apache.bcel.classfile.LocalVariableTable;
import org.aspectj.apache.bcel.classfile.Method;
import org.aspectj.apache.bcel.classfile.Node;
import org.aspectj.apache.bcel.classfile.Signature;
import org.aspectj.apache.bcel.classfile.SourceFile;
import org.aspectj.apache.bcel.classfile.StackMap;
import org.aspectj.apache.bcel.classfile.Synthetic;
import org.aspectj.apache.bcel.classfile.Unknown;
import org.aspectj.apache.bcel.classfile.Visitor;
import org.aspectj.apache.bcel.verifier.exc.AssertionViolatedException;

/**
 * BCEL's Node classes (those from the classfile API that <B>accept()</B> Visitor
 * instances) have <B>toString()</B> methods that were not designed to be robust,
 * this gap is closed by this class.
 * When performing class file verification, it may be useful to output which
 * entity (e.g. a <B>Code</B> instance) is not satisfying the verifier's
 * constraints, but in this case it could be possible for the <B>toString()</B>
 * method to throw a RuntimeException.
 * A (new StringRepresentation(Node n)).toString() never throws any exception.
 * Note that this class also serves as a placeholder for more sophisticated message
 * handling in future versions of JustIce.
 * 
 * @version $Id: StringRepresentation.java,v 1.3 2004/11/22 08:31:27 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 */
public class StringRepresentation extends org.aspectj.apache.bcel.classfile.EmptyVisitor implements Visitor {

    /** The string representation, created by a visitXXX() method, output by toString(). */
    private String tostring;

    /** The node we ask for its string representation. Not really needed; only for debug output. */
    private Node n;

    /**
	 * Creates a new StringRepresentation object which is the representation of n.
	 *
	 * @see #toString()
	 */
    public  StringRepresentation(Node n) {
        this.n = n;
        // assign a string representation to field 'tostring' if we know n's class.
        n.accept(this);
    }

    /**
	 * Returns the String representation.
	 */
    public String toString() {
        // want to know that this class has also to be adapted.
        if (tostring == null)
            throw new AssertionViolatedException("Please adapt '" + getClass() + "' to deal with objects of class '" + n.getClass() + "'.");
        return tostring;
    }

    /**
	 * Returns the String representation of the Node object obj;
	 * this is obj.toString() if it does not throw any RuntimeException,
	 * or else it is a string derived only from obj's class name.
	 */
    private String toString(Node obj) {
        String ret;
        try {
            ret = obj.toString();
        } catch (RuntimeException e) {
            String s = obj.getClass().getName();
            s = s.substring(s.lastIndexOf(".") + 1);
            ret = "<<" + s + ">>";
        } catch (ClassFormatError e) {
            String s = obj.getClass().getName();
            s = s.substring(s.lastIndexOf(".") + 1);
            ret = "<<" + s + ">>";
        }
        return ret;
    }

    ////////////////////////////////
    // Visitor methods start here //
    ////////////////////////////////
    // We don't of course need to call some default implementation:
    // e.g. we could also simply output "Code" instead of a possibly
    // lengthy Code attribute's toString().
    public void visitCode(Code obj) {
        //tostring = toString(obj);
        // We don't need real code outputs.
        tostring = "<CODE>";
    }

    public void visitCodeException(CodeException obj) {
        tostring = toString(obj);
    }

    public void visitConstantClass(ConstantClass obj) {
        tostring = toString(obj);
    }

    public void visitConstantDouble(ConstantDouble obj) {
        tostring = toString(obj);
    }

    public void visitConstantFieldref(ConstantFieldref obj) {
        tostring = toString(obj);
    }

    public void visitConstantFloat(ConstantFloat obj) {
        tostring = toString(obj);
    }

    public void visitConstantInteger(ConstantInteger obj) {
        tostring = toString(obj);
    }

    public void visitConstantInterfaceMethodref(ConstantInterfaceMethodref obj) {
        tostring = toString(obj);
    }

    public void visitConstantLong(ConstantLong obj) {
        tostring = toString(obj);
    }

    public void visitConstantMethodref(ConstantMethodref obj) {
        tostring = toString(obj);
    }

    public void visitConstantNameAndType(ConstantNameAndType obj) {
        tostring = toString(obj);
    }

    public void visitConstantPool(ConstantPool obj) {
        tostring = toString(obj);
    }

    public void visitConstantString(ConstantString obj) {
        tostring = toString(obj);
    }

    public void visitConstantUtf8(ConstantUtf8 obj) {
        tostring = toString(obj);
    }

    public void visitConstantValue(ConstantValue obj) {
        tostring = toString(obj);
    }

    public void visitDeprecated(Deprecated obj) {
        tostring = toString(obj);
    }

    public void visitExceptionTable(ExceptionTable obj) {
        tostring = toString(obj);
    }

    public void visitField(Field obj) {
        tostring = toString(obj);
    }

    public void visitInnerClass(InnerClass obj) {
        tostring = toString(obj);
    }

    public void visitInnerClasses(InnerClasses obj) {
        tostring = toString(obj);
    }

    public void visitJavaClass(JavaClass obj) {
        tostring = toString(obj);
    }

    public void visitLineNumber(LineNumber obj) {
        tostring = toString(obj);
    }

    public void visitLineNumberTable(LineNumberTable obj) {
        tostring = "<LineNumberTable: " + toString(obj) + ">";
    }

    public void visitLocalVariable(LocalVariable obj) {
        tostring = toString(obj);
    }

    public void visitLocalVariableTable(LocalVariableTable obj) {
        tostring = "<LocalVariableTable: " + toString(obj) + ">";
    }

    public void visitMethod(Method obj) {
        tostring = toString(obj);
    }

    public void visitSignature(Signature obj) {
        tostring = toString(obj);
    }

    public void visitSourceFile(SourceFile obj) {
        tostring = toString(obj);
    }

    public void visitStackMap(StackMap obj) {
        tostring = toString(obj);
    }

    public void visitSynthetic(Synthetic obj) {
        tostring = toString(obj);
    }

    public void visitUnknown(Unknown obj) {
        tostring = toString(obj);
    }
}
