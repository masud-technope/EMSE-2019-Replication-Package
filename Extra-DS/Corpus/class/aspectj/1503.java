import org.aspectj.testing.Tester;

public class TestTesterFile {

    public static void main(String[] args) {
        // in TestTester.events
        Tester.event("event 1");
        new TestTesterFile().run();
        Tester.checkEventsFromFile("TestTester.events");
    }

    public void run() {
        // in TestTester.events
        Tester.event("event 2");
    }
}
