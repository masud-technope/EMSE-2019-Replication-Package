import junit.framework.*;

public class AsmModuleTests extends TestCase {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite(AsmModuleTests.class.getName());
        suite.addTestSuite(AsmModuleTests.class);
        return suite;
    }

    public  AsmModuleTests(String name) {
        super(name);
    }

    public void testNothing() {
    }
}
