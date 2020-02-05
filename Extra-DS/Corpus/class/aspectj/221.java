import org.aspectj.testing.Tester;

public class StackChecker {

    static int baseStackDepth = 0;

    public static void setBaseDepth() {
        // XXX 1.4 only
        int depth = new Throwable().getStackTrace().length - 2;
        baseStackDepth = depth;
    }

    public static void checkDepth(int expectedDepth, String message) {
        int depth = new Throwable().getStackTrace().length - 1 - baseStackDepth;
        Tester.checkEqual(depth, expectedDepth, message);
    }
}
