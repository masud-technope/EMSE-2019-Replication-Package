import org.aspectj.testing.Tester;

public class LiteralsCp {

    public static void main(String[] args) {
        float f;
        double d;
        f = 0;
        f = 0.0f;
        f = 0000000.0000000f;
        //NOT ERROR: rounds to DENORM
        f = 1e-44f;
        f = 3.40282347e+38f;
        f = 1.40239846e-45f;
        d = 0e1;
        d = 1.79769313486231570e+308;
        d = 4.94065645841246544e-324;
        int i, i1, i2, i3;
        long l, l1, l2, l3;
        //MAX_INT
        i1 = 2147483647;
        i2 = 0x7fffffff;
        i3 = 017777777777;
        checkEqual(i1, i2, i3, "MAX_INT");
        //MIN_INT
        i1 = -2147483648;
        i2 = 0x80000000;
        i3 = 020000000000;
        checkEqual(i1, i2, i3, "MIN_INT");
        //System.out.println(i1 + ", " + i2 + ", " + i3);
        i1 = -1;
        i2 = 0xffffffff;
        i3 = 037777777777;
        checkEqual(i1, i2, i3, "-1");
        //MAX_LONG
        l1 = 9223372036854775807L;
        l2 = 0x7fffffffffffffffL;
        l3 = 0777777777777777777777L;
        checkEqual(l1, l2, l3, "MAX_LONG");
        //System.out.println(l1 + ", " + l2 + ", " + l3);
        //MIN_LONG
        l1 = -9223372036854775808L;
        l2 = 0x8000000000000000L;
        l3 = 01000000000000000000000L;
        checkEqual(l1, l2, l3, "MIN_LONG");
        l1 = -1l;
        l2 = 0xffffffffffffffffL;
        l3 = 01777777777777777777777L;
        checkEqual(l1, l2, l3, "-1L");
    }

    static void checkEqual(long i1, long i2, long i3, String msg) {
        Tester.check(i1 == i2, msg + ": " + i1 + " == " + i2);
        Tester.check(i1 == i3, msg + ": " + i1 + " == " + i3);
        Tester.check(i2 == i3, msg + ": " + i2 + " == " + i3);
    }
}
