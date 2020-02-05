import junit.framework.TestCase;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.util.Reflection;

public class AroundAMain extends TestCase {

    public  AroundAMain(String name) {
        super(name);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        AroundClosure closure = new AroundClosure() {

            public Object run(Object[] args) throws Throwable {
                //				System.out.println("run with: " + Arrays.asList(args));
                return new Integer(10);
            }
        };
        Object instance = Reflection.getStaticField(Class.forName("AroundA"), "ajc$perSingletonInstance");
        // was $AroundA$46
        Reflection.invoke(// was $AroundA$46
        Class.forName("AroundA"), // was $AroundA$46
        instance, // was $AroundA$46
        "ajc$around$AroundA$1$73ebb943", new Integer(10), new Boolean(true), closure);
        // Was $AroundA$c5
        Reflection.invoke(// Was $AroundA$c5
        Class.forName("AroundA"), // Was $AroundA$c5
        instance, // Was $AroundA$c5
        "ajc$around$AroundA$2$a758212d", "hello there", closure);
        // Was $AroundA$150
        Reflection.invoke(// Was $AroundA$150
        Class.forName("AroundA"), // Was $AroundA$150
        instance, // Was $AroundA$150
        "ajc$around$AroundA$3$a758212d", new String[1], closure);
    }
}
