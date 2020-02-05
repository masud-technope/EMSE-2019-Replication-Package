import junit.framework.Test;
import junit.framework.TestCase;

/**
 * Alias to maintain convention for invoking JUnit from Ant
 * by discovery of module root tests that name is *ModuleTests.
 */
public class AllModuleTests extends TestCase {

    public static Test suite() {
        // does not include compiler tests, i.e., tests/../TestsModuleTests
        return AllTests.suite();
    }
}
