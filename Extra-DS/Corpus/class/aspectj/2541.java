package ca.ubc.cs.spl.aspectPatterns.examples.command.java;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    /**
     * This example creates a simple GUI with three buttons. Each button has a 
     * command associated with it that is executed when the button is pressed. 
     * Button1 and button3 have the same command, button2 has a different one.
     */
    public static void main(String[] args) {
        Button button1 = new Button("Print Date");
        Button button2 = new Button("Command 1");
        Button button3 = new Button("Command 2");
        Command com1 = new ButtonCommand();
        Command com2 = new ButtonCommand2();
        JPanel pane = new JPanel();
        pane.add(button1);
        button1.setCommand(com1);
        pane.add(button2);
        button2.setCommand(com2);
        pane.add(button3);
        button3.setCommand(com1);
        // Note: Can not have two commands.
        // That is within the pattern specification
        JFrame frame = new JFrame("Command Pattern Example");
        frame.getContentPane().add(pane);
        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
