import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.aspectj.weaver.LocaleTest;
import org.aspectj.weaver.tools.ToolsTests;

public class BcweaverModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(BcweaverModuleTests.class.getName());
        suite.addTest(org.aspectj.weaver.bcel.BcelTests.suite());
        suite.addTest(org.aspectj.weaver.BcweaverTests.suite());
        suite.addTest(org.aspectj.weaver.patterns.PatternsTests.suite());
        suite.addTestSuite(LocaleTest.class);
        suite.addTest(ToolsTests.suite());
        return suite;
    }

    public  BcweaverModuleTests(String name) {
        super(name);
    }
}
