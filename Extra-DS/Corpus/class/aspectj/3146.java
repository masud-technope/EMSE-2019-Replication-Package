import junit.framework.*;

public class AjbrowserModuleTests extends TestCase {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite(AjbrowserModuleTests.class.getName());
        suite.addTest(org.aspectj.tools.ajbrowser.AjbrowserTests.suite());
        return suite;
    }

    public  AjbrowserModuleTests(String name) {
        super(name);
    }
}
