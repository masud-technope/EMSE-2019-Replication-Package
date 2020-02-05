//ERR: can't find type foo.bar.Bax
import foo.bar.Bax;
//ERR: can't find package a.b.c
import a.b.c.*;

public class NotFound {

    public static void main(String[] args) {
        //ERR: method g() not found
        g().bar();
        Mumble //ERR: type Mumble not found
        m = //ERR: type Mumble not found
        new Mumble();
        m.go();
        //ERR: type Mumble not found
        Mumble m2 = null;
        //ERR: CONST not found
        CONST.m(1);
    }
}
