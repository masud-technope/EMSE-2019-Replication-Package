package app;

public class Main {

    public static void main(String[] args) {
        // bug: unable to resolve lib.Lib after change
        lib.Lib.f();
    }
}
