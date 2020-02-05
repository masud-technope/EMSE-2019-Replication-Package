public class ErrorTest {

    static Integer i() {
        return Integer.valueOf("0");
    }

    // CE 5 always
    int i = i();

    // CE 6 always
    int j = i();
}
