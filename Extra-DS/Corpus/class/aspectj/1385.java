// default package
import org.aspectj.testing.util.TestUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Aspectj5rtModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite("Aspectj5rt module tests");
        if (TestUtil.is15VMOrGreater()) {
            TestUtil.loadTestsReflectively(suite, "Aspectj5rt15ModuleTests", true);
        } else {
            suite.addTest(TestUtil.skipTest("for aspectj5rt that need 1.5"));
        }
        return suite;
    }
}
