package org.aspectj.apache.bcel.generic;

/**
 * Denote entity that has both name and type. This is true for local variables,
 * methods and fields.
 *
 * @version $Id: NamedAndTyped.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface NamedAndTyped {

    public String getName();

    public Type getType();

    public void setName(String name);

    public void setType(Type type);
}
