import junit.framework.Test;
import junit.framework.TestSuite;
import org.aspectj.tools.ajdoc.AjdocTests;

/**
 * @author Mik Kersten
 */
public class AjdocModuleTests {

    public static Test suite() {
        TestSuite suite = new TestSuite(AjdocModuleTests.class.getName());
        suite.addTest(AjdocTests.suite());
        return suite;
    }
}
