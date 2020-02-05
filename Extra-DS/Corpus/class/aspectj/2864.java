package ca.ubc.cs.spl.aspectPatterns.examples.command.aspectj;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import ca.ubc.cs.spl.aspectPatterns.patternLibrary.Command;

public class Main extends JFrame {

    /**
     * This example creates a simple GUI with three buttons. Each 
     * button has a <i>Command</i> associated with it that is executed when 
     * the button is pressed. Button1 and button3 have the same command, 
     * button2 has a different one.
     */
    public static void main(String[] args) {
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Command com1 = new ButtonCommand();
        Command com2 = new ButtonCommand2();
        JPanel pane = new JPanel();
        pane.add(button1);
        ButtonCommanding.aspectOf().setCommand(button1, com1);
        pane.add(button2);
        ButtonCommanding.aspectOf().setCommand(button2, com2);
        ButtonCommanding.aspectOf().setReceiver(com2, new Printer());
        pane.add(button3);
        ButtonCommanding.aspectOf().setCommand(button3, com1);
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
