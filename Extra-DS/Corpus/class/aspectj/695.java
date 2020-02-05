import org.aspectj.testing.Tester;

public class AssertsCF2 {

    public static void main(String[] args) {
        String s;
        //ERR: s might not be assigned
        assert true : s;
    }
}
