import junit.framework.*;

public class TaskdefsModuleTests extends TestCase {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite(TaskdefsModuleTests.class.getName());
        suite.addTest(org.aspectj.tools.ant.taskdefs.TaskdefsTests.suite());
        return suite;
    }

    public  TaskdefsModuleTests(String name) {
        super(name);
    }
}
