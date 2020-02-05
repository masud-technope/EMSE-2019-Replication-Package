import org.aspectj.testing.Tester;

class Super {

     Super(Object o) {
    }
}

/** windows treats filename "nul" specially, like /dev/null on unix */
public class NulIOException2 extends Super {

    public static void main(String[] args) {
        // @testcase nul as identifier
        Object nul = new Object();
        Object p = new NulIOException2(nul);
        Tester.check(null != nul, "null nul");
        Tester.check(null != p, "null NulIOException2");
    }

     NulIOException2(Object o) {
        super(o);
    }
}
