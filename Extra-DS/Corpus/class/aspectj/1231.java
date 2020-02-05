import junit.framework.*;
import junit.framework.Test;
import org.aspectj.testing.TestingTests;

public class TestingClientModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(TestingClientModuleTests.class.getName());
        suite.addTest(TestingTests.suite());
        return suite;
    }

    public  TestingClientModuleTests(String name) {
        super(name);
    }
}
