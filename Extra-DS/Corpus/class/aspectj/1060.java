import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.aspectj.testingutil.UtilTests;

public class TestingUtilModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(TestingUtilModuleTests.class.getName());
        suite.addTest(UtilTests.suite());
        return suite;
    }

    public  TestingUtilModuleTests(String name) {
        super(name);
    }
}
