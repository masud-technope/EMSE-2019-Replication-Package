package ca.ubc.cs.spl.aspectPatterns.examples.observer.aspectj;

import java.awt.Color;

public class Main {

    /**
     * Implements the driver for the Observer example. It creates five 
     * <code>Screen</code> objects  and one <code>Point</code> object
     * and sets the appropriate observing relationships (see above). 
     * After the setup, the color of the point is changed, then it's 
     * x-coordinate. <p>
     * The following results should be expected: <OL>
     *  <LI> The color change should trigger s1 and s2 to each print an 
     *       appropriate message.
     *  <LI> s2's message should trigger it's observer s5 to print
     *       a message.
     *  <LI> The coordinate change should trigger s3 and s4.
     *  <LI> s4's message should trigger it's observer s5 again. 
     * </OL>
     */
    public static void main(String argv[]) {
        Point p = new Point(5, 5, Color.blue);
        System.out.println("Creating Screen s1,s2,s3,s4,s5 and Point p");
        Screen s1 = new Screen("s1");
        Screen s2 = new Screen("s2");
        Screen s3 = new Screen("s3");
        Screen s4 = new Screen("s4");
        Screen s5 = new Screen("s5");
        System.out.println("Creating observing relationships:");
        System.out.println("- s1 and s2 observe color changes to p");
        System.out.println("- s3 and s4 observe coordinate changes to p");
        System.out.println("- s5 observes s2's and s4's display() method");
        ColorObserver.aspectOf().addObserver(p, s1);
        ColorObserver.aspectOf().addObserver(p, s2);
        CoordinateObserver.aspectOf().addObserver(p, s3);
        CoordinateObserver.aspectOf().addObserver(p, s4);
        ScreenObserver.aspectOf().addObserver(s2, s5);
        ScreenObserver.aspectOf().addObserver(s4, s5);
        System.out.println("Changing p's color:");
        p.setColor(Color.red);
        System.out.println("Changing p's x-coordinate:");
        p.setX(4);
        System.out.println("done.");
    }
}
