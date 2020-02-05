import junit.framework.*;
import junit.framework.Test;

public class UtilModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(UtilModuleTests.class.getName());
        suite.addTest(org.aspectj.util.UtilTests.suite());
        return suite;
    }

    public  UtilModuleTests(String name) {
        super(name);
    }
}
