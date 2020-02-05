public class ClassClientCE {

    public static void main(String[] a) {
        // CE 5 expected: declare IOException
        new C().run();
    }
}

class C extends lib.LibraryClass {
}
