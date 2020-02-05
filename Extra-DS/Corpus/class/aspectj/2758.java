/** @testcase PUREJAVA PR#739 local variables must be final to be accessed from inner class */
class LocalsFromInnerCE {

    void f() {
        int i = 0;
        new Runnable() {

            // CE 6 nonfinal variable
            public void run() {
                i++;
            }
        }.run();
    }

    static void sf() {
        int i = 0;
        new Runnable() {

            // CE 13 nonfinal variable
            public void run() {
                i++;
            }
        }.run();
    }

    void f(int i) {
        new Runnable() {

            // CE 19 nonfinal variable
            public void run() {
                i++;
            }
        }.run();
    }

    static void sf(int i) {
        new Runnable() {

            // CE 25 nonfinal variable
            public void run() {
                i++;
            }
        }.run();
    }

    static {
        int i = 0;
        new Runnable() {

            // CE 32 nonfinal variable
            public void run() {
                i++;
            }
        }.run();
    }

    void m(int i) {
        class m {

            void f(int i) {
                new Runnable() {

                    // CE 40 nonfinal variable
                    public void run() {
                        i++;
                    }
                }.run();
            }
        }
    }

    void m() {
        int i = 0;
        class m {

            void f() {
                new Runnable() {

                    // CE 51 nonfinal variable
                    public void run() {
                        i++;
                    }
                }.run();
            }
        }
    }

    class m {

        void f() {
            int i = 0;
            new Runnable() {

                // CE 61 nonfinal variable
                public void run() {
                    i++;
                }
            }.run();
        }

        void f(int i) {
            new Runnable() {

                // CE 67 nonfinal variable
                public void run() {
                    i++;
                }
            }.run();
        }
    }

     LocalsFromInnerCE() {
        int i = 0;
        new Runnable() {

            // CE 75 nonfinal variable
            public void run() {
                i++;
            }
        }.run();
    }

     LocalsFromInnerCE(int i) {
        new Runnable() {

            // CE 81 nonfinal variable
            public void run() {
                i++;
            }
        }.run();
    }
}
