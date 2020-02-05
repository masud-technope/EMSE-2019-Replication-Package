import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.aspectj.testing.util.TestUtil;
import org.aspectj.weaver.tools.PointcutExpressionTest;

/**
 */
public class Weaver5ModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(Weaver5ModuleTests.class.getName());
        if (TestUtil.is15VMOrGreater()) {
            TestUtil.loadTestsReflectively(suite, "org.aspectj.weaver.tools.Java15PointcutExpressionTest", false);
            suite.addTestSuite(PointcutExpressionTest.class);
        } else {
            suite.addTest(TestUtil.testNamed("all tests require 1.5"));
        }
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.main(new String[] { Weaver5ModuleTests.class.getName() });
    }
}
