package ca.ubc.cs.spl.aspectPatterns.examples.prototype.aspectj;

public class Main {

    /**
     * Implements the driver for the Prototype design pattern example.<p> 
     *
     * In this example, both StringPrototypeA and StringPrototypeB implement cloneable
     * classes emulating limited String behavior. This driver creates an 
     * object of each class and clones it. Both originals and clones are
     * manipulated to show that they are different objects. 
     *
     * @param args the command line parameters, unused.
     */
    public static void main(String[] args) {
        System.out.println("Testing the Prototype design pattern implementation...");
        StringPrototypeA originalA;
        StringPrototypeB originalB;
        StringPrototypeA copyA1, copyA2;
        StringPrototypeB copyB1;
        originalA = new StringPrototypeA("  This is Prototype 1");
        originalB = new StringPrototypeB("  This is Prototype 2");
        System.out.println("These are the two prototypes:");
        System.out.println(originalA);
        System.out.println(originalB);
        copyA1 = (StringPrototypeA) StringPrototypes.aspectOf().cloneObject(originalA);
        copyB1 = (StringPrototypeB) StringPrototypes.aspectOf().cloneObject(originalB);
        System.out.println("These are copies of the prototypes:");
        System.out.println(copyA1);
        System.out.println(copyB1);
        System.out.println("Now prototype 1 is changed. Here are prototype 1 and its former copy:");
        originalA.setText("  This is Prototype 1 (changed)");
        System.out.println(originalA);
        System.out.println(copyA1);
        System.out.println("This is a clone of the changed prototype 1 and a changed copy of prototype 2:");
        copyA2 = (StringPrototypeA) StringPrototypes.aspectOf().cloneObject(originalA);
        copyB1.setText("  This is a changed copy of prototype 2");
        System.out.println(copyA2);
        System.out.println(copyB1);
        System.out.println("... done.");
    }
}
