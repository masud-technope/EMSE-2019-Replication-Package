import org.aspectj.testing.Tester;

/** @testcase PR#536 expecting compile failures with subclass narrowing scope of superclass methods or accessing private superclass variables */
public class RestrictingVisibilityCF {

    public static void main(String[] args) {
        Tester.check(false, "compile should fail");
    }
}

class Parent {

    public int publicAccess;

    protected int protectedAccess;

    int defaultAccess;

    private int privateAccess;

    public void publicAccess() {
    }

    protected void protectedAccess() {
    }

    void defaultAccess() {
    }

    private void privateAccess() {
    }

    void drivePrivateAccess() {
        privateAccess();
    }
}

class InValidChild extends Parent {

    /** @testcase subclass private implementation of public method */
    // errLine 27
    private void publicAccess() {
    }

    /** @testcase subclass private implementation of method with default access */
    // errLine 29
    private void defaultAccess() {
    }

    /** @testcase subclass private implementation of protected method */
    // errLine 31
    private void protectedAccess() {
    }

    // todo: sep package, attempt package acces
    int defaultAccessSub = defaultAccess;
}

class InValidChild2 extends Parent {

    // errLine 39 
    private void defaultAccess() {
    }

    /** @testcase subclass protected implementation of public method */
    // errLine 41 
    protected void publicAccess() {
    }
}

class InValidChild3 extends Parent {

    /** @testcase subclass default implementation of method with protected access */
    // errLine 46 
    void protectedAccess() {
    }

    /** @testcase subclass default implementation of public method */
    // errLine 48 
    void publicAccess() {
    }
}

class InValidChild4 extends Parent {

    /** @testcase private access members unavailable in subclass */
    // errLine 53
    private int foo = new Parent().privateAccess;
}
//  /** todo: separate package test */
//  class Invalid {
//      /** @testcase default access members unavailable from separate package */
//      private int bar = new Parent().defaultAccess;
//      /** @testcase protected access members unavailable from separate package */
//      private int foo = new Parent().protectedAccess;
//  }
