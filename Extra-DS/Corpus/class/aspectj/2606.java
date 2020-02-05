package circle;

public class Test1CF {
}

class Base {

    //CE cyclic inheritance
    public interface I extends IBottom {
    }
}

class Type {

    public interface Reflexive {
    }
}

interface DerivedI extends Base.I, Type.Reflexive {
}

interface IBottom extends DerivedI {
}
