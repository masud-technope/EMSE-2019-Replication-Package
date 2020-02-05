import java.lang.annotation.*;

enum SimpleEnum implements  {

    Red() {
    }
    , Orange() {
    }
    , Yellow() {
    }
    , Green() {
    }
    , Blue() {
    }
    , Indigo() {
    }
    , Violet() {
    }
    ;
}

;

@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationEnumElement {

    SimpleEnum enumval();
}

@AnnotationEnumElement(enumval = SimpleEnum.Red)
class C {
}
