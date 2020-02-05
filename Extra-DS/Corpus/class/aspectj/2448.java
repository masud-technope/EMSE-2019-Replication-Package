/** @testcase PR#40814 compile error expected for pointcuts in interfaces
 *    revised to check for error on abstract pointcuts in interfaces or classes
 **/
interface I {

    // CE
    abstract pointcut pc();
}

abstract class C {

    // CE
    abstract pointcut pc();
}

class Concrete {

    // CE
    abstract pointcut pc();
}
