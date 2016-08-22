package com.gmail.ichglauben.swinggui.core.frames.coordinates;

import java.io.*;
import java.util.*;

/**
 * Used to save the CustomFrameCoordinates object to and retrieve from file.
 * 
 * @author Rick Walker
 * @version 0.1
 * @since 11/14/2015
 * @see java.io.FileOutputStream
 * @see java.io.ObjectOutputStream
 * @see java.io.FileInputStream
 * @see java.io.ObjectInputStream
 */
public class FrameCoordinates {
	/** This variable holds reference to the CustomFrameCoordinates object. */
	private CustomFrameCoordinates cfc;

	/**
	 * Overloaded constructor, to save the CustomFrameCoordinates object this
	 * must be initialized with a CustomFrameCoordinates object.
	 * 
	 * @param custom_frame_coordinates
	 *            The reference to the CustomFrameCoordinates object
	 */
	public FrameCoordinates(CustomFrameCoordinates custom_frame_coordinates) {
		cfc = custom_frame_coordinates;
	}

	/** Empty constructor allows the de-serialization process. */
	public FrameCoordinates() {
	}

	/** Call this method to save the CustomFrameCoordinates object to file. */
	public void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream("_coordinates.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cfc);
			oos.flush();
			fos.close();
			oos.close();
		} catch (IOException ioe) {
			System.err.println("Error saving the object");
		}
	}

	/**
	 * Call this method to de-serialize the CustomFrameCoordinates object from
	 * disk.
	 * 
	 * @return ArrayList<Integer> Contains the x and y coordinate values
	 */
	public ArrayList<Integer> deserialize() {
		ArrayList<Integer> coordinates = new ArrayList<Integer>();

		try {
			FileInputStream fis = new FileInputStream("_coordinates.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			CustomFrameCoordinates custom_frame_coordinates = (CustomFrameCoordinates) ois.readObject();
			coordinates.add(custom_frame_coordinates.x_coord);
			coordinates.add(custom_frame_coordinates.y_coord);
			ois.close();
			fis.close();
		} catch (IOException ioe) {
		} catch (ClassNotFoundException cnf) {
		}

		return coordinates;
	}
}