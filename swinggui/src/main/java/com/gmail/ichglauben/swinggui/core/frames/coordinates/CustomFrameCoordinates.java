package com.gmail.ichglauben.swinggui.core.frames.coordinates;

/**
 * Used to store a frame's (or any window container) x and y coordinates values.
 * 
 * @author Rick Walker
 * @version 0.1
 * @since 11/14/2015
 * @see java.io.Serializable
 */
public class CustomFrameCoordinates implements java.io.Serializable {
	/** This variable contains the x coordinate value. */
	public int x_coord = 0;
	/** This variable contains the y coordinate value. */
	public int y_coord = 0;

	/**
	 * Single constructor, this class is initialized with x and y values.
	 * 
	 * @param x
	 *            Coordinate X value
	 * @param y
	 *            Coordinate Y value
	 */
	public CustomFrameCoordinates(int x, int y) {
		this.x_coord = x;
		this.y_coord = y;
	}
}