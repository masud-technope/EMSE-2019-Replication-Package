import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LibModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(LibModuleTests.class.getName());
        suite.addTest(org.aspectj.lib.pointcuts.PointcutsTests.suite());
        suite.addTest(org.aspectj.lib.tracing.TracingTests.suite());
        return suite;
    }
}
