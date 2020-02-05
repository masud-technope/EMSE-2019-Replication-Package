import org.aspectj.testing.Tester;

/**
 * @testTarget compilerErrors.false.exceptions Throwable treated as checked, false compiler error
 */
public class FalseThrowsCE {

    public static void main(String[] args) {
        try {
            // potential NPE, SecurityException
            System.getProperty("").toString();
        } catch (Throwable // (false) CE: Throwable never thrown
        e) {
            String s = "got " + e;
        }
        Tester.check(true, "ok - compiled without error");
    }
}
