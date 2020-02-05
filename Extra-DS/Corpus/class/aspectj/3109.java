import org.aspectj.testing.Tester;

public class AssertsCF {

    public static void main(String[] args) {
        int x = 0;
        boolean b;
        // ERR: b might not be assigned
        assert b;
        assert b = false;
        // ERR: b might not be assigned
        if (b) {
        }
    }
}
