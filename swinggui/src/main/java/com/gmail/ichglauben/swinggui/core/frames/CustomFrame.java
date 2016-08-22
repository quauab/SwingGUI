package com.gmail.ichglauben.swinggui.core.frames;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.gmail.ichglauben.serialmanager.core.deserializer.ObjectDeserializer;
import com.gmail.ichglauben.serialmanager.core.serializer.ObjectSerializer;
import com.gmail.ichglauben.serialmanager.core.utils.PathValidator;
import com.gmail.ichglauben.serialmanager.core.utils.constants.GlobalConstants;
import com.gmail.ichglauben.swinggui.core.frames.coordinates.CustomFrameCoordinates;
import com.gmail.ichglauben.swinggui.core.panels.CustomPanel;


/**
 * This is a customized JFrame.
 * 
 * @see javax.swing.JFrame
 * @see java.awt.BorderLayout
 * @see java.awt.Toolkit
 * @author Rick Walker
 * @version 0.1
 * @since 11/14/2015
 *
 */
public abstract class CustomFrame extends JFrame {
	private String coordinatesPath = GlobalConstants.USRDIR;
	private String coordinatesFile = "_coordinates.ser";
	private String coordinatesFilePath = coordinatesPath + coordinatesFile;
	
	/**
	 * Overloaded constructor, this class can initialize with a custom JPanel
	 * and is automatically initialized with icon and a location memory that's
	 * activated after first run; a location file is saved in the application's
	 * directory to which the application references on each run.
	 * 
	 * @param controls
	 *            The child JPanel that provides the GUI controls
	 */
	public CustomFrame(CustomPanel controls) {
		super();
		setIconImage(wi);
		new BorderLayout();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				saveLocation();
				exitProg();
			}

			public void windowOpened(WindowEvent we) {
				setLocation();
			}
		});

		add(controls, BorderLayout.CENTER);
		setResizable(false);
		pack();
		setVisible(true);
	}

	/**
	 * Overloaded constructor, this class can initialize without argument and is
	 * automatically initialized with icon and a location memory that's
	 * activated after first run; a location file is saved in the application's
	 * directory to which the application references on each run.
	 */
	public CustomFrame() {
		super();
		setIconImage(wi);
		new BorderLayout();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				saveLocation();
				exitProg();
			}

			public void windowOpened(WindowEvent we) {
				setLocation();
			}
		});

		setResizable(false);
		pack();
		setVisible(true);
	}

	/**
	 * Internal method that calls the objects that creates and saves the
	 * location file to disk.
	 */
	private void saveLocation() {
		ObjectSerializer.serialize(new CustomFrameCoordinates(this.getX(), this.getY()),"_coordinates");	
	}

	/** Internal method that checks and/or creates the location file. */
	private void setLocation() {	
		if (PathValidator.pathExists(coordinatesFilePath)) {
			CustomFrameCoordinates cfc = (CustomFrameCoordinates)ObjectDeserializer.deserialize(coordinatesFile);	
			this.setLocation(new Point( cfc.x_coord,cfc.y_coord));
		} else {
			saveLocation();
			setLocation();
		}
	}

	/** Internal method called when window closing event fires. */
	public void exitProg() {
		this.dispose();
		System.exit(0);
	}

	/** This variable contains the path to the window's icon image. */
	private final static java.net.URL path = CustomFrame.class.getResource("/medium.gif");
	
	/** @see java.awt.Toolkit */
	private final static Image wi = Toolkit.getDefaultToolkit().createImage(path);
	
	@Override
	public String toString() {
		return "Abstract Custom Frame";
	}
}// end class
