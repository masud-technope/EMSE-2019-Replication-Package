public class ClientCE {

    public static void main(String[] a) {
        // CE 5 expected: declare IOException
        new C().run();
    }
}

class C implements lib.LibraryInterface {
}
