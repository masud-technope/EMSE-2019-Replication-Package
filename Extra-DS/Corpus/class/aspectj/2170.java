package org.aspectj.apache.bcel.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.aspectj.apache.bcel.Constants;
import org.aspectj.apache.bcel.classfile.Attribute;
import org.aspectj.apache.bcel.classfile.Constant;
import org.aspectj.apache.bcel.classfile.ConstantObject;
import org.aspectj.apache.bcel.classfile.ConstantPool;
import org.aspectj.apache.bcel.classfile.ConstantValue;
import org.aspectj.apache.bcel.classfile.Field;
import org.aspectj.apache.bcel.classfile.Utility;
import org.aspectj.apache.bcel.classfile.annotation.Annotation;
import org.aspectj.apache.bcel.classfile.annotation.RuntimeAnnotations;
import org.aspectj.apache.bcel.generic.annotation.AnnotationGen;

/** 
 * Template class for building up a field.  The only extraordinary thing
 * one can do is to add a constant value attribute to a field (which must of
 * course be compatible with to the declared type).
 *
 * @version $Id: FieldGen.java,v 1.4 2005/03/10 12:15:04 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @see Field
 */
public class FieldGen extends FieldGenOrMethodGen {

    private Object value = null;

    /**
   * Declare a field. If it is static (isStatic() == true) and has a
   * basic type like int or String it may have an initial value
   * associated with it as defined by setInitValue().
   *
   * @param access_flags access qualifiers
   * @param type  field type
   * @param name field name
   * @param cp constant pool
   */
    public  FieldGen(int access_flags, Type type, String name, ConstantPoolGen cp) {
        setAccessFlags(access_flags);
        setType(type);
        setName(name);
        setConstantPool(cp);
    }

    /**
   * Instantiate from existing field.
   *
   * @param field Field object
   * @param cp constant pool (must contain the same entries as the field's constant pool)
   */
    public  FieldGen(Field field, ConstantPoolGen cp) {
        this(field.getAccessFlags(), Type.getType(field.getSignature()), field.getName(), cp);
        Attribute[] attrs = field.getAttributes();
        for (int i = 0; i < attrs.length; i++) {
            if (attrs[i] instanceof ConstantValue) {
                setValue(((ConstantValue) attrs[i]).getConstantValueIndex());
            } else if (attrs[i] instanceof RuntimeAnnotations) {
                RuntimeAnnotations runtimeAnnotations = (RuntimeAnnotations) attrs[i];
                List l = runtimeAnnotations.getAnnotations();
                for (Iterator it = l.iterator(); it.hasNext(); ) {
                    Annotation element = (Annotation) it.next();
                    addAnnotation(new AnnotationGen(element, cp, false));
                }
            } else {
                addAttribute(attrs[i]);
            }
        }
    }

    private void setValue(int index) {
        ConstantPool cp = this.cp.getConstantPool();
        Constant c = cp.getConstant(index);
        value = ((ConstantObject) c).getConstantValue(cp);
    }

    /**
   * Set (optional) initial value of field, otherwise it will be set to null/0/false
   * by the JVM automatically.
   */
    public void setInitValue(String str) {
        checkType(new ObjectType("java.lang.String"));
        if (str != null)
            value = str;
    }

    public void setInitValue(long l) {
        checkType(Type.LONG);
        if (l != 0L)
            value = new Long(l);
    }

    public void setInitValue(int i) {
        checkType(Type.INT);
        if (i != 0)
            value = new Integer(i);
    }

    public void setInitValue(short s) {
        checkType(Type.SHORT);
        if (s != 0)
            value = new Integer(s);
    }

    public void setInitValue(char c) {
        checkType(Type.CHAR);
        if (c != 0)
            value = new Integer(c);
    }

    public void setInitValue(byte b) {
        checkType(Type.BYTE);
        if (b != 0)
            value = new Integer(b);
    }

    public void setInitValue(boolean b) {
        checkType(Type.BOOLEAN);
        if (b)
            value = new Integer(1);
    }

    public void setInitValue(float f) {
        checkType(Type.FLOAT);
        if (f != 0.0)
            value = new Float(f);
    }

    public void setInitValue(double d) {
        checkType(Type.DOUBLE);
        if (d != 0.0)
            value = new Double(d);
    }

    /** Remove any initial value.
   */
    public void cancelInitValue() {
        value = null;
    }

    private void checkType(Type atype) {
        if (type == null)
            throw new ClassGenException("You haven't defined the type of the field yet");
        if (!isFinal())
            throw new ClassGenException("Only final fields may have an initial value!");
        if (!type.equals(atype))
            throw new ClassGenException("Types are not compatible: " + type + " vs. " + atype);
    }

    /**
   * Get field object after having set up all necessary values.
   */
    public Field getField() {
        String signature = getSignature();
        int name_index = cp.addUtf8(name);
        int signature_index = cp.addUtf8(signature);
        if (value != null) {
            checkType(type);
            int index = addConstant();
            addAttribute(new ConstantValue(cp.addUtf8("ConstantValue"), 2, index, cp.getConstantPool()));
        }
        addAnnotationsAsAttribute(cp);
        return new Field(access_flags, name_index, signature_index, getAttributes(), cp.getConstantPool());
    }

    private void addAnnotationsAsAttribute(ConstantPoolGen cp) {
        Attribute[] attrs = Utility.getAnnotationAttributes(cp, annotation_vec);
        if (attrs != null) {
            for (int i = 0; i < attrs.length; i++) {
                addAttribute(attrs[i]);
            }
        }
    }

    private int addConstant() {
        switch(type.getType()) {
            case Constants.T_INT:
            case Constants.T_CHAR:
            case Constants.T_BYTE:
            case Constants.T_BOOLEAN:
            case Constants.T_SHORT:
                return cp.addInteger(((Integer) value).intValue());
            case Constants.T_FLOAT:
                return cp.addFloat(((Float) value).floatValue());
            case Constants.T_DOUBLE:
                return cp.addDouble(((Double) value).doubleValue());
            case Constants.T_LONG:
                return cp.addLong(((Long) value).longValue());
            case Constants.T_REFERENCE:
                return cp.addString(((String) value));
            default:
                throw new RuntimeException("Oops: Unhandled : " + type.getType());
        }
    }

    public String getSignature() {
        return type.getSignature();
    }

    private ArrayList observers;

    /** Add observer for this object.
   */
    public void addObserver(FieldObserver o) {
        if (observers == null)
            observers = new ArrayList();
        observers.add(o);
    }

    /** Remove observer for this object.
   */
    public void removeObserver(FieldObserver o) {
        if (observers != null)
            observers.remove(o);
    }

    /** Call notify() method on all observers. This method is not called
   * automatically whenever the state has changed, but has to be
   * called by the user after he has finished editing the object.
   */
    public void update() {
        if (observers != null)
            for (Iterator e = observers.iterator(); e.hasNext(); ) ((FieldObserver) e.next()).notify(this);
    }

    public String getInitValue() {
        if (value != null) {
            return value.toString();
        } else
            return null;
    }

    /**
   * Return string representation close to declaration format,
   * `public static final short MAX = 100', e.g..
   *
   * @return String representation of field
   */
    public final String toString() {
        // Short cuts to constant pool
        String name, signature, access;
        access = Utility.accessToString(access_flags);
        access = access.equals("") ? "" : (access + " ");
        signature = type.toString();
        name = getName();
        StringBuffer buf = new StringBuffer(access + signature + " " + name);
        String value = getInitValue();
        if (value != null)
            buf.append(" = " + value);
        return buf.toString();
    }

    /** @return deep copy of this field
   */
    public FieldGen copy(ConstantPoolGen cp) {
        FieldGen fg = (FieldGen) clone();
        fg.setConstantPool(cp);
        return fg;
    }
}
