import junit.framework.Test;
import junit.framework.TestSuite;

public class RunTheseBeforeYouCommitTests {

    public static Test suite() {
        String name = RunTheseBeforeYouCommitTests.class.getName();
        TestSuite suite = new TestSuite(name);
        // unit tests
        suite.addTest(AllTests.suite());
        // compiler tests
        suite.addTest(TestsModuleTests.suite());
        return suite;
    }
}
