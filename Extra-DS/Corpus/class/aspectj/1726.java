package org.aspectj.apache.bcel.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.aspectj.apache.bcel.classfile.ClassParser;
import org.aspectj.apache.bcel.classfile.JavaClass;

/**
 * This repository is used in situations where a Class is created
 * outside the realm of a ClassLoader. Classes are loaded from
 * the file systems using the paths specified in the given
 * class path. By default, this is the value returned by
 * ClassPath.getClassPath().
 * <br>
 * It is designed to be used as a singleton, however it
 * can also be used with custom classpaths.
 *
/**
 * Abstract definition of a class repository. Instances may be used
 * to load classes from different sources and may be used in the
 * Repository.setRepository method.
 *
 * @see org.aspectj.apache.bcel.Repository
 *
 * @version $Id: SyntheticRepository.java,v 1.5 2004/11/22 08:31:27 aclement Exp $
 * @author <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @author David Dixon-Peugh
 */
public class SyntheticRepository implements Repository {

    private static final String DEFAULT_PATH = ClassPath.getClassPath();

    // CLASSPATH X REPOSITORY
    private static HashMap _instances = new HashMap();

    private ClassPath _path = null;

    // CLASSNAME X JAVACLASS
    private HashMap _loadedClasses = new HashMap();

    private  SyntheticRepository(ClassPath path) {
        _path = path;
    }

    public static SyntheticRepository getInstance() {
        return getInstance(ClassPath.getSystemClassPath());
    }

    public static SyntheticRepository getInstance(ClassPath classPath) {
        SyntheticRepository rep = (SyntheticRepository) _instances.get(classPath);
        if (rep == null) {
            rep = new SyntheticRepository(classPath);
            _instances.put(classPath, rep);
        }
        return rep;
    }

    /**
   * Store a new JavaClass instance into this Repository.
   */
    public void storeClass(JavaClass clazz) {
        _loadedClasses.put(clazz.getClassName(), clazz);
        clazz.setRepository(this);
    }

    /**
   * Remove class from repository
   */
    public void removeClass(JavaClass clazz) {
        _loadedClasses.remove(clazz.getClassName());
    }

    /**
   * Find an already defined (cached) JavaClass object by name.
   */
    public JavaClass findClass(String className) {
        return (JavaClass) _loadedClasses.get(className);
    }

    /**
   * Load a JavaClass object for the given class name using
   * the CLASSPATH environment variable.
   */
    public JavaClass loadClass(String className) throws ClassNotFoundException {
        if (className == null || className.equals("")) {
            throw new IllegalArgumentException("Invalid class name " + className);
        }
        // Just in case, canonical form
        className = className.replace('/', '.');
        try {
            return loadClass(_path.getInputStream(className), className);
        } catch (IOException e) {
            throw new ClassNotFoundException("Exception while looking for class " + className + ": " + e.toString());
        }
    }

    /**
   * Try to find class source via getResourceAsStream().
   * @see Class
   * @return JavaClass object for given runtime class
   */
    public JavaClass loadClass(Class clazz) throws ClassNotFoundException {
        String className = clazz.getName();
        String name = className;
        int i = name.lastIndexOf('.');
        if (i > 0) {
            name = name.substring(i + 1);
        }
        return loadClass(clazz.getResourceAsStream(name + ".class"), className);
    }

    private JavaClass loadClass(InputStream is, String className) throws ClassNotFoundException {
        JavaClass clazz = findClass(className);
        if (clazz != null) {
            return clazz;
        }
        try {
            if (is != null) {
                ClassParser parser = new ClassParser(is, className);
                clazz = parser.parse();
                storeClass(clazz);
                return clazz;
            }
        } catch (IOException e) {
            throw new ClassNotFoundException("Exception while looking for class " + className + ": " + e.toString());
        }
        throw new ClassNotFoundException("SyntheticRepository could not load " + className);
    }

    /** Clear all entries from cache.
   */
    public void clear() {
        _loadedClasses.clear();
    }
}
