package org.aspectj.apache.bcel.verifier;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import org.aspectj.apache.bcel.generic.Type;

/**
 * A graphical user interface application demonstrating JustIce.
 *
 * @version $Id: GraphicalVerifier.java,v 1.4 2004/11/22 08:31:27 aclement Exp $
 * @author Enver Haase
 */
public class GraphicalVerifier {

    boolean packFrame = false;

    /** Constructor. */
    public  GraphicalVerifier() {
        VerifierAppFrame frame = new VerifierAppFrame();
        //Frames packen, die nutzbare bevorzugte Größeninformationen enthalten, z.B. aus ihrem Layout
        if (packFrame) {
            frame.pack();
        } else {
            frame.validate();
        }
        //Das Fenster zentrieren
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
        frame.classNamesJList.setModel(new VerifierFactoryListModel());
        // Fill list with java.lang.Object
        VerifierFactory.getVerifier(Type.OBJECT.getClassName());
        // default, will verify java.lang.Object
        frame.classNamesJList.setSelectedIndex(0);
    }

    /** Main method. */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GraphicalVerifier();
    }
}
