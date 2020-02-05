import org.aspectj.testing.Tester;
import org.aspectj.testing.Tester;
// deprecated class
import java.rmi.RMISecurityException;

/** @testcase PR#602 PUREJAVA no deprecation warnings (regardless of -deprecation flag) */
public class DeprecationWarning {

    public static void main(String[] args) {
        boolean result = false;
        try {
            // CW 11 deprecated class
            if (!result)
                throw new RMISecurityException("ok");
        } catch (RMISecurityException e) {
            result = true;
        }
        Tester.check(result, "no RMISecurityException");
    }
}
