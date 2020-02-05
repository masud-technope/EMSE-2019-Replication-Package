import java.io.IOException;

public class ExplicitConstructorThrows extends //ERR: default constructor throws IOException
Base {
}

class Base {

     Base() throws IOException {
    }
}

class Sub1 extends Base {

     Sub1() {
        //ERR: throws IOException
        super();
    }
}

class Sub2 extends Base {

     Sub2(String s) {
        //ERR: throws IOException
        this();
    }

     Sub2() throws IOException {
        super();
    }
}
