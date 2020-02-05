import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.aspectj.internal.lang.reflect.AjTypeTests;
import org.aspectj.internal.lang.reflect.AjTypeTestsWithAspects;
import org.aspectj.internal.lang.reflect.InterTypeTests;

public class Aspectj5rt15ModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite("Aspectj5rt module tests");
        suite.addTestSuite(AjTypeTests.class);
        suite.addTestSuite(AjTypeTestsWithAspects.class);
        suite.addTestSuite(InterTypeTests.class);
        return suite;
    }
}
