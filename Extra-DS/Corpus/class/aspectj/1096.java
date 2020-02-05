/**
 * @testcase PR#715 PUREJAVA incrementing objects, arrays
 */
public class ArrayIncCE {

    private static int[] IRA = new int[] { 0, 1, 2 };

    private static Object OBJECT = new Object();

    static int[] getIRA() {
        return IRA;
    }

    static Object getObject() {
        return null;
    }

    public void testObjectIncrementingCE() {
        int i = 0;
        Object object = new Object();
        String[] sra = new String[] { "" };
        // CE prefix ++ not applied to int[]
        ++getIRA();
        // CE prefix ++ not applied to Object
        ++getObject();
        // CE postfix ++ not applied to int[]
        getIRA()++;
        // CE postfix ++ not applied to Object
        getObject()++;
        // CE + not applied to int[], int
        getIRA() += 1;
        // CE + not applied to Object, int
        getObject() += 1;
        // CE no literal on lhs
        "1" += sra[0];
    }
}
