import java.sql.Array;
// ERR: importing same name different types
import java.lang.reflect.Array;

public class AmbiguousClassReference2CE {

    /** @testcase PR#701 PUREJAVA CE for ambiguous type reference (imports)
     *  see also testcase PR#631 */
    public static void main(String[] args) {
        int[] gh = new int[5];
        // bug: expect ~ambiguous~ not "no method getLength..."
        Array.getLength(gh);
        throw new Error("Expecting compiler error, not compile/run");
    }
}
