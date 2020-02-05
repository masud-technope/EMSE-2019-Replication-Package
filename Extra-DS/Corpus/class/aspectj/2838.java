public class InnerFlow {

    public static void main(String[] params) {
        final Object o = new Interface() {

            public void m() {
                //ERR: o not initialized
                o.toString();
            }
        };
        // no exceptions
        ((Interface) o).m();
    }
}

interface Interface {

    void m();
}
