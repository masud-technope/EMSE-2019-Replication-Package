import org.aspectj.testing.Tester;
import org.aspectj.testing.Tester;

/** @testcase from biojava: org/biojava/bio/dp/SimpleMarkovModel.java:384 */
public class ConstructorFlow {

    // remove final and compile succeeds
    final Runnable runner;

    Runnable nonfinal;

    String one;

    /** @testcase PUREJAVA flow analysis where final variable set in another constructor */
    public  ConstructorFlow(String one, String two) {
        this(one);
        // incorrect CE: Field runner might not have a value
        runner.run();
        // expecting NPE
        nonfinal.run();
    }

    public  ConstructorFlow(String one) {
        this.one = one;
        runner = new Runnable() {

            public void run() {
                Tester.event("runner.run()");
            }
        };
    }

    public static void main(String[] args) {
        Tester.expectEvent("NullPointerException");
        Tester.expectEvent("runner.run()");
        try {
            new ConstructorFlow("one", "two");
            Tester.check(false, "expected NPE");
        } catch (NullPointerException npe) {
            Tester.event("NullPointerException");
        }
        Tester.checkAllEvents();
    }
}
