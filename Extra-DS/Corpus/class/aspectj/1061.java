import junit.framework.*;

public class AjdocModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(AjdocModuleTests.class.getName());
        suite.addTest(org.aspectj.tools.ajdoc.AjdocTests.suite());
        return suite;
    }

    public  AjdocModuleTests(String name) {
        super(name);
    }
}
