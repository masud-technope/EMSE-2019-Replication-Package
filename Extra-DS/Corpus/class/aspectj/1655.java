public class TypeExprErrors {

    static String s;

    static boolean b;

    static A a;

     TypeExprErrors() {
        this(A);
    }

     TypeExprErrors(Object o) {
    }

    static {
        s += A;
        a = A;
        f(A);
        f((A) A);
        f(b ? A : a);
        f(b ? a : A);
        new TypeExprErrors(A);
        ff(a == A);
        ff(A == a);
        ff(A != a);
        ff(a != A);
        ff(A != null);
        ff(null != A);
        ff(A == null);
        ff(null == A);
        ff(A instanceof A);
        f(new A[] { A });
        (A).m();
        // not actually an error
        (A).sm();
        f(s + A);
        f(A + s);
    }

    static void f(Object o) {
    }

    static void ff(boolean b) {
    }
}

class A {

    void m() {
    }

    static void sm() {
    }
}
