import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.aspectj.systemtest.AllTests;
import org.aspectj.systemtest.AllTests14;
import org.aspectj.systemtest.AllTests15;
import org.aspectj.util.LangUtil;

public class TestsModuleTests extends TestCase {

    public static Test suite() {
        String name = TestsModuleTests.class.getName();
        TestSuite suite = new TestSuite(name);
        // compiler tests, wrapped for JUnit
        if (LangUtil.is15VMOrGreater()) {
            suite.addTest(AllTests15.suite());
        } else if (LangUtil.is14VMOrGreater()) {
            System.err.println("Skipping tests for 1.5");
            //suite.addTest(TestUtil.skipTest("for 1.5"));
            suite.addTest(AllTests14.suite());
        } else {
            System.err.println("Skipping tests for 1.4 and 1.5");
            //suite.addTest(TestUtil.skipTest("for 1.4 and 1.5"));
            suite.addTest(AllTests.suite());
        }
        return suite;
    }
}
