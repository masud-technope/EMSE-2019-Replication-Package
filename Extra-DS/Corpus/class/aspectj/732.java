import org.aspectj.lang.annotation.*;

@Aspect
class A {

    @Before("call(* org..*(..))")
     A() {
    }
}
