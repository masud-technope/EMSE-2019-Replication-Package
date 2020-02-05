import org.aspectj.weaver.loadtime.LoadtimeTests;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 */
public class Loadtime515ModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(Loadtime515ModuleTests.class.getName());
        suite.addTestSuite(LoadtimeTests.class);
        return suite;
    }
}
