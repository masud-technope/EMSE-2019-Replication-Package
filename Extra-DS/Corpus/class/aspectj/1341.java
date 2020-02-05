import org.aspectj.testing.Tester;
import org.aspectj.testing.Tester;

public class TestTesterFail {

    public static void main(String[] args) {
        Tester.event("1");
        Tester.event("event 1");
        new TestTesterFail().run();
        // does not include events
        Tester.checkAllEvents();
        // should fail if FNF
        Tester.checkEventsFromFile("TestTester.events");
    }

    static {
        Tester.expectEvent("1");
        // fail here - misentered below
        Tester.expectEvent("2");
        // fail here - expected but not found
        Tester.expectEvent("3");
    }

    public void run() {
        // 
        Tester.event("2 ");
        // fail here - space
        Tester.event("event2");
        // fail here - explicitly
        Tester.check(false, "failure");
        // fail here - space
        Tester.checkEqual("1", "1 ", "failure");
        // fail here
        Tester.checkEqual("", "1");
    }
}
