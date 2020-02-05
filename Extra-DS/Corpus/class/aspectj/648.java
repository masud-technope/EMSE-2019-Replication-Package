import junit.framework.*;

public class AjdeModuleTests extends TestCase {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite(AjdeModuleTests.class.getName());
        suite.addTest(org.aspectj.ajde.AjdeTests.suite());
        suite.addTest(org.aspectj.ajde.internal.AjdeInternalTests.suite());
        suite.addTest(org.aspectj.ajde.ui.AjdeUiTests.suite());
        return suite;
    }

    public  AjdeModuleTests(String name) {
        super(name);
    }
}
