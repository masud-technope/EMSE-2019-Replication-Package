package ca.ubc.cs.spl.aspectPatterns.examples.bridge.java;

public class Main {

    /**
     * Implements the driver for this example. The two different screens
     * and screen implementations are tested in all possible combinations.
     *
     * @param args required by Java, but ignored
     */
    public static void main(String[] args) {
        System.out.println("Creating implementations...");
        ScreenImplementation i1 = new StarImplementation();
        ScreenImplementation i2 = new CrossCapitalImplementation();
        System.out.println("Creating abstraction (screens) / implementation combinations...");
        GreetingScreen gs1 = new GreetingScreen(i1);
        GreetingScreen gs2 = new GreetingScreen(i2);
        InformationScreen is1 = new InformationScreen(i1);
        InformationScreen is2 = new InformationScreen(i2);
        System.out.println("Starting test:\n");
        gs1.drawText("\nScreen 1 (Refined Abstraction 1, Implementation 1):");
        gs1.drawGreeting();
        gs2.drawText("\nScreen 2 (Refined Abstraction 1, Implementation 2):");
        gs2.drawGreeting();
        is1.drawText("\nScreen 3 (Refined Abstraction 2, Implementation 1):");
        is1.drawInfo();
        is2.drawText("\nScreen 4 (Refined Abstraction 2, Implementation 2):");
        is2.drawInfo();
    }
}
