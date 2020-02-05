package ca.ubc.cs.spl.aspectPatterns.examples.factoryMethod.java;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Point;

public abstract class GUIComponentCreator {

    /**
     * The factory method to be concretized by subclasses.
     *
     * @returns the created <i>ConcreteProduct</i>
     */
    public abstract JComponent createComponent();

    /**
     * Another factory method to create a title for the GUI frame created
     * by this class.
     *
     * @returns the title for the GUI frame
     */
    public abstract String getTitle();

    /** 
     * the position for the next frame to be created (on the screen). This
     * variable is used to make sure new frames appear staggered and don't 
     * entirely overlap with existing frames.
     */
    private static Point lastFrameLocation = new Point(0, 0);

    /** 
     * Creates a <code>JFrame</code>, puts the <code>JComponent</code> that
     * is created by the factory method into it and displays the frame. This
     * Method also provides a <code>WindowListener</code>. 
     */
    public final void showFrame() {
        JFrame frame = new JFrame(getTitle());
        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JPanel panel = new JPanel();
        panel.add(createComponent());
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocation(lastFrameLocation);
        lastFrameLocation.translate(75, 75);
        frame.setVisible(true);
    }
}
