package org.aspectj.apache.bcel.classfile;

/**
 * Unknown (non-standard) attributes may be read via user-defined factory
 * objects that can be registered with the Attribute.addAttributeReader
 * method. These factory objects should implement this interface.

 * @see Attribute
 * @version $Id: AttributeReader.java,v 1.2 2004/11/19 16:45:18 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface AttributeReader {

    /**
     When this attribute reader is added via the static method
     Attribute.addAttributeReader, an attribute name is associated with it.
     As the class file parser parses attributes, it will call various
     AttributeReaders based on the name of the attributes it is
     constructing.

     @param name_index An index into the constant pool, indexing a
     ConstantUtf8 that represents the name of the attribute.

     @param length The length of the data contained in the attribute.  This
     is written into the constant pool and should agree with what the
     factory expects the length to be.

     @param file This is the data input stream that the factory needs to read
     its data from.

     @param constant_pool This is the constant pool associated with the
     Attribute that we are constructing.

     @return The user-defined AttributeReader should take this data and use
     it to construct an attribute.  In the case of errors, a null can be
     returned which will cause the parsing of the class file to fail.

     @see Attribute#addAttributeReader( String, AttributeReader )
  */
    public Attribute createAttribute(int name_index, int length, java.io.DataInputStream file, ConstantPool constant_pool);
}
