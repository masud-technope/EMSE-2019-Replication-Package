package app;

public class MainExecStartLines {

    public static // 6
    void main(// 6
    String[] args) {
        // 7
        // 12
        String t = "....".substring(0);
    }

    void go(String s) {
        try {
            String t = "....".substring(0);
        } catch (RuntimeException // 17
        e) {
            String t = "....".substring(0);
        }
    }
}
/*
 * known limitation: 
 * For static shadow of [method|handler] execution join points 
 * in binary form, only can detect first line of code.
 */
