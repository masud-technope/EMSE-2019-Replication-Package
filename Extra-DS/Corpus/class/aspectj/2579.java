class C {

    //ERROR Integer is not a Throwable
    public void m() throws Integer {
    }

    //ERROR C is not a Throwable
    public  C() throws C {
    }
}

class Sup {

    public void m() {
    }
}

class Sub extends Sup {

    public void m() throws Exception {
    }
}
