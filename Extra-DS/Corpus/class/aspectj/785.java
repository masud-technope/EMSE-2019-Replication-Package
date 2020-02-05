import org.aspectj.testing.Tester;

/** @testcase fail when note not found */
public class TesterNotesFail {

    public static void main(String[] args) {
        Tester.note("note ");
        // fail
        Tester.check("note");
    }
}
