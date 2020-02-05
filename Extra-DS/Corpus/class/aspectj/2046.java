import junit.framework.*;
import junit.framework.Test;

public class EajcModuleTests extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite(EajcModuleTests.class.getName());
        suite.addTest(org.aspectj.ajdt.ajc.AjdtAjcTests.suite());
        suite.addTest(org.aspectj.ajdt.internal.compiler.batch.AjdtBatchTests.suite());
        suite.addTest(org.aspectj.ajdt.internal.core.builder.AjdtBuilderTests.suite());
        suite.addTest(org.aspectj.tools.ajc.AjcTests.suite());
        return suite;
    }

    public  EajcModuleTests(String name) {
        super(name);
    }
}
