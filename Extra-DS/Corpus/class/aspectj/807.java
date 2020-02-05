package org.aspectj.apache.bcel.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;
import org.aspectj.apache.bcel.classfile.ClassParser;
import org.aspectj.apache.bcel.classfile.JavaClass;

/**
 * The repository maintains information about which classes have
 * been loaded.
 *
 * It loads its data from the ClassLoader implementation
 * passed into its constructor.
 *
 * @see org.aspectj.apache.bcel.Repository
 *
 * @version $Id: ClassLoaderRepository.java,v 1.5 2006/03/10 13:29:05 aclement Exp $
 * @author <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @author David Dixon-Peugh
 */
public class ClassLoaderRepository implements Repository {

    private java.lang.ClassLoader loader;

    private WeakHashMap loadedClasses = // CLASSNAME X JAVACLASS
    new WeakHashMap();

    public  ClassLoaderRepository(java.lang.ClassLoader loader) {
        this.loader = loader;
    }

    /**
   * Store a new JavaClass into this Repository.
   */
    public void storeClass(JavaClass clazz) {
        loadedClasses.put(clazz.getClassName(), clazz);
        clazz.setRepository(this);
    }

    /**
   * Remove class from repository
   */
    public void removeClass(JavaClass clazz) {
        loadedClasses.remove(clazz.getClassName());
    }

    /**
   * Find an already defined JavaClass.
   */
    public JavaClass findClass(String className) {
        if (loadedClasses.containsKey(className)) {
            return (JavaClass) loadedClasses.get(className);
        } else {
            return null;
        }
    }

    /**
   * Lookup a JavaClass object from the Class Name provided.
   */
    public JavaClass loadClass(String className) throws ClassNotFoundException {
        String classFile = className.replace('.', '/');
        JavaClass RC = findClass(className);
        if (RC != null) {
            return RC;
        }
        try {
            InputStream is = loader.getResourceAsStream(classFile + ".class");
            if (is == null) {
                throw new ClassNotFoundException(className + " not found.");
            }
            ClassParser parser = new ClassParser(is, className);
            RC = parser.parse();
            storeClass(RC);
            return RC;
        } catch (IOException e) {
            throw new ClassNotFoundException(e.toString());
        }
    }

    public JavaClass loadClass(Class clazz) throws ClassNotFoundException {
        return loadClass(clazz.getName());
    }

    /** Clear all entries from cache.
   */
    public void clear() {
        loadedClasses.clear();
    }
}
