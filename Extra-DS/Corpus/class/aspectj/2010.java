/** error falls to javac to detect - confirm detected in ajc */
public class NoReturnStatementSimple {

    // compile error here detected by javac
    static String noReturn() {
    }

    public static void main(String[] args) {
    }
}
