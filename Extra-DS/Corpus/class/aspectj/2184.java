import org.aspectj.testing.Tester;

/** windows treats filename "nul" specially, like /dev/null on unix */
public class NulIOException3 {

    public static void main(String[] args) {
    }
}

class TodoClassFormatError {

    // no ref to this in NulIOException3 - VM fails to load nul
    public static void main(String[] args) {
        // @testcase nul as class literal
        Class c = nul.class;
        // @testcase nul as constructor/class name
        Object q = new nul();
        Class C = subnul.class;
        Object r = new subnul();
        Tester.check(null != c, "null nul class");
        Tester.check(null != q, "null nul object");
        Tester.check(null != C, "null subnul class");
        Tester.check(null != r, "null subnul object");
    }
}

// @testcase nul as class name
class nul {
}

// @testcase nul as reference to class name
class subnul extends nul {
}
