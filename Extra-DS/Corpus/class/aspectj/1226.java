import org.aspectj.lang.annotation.*;

@Aspect
class Foo {

    // must qualify
    @Pointcut("call(* java.util.List.*(..))")
    void listOperation() {
    }

    // should compile, I think - just matches no joinPoints
    @Pointcut("")
    void anyUtilityCall() {
    }
}
