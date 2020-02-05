public class UnderIfFalse {

    static int foo() {
        return 0;
    }

    static final int val = foo();

    public static void main(String[] args) {
        if (false) {
            val = 1;
        }
    }
}
