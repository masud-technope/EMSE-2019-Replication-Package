import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import org.aspectj.weaver.loadtime.WeavingURLClassLoaderTest;
import org.aspectj.weaver.loadtime.test.DocumentParserTest;

/**
 * @author <a href="mailto:alex AT gnilux DOT com">Alexandre Vasseur</a>
 */
public class LoadtimeModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(LoadtimeModuleTests.class.getName());
        suite.addTestSuite(DocumentParserTest.class);
        suite.addTestSuite(WeavingURLClassLoaderTest.class);
        return suite;
    }

    public static void main(String args[]) throws Throwable {
        TestRunner.run(suite());
    }
}
