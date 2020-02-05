import org.aspectj.bridge.context.CompilationAndWeavingContextTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BridgeModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(BridgeModuleTests.class.getName());
        suite.addTest(org.aspectj.bridge.BridgeTests.suite());
        suite.addTestSuite(CompilationAndWeavingContextTest.class);
        return suite;
    }

    public  BridgeModuleTests(String name) {
        super(name);
    }
}
