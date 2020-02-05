import org.aspectj.testing.drivers.DriversTests;
import junit.framework.*;
import junit.framework.Test;

/**
 * TODO weaver dumping ajcore files when using this interface
 */
public class TestingDriversModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(TestingDriversModuleTests.class.getName());
        suite.addTest(DriversTests.suite());
        return suite;
    }

    public  TestingDriversModuleTests(String name) {
        super(name);
    }
}
