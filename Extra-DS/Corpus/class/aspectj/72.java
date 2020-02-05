import org.aspectj.testing.Tester;

/** @testcase PR#752 PUREJAVA subclass access to enclosing super class private members */
public class SubclassAccessToEnclosingSuperClassPrivate {

    public static void main(String[] args) {
        // load expectations..
        ClassLoader loader = Expect.class.getClassLoader();
        // nested classes
        new SuperEnclosing.SubNested().doit();
        new SuperEnclosing.SubNested.SubSubNested().doit();
        new SuperEnclosing.SubNested.SubSubNestedNoExtends().doit();
        // inner (non-static nested) classes
        SuperEnclosing me = new SuperEnclosing();
        // run directly
        me.new SubInner("main").doit();
        // run indirectly
        me.runSubInner();
        me.runMethodLocalInnerSubclass();
        Tester.checkAllEvents();
    }
}

/**
 * <pre>
 * Access private static and instance method and field from
 * - static nested subclass
 * - inner (named) member subclass
 * - inner method-local subclass
 * - inner anonymous subclass
 * other variants:
 * - more deeply nested - skip over intervening superclass or enclosing class
 * 
 * incorrect compiler error lines flagged as i-c-e
 * </pre>
 */
class SuperEnclosing {

    private static int staticPrivateInt = 42;

    private int privateInt = 84;

    private static void staticPrivateMethod(String caller) {
        Tester.event(caller + " -> SuperEnclosing.staticPrivateMethod()");
    }

    private void privateMethod(String caller) {
        Tester.event(caller + " -> SuperEnclosing.privateMethod()");
    }

    static class SubNested extends SuperEnclosing {

        static void doit() {
            String label = "SubNested.run()";
            // i-c-e
            label = label + "(" + staticPrivateInt + ")";
            Tester.event(label);
            // i-c-e
            staticPrivateMethod(label);
        }

        static class SubSubNestedNoExtends {

            static void doit() {
                String label = "SubSubNestedNoExtends.run()";
                // i-c-e
                label = label + "(" + staticPrivateInt + ")";
                Tester.event(label);
                // i-c-e
                staticPrivateMethod(label);
            }
        }

        static class SubSubNested extends SuperEnclosing {

            static void doit() {
                String label = "SubSubNestedNoExtends.run()";
                // i-c-e
                label = label + "(" + staticPrivateInt + ")";
                Tester.event(label);
                // i-c-e
                staticPrivateMethod(label);
            }
        }
    }

    void runSubInner() {
        new SubInner("Constructed in SuperEnclosing.run()").doit();
    }

    void runMethodLocalInnerSubclass() {
        new SuperEnclosing() {

            void doit() {
                String label = "runMethodLocalInnerSubclass anonymous SuperEnclosing subclass";
                // i-c-e
                label = label + "(" + staticPrivateInt + ", " + privateInt + ")";
                Tester.event(label);
                // i-c-e
                privateMethod(label);
                // i-c-e
                staticPrivateMethod(label);
            }
        }.doit();
        new SuperEnclosing() {

            void doit() {
                new SuperEnclosing() {

                    void doit() {
                        String label = "runMethodLocalInnerSubclass anonymous SuperEnclosing (inner) subclass";
                        // i-c-e
                        label = label + "(" + staticPrivateInt + ", " + privateInt + ")";
                        Tester.event(label);
                        // i-c-e
                        privateMethod(label);
                        // i-c-e
                        staticPrivateMethod(label);
                    }
                }.doit();
            }
        }.doit();
    }

    // ---------- non-static inner
    class SubInner extends SuperEnclosing {

        String name;

         SubInner(String name) {
            this.name = name;
        }

        void doit() {
            String label = "SubInner=\"" + name + "\".run() ";
            // i-c-e
            label = label + "(" + staticPrivateInt + ", " + privateInt + ")";
            Tester.event(label);
            // i-c-e
            privateMethod(label);
            // i-c-e
            staticPrivateMethod(label);
        }

        class SubSubInnerNoExtends {

            void doit() {
                String label = "SubSubInnerNoExtends.run()";
                // i-c-e
                label = label + "(" + staticPrivateInt + ", " + privateInt + ")";
                Tester.event(label);
                // i-c-e
                staticPrivateMethod(label);
                // i-c-e
                privateMethod(label);
            }
        }

        class SubSubInner extends SuperEnclosing {

            void doit() {
                String label = "SubSubInnerNoExtends.run()";
                // i-c-e
                label = label + "(" + staticPrivateInt + ", " + privateInt + ")";
                Tester.event(label);
                // i-c-e
                staticPrivateMethod(label);
                // i-c-e
                privateMethod(label);
            }
        }
    }
}

class Expect {

    static {
        Tester.expectEvent("SubNested.run()(42)");
        Tester.expectEvent("SubNested.run()(42) -> SuperEnclosing.staticPrivateMethod()");
        Tester.expectEvent("SubSubNestedNoExtends.run()(42)");
        Tester.expectEvent("SubSubNestedNoExtends.run()(42) -> SuperEnclosing.staticPrivateMethod()");
        Tester.expectEvent("SubSubNestedNoExtends.run()(42)");
        Tester.expectEvent("SubSubNestedNoExtends.run()(42) -> SuperEnclosing.staticPrivateMethod()");
        Tester.expectEvent("SubInner=\"main\".run() (42, 84)");
        Tester.expectEvent("SubInner=\"main\".run() (42, 84) -> SuperEnclosing.privateMethod()");
        Tester.expectEvent("SubInner=\"main\".run() (42, 84) -> SuperEnclosing.staticPrivateMethod()");
        Tester.expectEvent("SubInner=\"Constructed in SuperEnclosing.run()\".run() (42, 84)");
        Tester.expectEvent("SubInner=\"Constructed in SuperEnclosing.run()\".run() (42, 84) -> SuperEnclosing.privateMethod()");
        Tester.expectEvent("SubInner=\"Constructed in SuperEnclosing.run()\".run() (42, 84) -> SuperEnclosing.staticPrivateMethod()");
        Tester.expectEvent("runMethodLocalInnerSubclass anonymous SuperEnclosing subclass(42, 84)");
        Tester.expectEvent("runMethodLocalInnerSubclass anonymous SuperEnclosing subclass(42, 84) -> SuperEnclosing.privateMethod()");
        Tester.expectEvent("runMethodLocalInnerSubclass anonymous SuperEnclosing subclass(42, 84) -> SuperEnclosing.staticPrivateMethod()");
        Tester.expectEvent("runMethodLocalInnerSubclass anonymous SuperEnclosing (inner) subclass(42, 84)");
        Tester.expectEvent("runMethodLocalInnerSubclass anonymous SuperEnclosing (inner) subclass(42, 84) -> SuperEnclosing.privateMethod()");
        Tester.expectEvent("runMethodLocalInnerSubclass anonymous SuperEnclosing (inner) subclass(42, 84) -> SuperEnclosing.staticPrivateMethod()");
    }
}
