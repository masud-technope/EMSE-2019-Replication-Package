public class InitializerFlowCf {

    // ERR initializer can't complete normally
    {
        throw new Error("bad error");
    }

    // ERR static initializer can't complete normally
    static {
        throw new Error("bad error #2");
    }
}
