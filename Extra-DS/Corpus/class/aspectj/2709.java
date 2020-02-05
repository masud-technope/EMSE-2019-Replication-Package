public class BadExtension {
}

abstract class Super {

    public final void finalPublic() {
    }

    public void justPublic() {
    }

    public int intPublic() {
    }

    //ERROR shouldn't have a body
    public abstract void abstractWithBody() {
    }

    public abstract void abstractPublic();

    public static final void staticFinalPublic() {
    }
}

class Sub extends //ERROR must implement abstractPublic
Super {

    //ERROR can't override final
    public void finalPublic() {
    }

    //ERROR can't override with weaker access
    void justPublic() {
    }

    //ERROR can't change the return type
    public void intPublic() {
    }

    //ERROR can't even override static finals
    public static void staticFinalPublic() {
    }
}

interface I1 {

    void m();
}

interface I2 {

    int m();
}

class C12 implements I1, I2 {

    //ERROR incompatible return types with I2.m()
    public void m() {
    }
}

//ERROR I1.m() and I2.m() are not compatible
interface I12 extends I1, I2 {
}
