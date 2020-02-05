package ca.ubc.cs.spl.aspectPatterns.examples.chainOfResponsibility.aspectj;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class Frame extends JFrame {

    public  Frame(String title) {
        super(title);
        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
