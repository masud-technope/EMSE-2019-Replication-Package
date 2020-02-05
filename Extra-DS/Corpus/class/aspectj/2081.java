import org.aspectj.lang.annotation.*;

@Aspect
class A {
}

class B extends A {

    @Before("call(* org..*(..))")
    public void someCall() {
    }
}
