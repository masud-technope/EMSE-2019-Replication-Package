public class InnerNameConflictsCf {

    class Inner {
    }

    public static void main(String[] args) {
        //ERR: no this
        new Inner();
    }
}

class Base {

    //ERR: repeated name
    static class Base {
    }
}

class Outer {

    class Inner {

        class Inner2 {

            //ERR: repeated name
            class Outer {
            }

            //ERR: repeated name
            class Inner {
            }
        }
    }
}
