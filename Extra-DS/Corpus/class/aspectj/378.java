public class ExceptionBugTest {

    int x;

    class MyException extends Exception {
    }

    // warning here
    public void method1() throws Exception {
        x = 1;
    }

    // warning here
    public void method2() throws MyException {
        x = 2;
    }
}
