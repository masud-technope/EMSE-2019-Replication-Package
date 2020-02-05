package org.aspectj.apache.bcel.generic;

import java.util.ArrayList;
import org.aspectj.apache.bcel.Constants;
import org.aspectj.apache.bcel.classfile.AccessFlags;
import org.aspectj.apache.bcel.classfile.Attribute;
import org.aspectj.apache.bcel.generic.annotation.AnnotationGen;

/**
 * Super class for FieldGen and MethodGen objects, since they have
 * some methods in common!
 *
 * @version $Id: FieldGenOrMethodGen.java,v 1.3 2004/11/22 08:31:27 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class FieldGenOrMethodGen extends AccessFlags implements NamedAndTyped, Cloneable {

    protected String name;

    protected Type type;

    protected ConstantPoolGen cp;

    private ArrayList attribute_vec = new ArrayList();

    protected ArrayList annotation_vec = new ArrayList();

    protected  FieldGenOrMethodGen() {
    }

    public void setType(Type type) {
        if (type.getType() == Constants.T_ADDRESS)
            throw new IllegalArgumentException("Type can not be " + type);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    /** @return name of method/field.
   */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConstantPoolGen getConstantPool() {
        return cp;
    }

    public void setConstantPool(ConstantPoolGen cp) {
        this.cp = cp;
    }

    /**
   * Add an attribute to this method. Currently, the JVM knows about
   * the `Code', `ConstantValue', `Synthetic' and `Exceptions'
   * attributes. Other attributes will be ignored by the JVM but do no
   * harm.
   *
   * @param a attribute to be added
   */
    public void addAttribute(Attribute a) {
        attribute_vec.add(a);
    }

    public void addAnnotation(AnnotationGen ag) {
        annotation_vec.add(ag);
    }

    /**
   * Remove an attribute.
   */
    public void removeAttribute(Attribute a) {
        attribute_vec.remove(a);
    }

    public void removeAnnotation(AnnotationGen ag) {
        annotation_vec.remove(ag);
    }

    /**
   * Remove all attributes.
   */
    public void removeAttributes() {
        attribute_vec.clear();
    }

    public void removeAnnotations() {
        annotation_vec.clear();
    }

    /**
   * @return all attributes of this method.
   */
    public Attribute[] getAttributes() {
        Attribute[] attributes = new Attribute[attribute_vec.size()];
        attribute_vec.toArray(attributes);
        return attributes;
    }

    public AnnotationGen[] getAnnotations() {
        AnnotationGen[] annotations = new AnnotationGen[annotation_vec.size()];
        annotation_vec.toArray(annotations);
        return annotations;
    }

    /** @return signature of method/field.
   */
    public abstract String getSignature();

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println(e);
            return null;
        }
    }
}
