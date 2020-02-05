import org.aspectj.testing.Tester;

public class CommentAfterClass {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Tester.check(true, "it better be true");
    }
}
//extra comment
