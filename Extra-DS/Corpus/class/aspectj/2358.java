import org.aspectj.testing.Tester;
import org.aspectj.testing.Tester;

public class FullNames {

    public static void main(String[] args) {
        new FullNames().realMain(args);
    }

    public void realMain(String[] args) {
        a();
        b();
        c();
        Tester.checkAllEvents();
    }

    static {
        Tester.expectEvent("a");
        Tester.expectEvent("b");
        // XXX changed w/o understanding
        Tester.expectEvent(String.class.toString());
    }

    private void a() {
        String java = new String("a");
        Tester.event(java);
    }

    public void b() {
        String java = String.copyValueOf(new char[] { 'b' });
        Tester.event(java);
    }

    public void c() {
        Class java = String.class;
        // XXX changed w/o understanding
        Tester.event(java.toString());
    }
}
