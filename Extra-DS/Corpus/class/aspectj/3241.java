import org.aspectj.lang.annotation.*;

class A {

    @Pointcut("call(* *.*(..))")
    void someCall() {
    }
}
