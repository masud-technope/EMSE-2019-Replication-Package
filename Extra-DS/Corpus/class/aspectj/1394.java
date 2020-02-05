package app;

// WARNING: do not change lineation without changing test specification!!
public class Main {

    static String staticString = "hello";

    // bug 8 initializer picked out as execution
    String s = "me";

    public static void main(String[] args) {
        // 12
        String temp = staticString;
        // 14
        staticString = temp + " world!";
        // 16
        Main main = new Main();
        for (int i = 0; i < args.length; i++) {
            // 19
            main.go(args[i]);
        }
    }

     Main() {
        // 23
        s += "pick me, not initializer";
    }

    void go(String s) {
        // 26
        String t = "..".substring(0);
        try {
            // 29
            String temp = this.s;
            // 31
            this.s = temp + ", " + s;
            // 32 
            D.go();
        } catch (RuntimeException // 33
        e) {
            String u = "..".substring(0);
            stop();
        }
    }

    void stop() {
        // 40
        // 42
        D.go();
    }
}

class C {

     C() {
    // 50
    }
}

class D {

    static void go() {
    }
}
