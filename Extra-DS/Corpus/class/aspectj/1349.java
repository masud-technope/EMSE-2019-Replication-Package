import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestingModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(TestingModuleTests.class.getName());
        suite.addTest(org.aspectj.testing.harness.bridge.TestingBridgeTests.suite());
        suite.addTest(org.aspectj.testing.taskdefs.TaskdefTests.suite());
        suite.addTest(org.aspectj.testing.util.UtilTests.suite());
        suite.addTest(org.aspectj.testing.util.options.OptionsTests.suite());
        suite.addTest(org.aspectj.testing.xml.TestingXmlTests.suite());
        return suite;
    }

    public  TestingModuleTests(String name) {
        super(name);
    }
}
