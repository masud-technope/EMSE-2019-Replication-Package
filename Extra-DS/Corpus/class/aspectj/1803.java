package ca.ubc.cs.spl.aspectPatterns.examples.abstractFactory.java;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Sets up and displays a new GUI given a concrete factory.
 *
 * @author  Jan Hannemann
 * @author  Gregor Kiczales
 * @version 1.1, 01/20/04
 * 
 */
public class Display extends JFrame {

    public  Display(ComponentFactory factory) {
        super("New GUI");
        JLabel label = factory.createLabel();
        JButton button = factory.createButton("OK");
        button.addActionListener(new myActionListener(this));
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(button);
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
        this.addWindowListener(new myWindowListener(this));
    }

    private class myWindowListener extends WindowAdapter {

        Display display = null;

        protected  myWindowListener(Display display) {
            super();
            this.display = display;
        }

        public void windowClosing(WindowEvent e) {
            display.setVisible(false);
        }
    }

    private class myActionListener implements ActionListener {

        Display display;

        protected  myActionListener(Display display) {
            super();
            this.display = display;
        }

        public void actionPerformed(ActionEvent e) {
            display.setVisible(false);
        }
    }
}
