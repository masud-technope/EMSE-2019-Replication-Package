class Type {
}

class bat {

    public static final Type SOURCE = new Type();
}

public class DefiniteStatic {

    protected static final Type SINK = bat.SOURCE;

    // incorrect CE: field SINK might not have a value
    public Type sink = SINK;

    public static void main(String[] args) {
    }
}
