package ca.ubc.cs.spl.aspectPatterns.examples.abstractFactory.java;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    /**
	 * a concrete factory that creates regular GUI components
	 */
    private static ComponentFactory factory1 = new RegularFactory();

    /**
	 * a concrete factory that creates framed GUI components
	 */
    private static ComponentFactory factory2 = new FramedFactory();

    /**
     * stores the currently selected factory
     */
    private static ComponentFactory factory = factory1;

    /**
     * Creates the initial GUI that allows the user to choose a factory
     * and generate a new GUI with the elements that the respective
     * factory provides.
     *
     * @return a <code>JPanel</code> containing the GUI
     */
    private static JPanel createGUI() {
        ActionListener radioListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("factory1"))
                    factory = factory1;
                else
                    factory = factory2;
            }
        };
        JPanel panel = new JPanel();
        JRadioButton factoryButton1 = new JRadioButton("use Factory 1");
        JRadioButton factoryButton2 = new JRadioButton("use Factory 2");
        factoryButton1.setActionCommand("factory1");
        factoryButton2.setActionCommand("factory2");
        factoryButton1.addActionListener(radioListener);
        factoryButton2.addActionListener(radioListener);
        JButton create = new JButton("Create GUI");
        ButtonGroup choices = new ButtonGroup();
        choices.add(factoryButton1);
        choices.add(factoryButton2);
        create.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Display display = new Display(factory);
            }
        });
        panel.add(factoryButton1);
        panel.add(factoryButton2);
        panel.add(create);
        return panel;
    }

    /**
     * Implements the driver for this design pattern example. It sets up
     * the initial GUI.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Abstract Factory Demo");
        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.getContentPane().add(createGUI());
        frame.pack();
        frame.setVisible(true);
    }
}
