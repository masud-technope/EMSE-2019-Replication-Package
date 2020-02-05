package ca.ubc.cs.spl.aspectPatterns.examples.observer.aspectj;

import java.awt.Color;

public class Point {

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
    }

    /**
     * Sets the current y-coordinate.
     *
     * @param y the new y-coordinate
     */
    public void setY(int y) {
        this.y = y;
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
    }
}
