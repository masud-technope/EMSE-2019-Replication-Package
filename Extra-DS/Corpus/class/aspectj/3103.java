public abstract class Modifiers {

    private public void foo1() {
    }

    protected public void foo2() {
    }

    private protected void foo4() {
    }

    abstract void foo6() {
    }

    abstract static void foo7();

    abstract synchronized void foo8();

    private abstract void foo9();

    abstract strictfp void foo10();

    abstract static class A {
    }
}
