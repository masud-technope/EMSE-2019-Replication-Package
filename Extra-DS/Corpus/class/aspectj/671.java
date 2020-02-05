/** @testcase PR721 interface declaration not permitted in local method scope */
public class LocalInterfaceCE {

    void method() {
        // CE 5 interface not allowed here
        interface Local {
        }
    }

    static {
        // CE 8 interface not allowed here
        interface Local {
        }
    }

    static void staticMethod() {
        // CE 11 interface not allowed here
        interface Local {
        }
    }

    class Inner {

        void method() {
            // CE 15 interface not allowed here
            interface Local {
            }
        }
    }
}
