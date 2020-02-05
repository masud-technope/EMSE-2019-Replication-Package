package ca.ubc.cs.spl.aspectPatterns.examples.observer.java;

import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;

public class Point implements ChangeSubject {

    /**
     * stores the <i>Observer</i>s for this point (<i>Subject</i>)
     */
    private HashSet observers;

    /**
     * the point's x-coordinate
     */
    private int x;

    /**
     * the point's y-coordinate
     */
    private int y;

    /** 
     * the point's current color
     */
    private Color color;

    public  Point(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.observers = new HashSet();
    }

    /**
     * Returns the point's current x-coordinate.
     *
     * @return the current x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the point's current y-coordinate.
     *
     * @return the current y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the current x-coordinate.
     *
     * @param x the new x-coordinate
     */
    public void setX(int x) {
        this.x = x;
        notifyObservers();
    }

    /**
     * Sets the current y-coordinate.
     *
     * @param y the new y-coordinate
     */
    public void setY(int y) {
        this.y = y;
        notifyObservers();
    }

    /**
     * Returns the point's current color.
     *
     * @return the current color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the current color.
     *
     * @param color the new color
     */
    public void setColor(Color color) {
        this.color = color;
        notifyObservers();
    }

    /**
	 * Attaches an <i>Observer</i> to this <i>Subject</i>.
	 * 
	 * @param o the <i>Observer</i> to attach
	 */
    public void addObserver(ChangeObserver o) {
        this.observers.add(o);
    }

    /**
	 * Detaches an <i>Observer</i> from this <i>Subject</i>.
	 * 
	 * @param o the <i>Observer</i> to detach
	 */
    public void removeObserver(ChangeObserver o) {
        this.observers.remove(o);
    }

    /**
	 * Notifies all <i>Observer</i>s.
	 */
    public void notifyObservers() {
        for (Iterator e = observers.iterator(); e.hasNext(); ) {
            ((ChangeObserver) e.next()).refresh(this);
        }
    }
}
