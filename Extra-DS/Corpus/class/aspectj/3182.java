import org.aspectj.testing.Tester;

class Super {

     Super(Object o) {
    }
}

/** windows treats filename "nul" specially, like /dev/null on unix */
public class NulIOException extends Super {

    public static void main(String[] args) {
        // parms: IOException
        Object o = new NulIOException(nul);
        Tester.check(false, "expecting compiler error");
        // reference: expect CE here, not IOException
        Object p = nul;
    }

     NulIOException() {
        super(nul);
    }

    // super parms: expect CE here, not IOException 
     NulIOException(Object o) {
        super(o);
    }
    // don't attempt to read nul on windows
}
