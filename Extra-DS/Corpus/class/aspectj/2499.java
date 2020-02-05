public class LiteralsCf {

    public static void main(String[] args) {
        float f;
        double d;
        //Why not error?
        f = 3.4028235e+38f;
        //Why not error?
        f = 1.4023983e-45f;
        //ERR: rounds to +INF
        f = 1e39f;
        //ERR: rounds to 0
        f = 0.0000000000000000000000000000000000000000000000001f;
        //ERR: rounds to -INF
        f = -1234567890123456789012345678901234567890123f;
        //ERR: rounds to -INF
        d = -1e310;
        //ERR: rounds to +INF
        d = 1e500;
        int i, i1, i2, i3;
        long l, l1, l2, l3;
        //ERR: too big
        i = 2147483648;
        //ERR: too big
        i = 0x1ffffffff;
        //ERR: too big
        i = 01234567012345670;
        i2 = 0x800000000;
        i3 = 0200000000000;
        i2 = 0x100000000;
        i3 = 040000000000;
        //ERR: too small
        i = -2147483649;
        //ERR: too big
        l = 9223372036854775808L;
        //ERR: too small
        l = -9223372036854775809L;
        l2 = 0x80000000000000000L;
        l3 = 010000000000000000000000L;
        //ERR: illegal octal
        i = 09;
    }
}
