package ca.ubc.cs.spl.aspectPatterns.examples.chainOfResponsibility.aspectj;

import java.awt.event.ActionEvent;

public class Click {

    /**
     * the ActionEvent that describes this Click
     */
    protected ActionEvent description;

    public  Click(ActionEvent description) {
        this.description = description;
    }

    /** 
     * Convenience method for inquiring whether SHIFT was pressed while
     * the click occured. 
     * 
     * @return whether the SHIFT key was pressed when the click occured
     */
    public boolean hasShiftMask() {
        return ((description.getModifiers() & ActionEvent.SHIFT_MASK) != 0);
    }

    /** 
	 * Convenience method for inquiring whether ALT was pressed while
	 * the click occured. 
	 * 
	 * @return whether the ALT key was pressed when the click occured
	 */
    public boolean hasAltMask() {
        return ((description.getModifiers() & ActionEvent.ALT_MASK) != 0);
    }

    /** 
	 * Convenience method for inquiring whether CTRL was pressed while
	 * the click occured. 
	 * 
	 * @return whether the CTRL key was pressed when the click occured
	 */
    public boolean hasCtrlMask() {
        return ((description.getModifiers() & ActionEvent.CTRL_MASK) != 0);
    }
}
