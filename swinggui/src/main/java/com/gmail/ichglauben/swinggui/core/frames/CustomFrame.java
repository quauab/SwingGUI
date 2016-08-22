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
		int xc = this.getX();
		int yc = this.getY();
		
		CustomFrameCoordinates cfc = new CustomFrameCoordinates(xc, yc);
		ObjectSerializer.serialize(cfc,"_coordinates");

		String path = GlobalConstants.USRDIR;
		String file = "_coordinates.ser";
		String filePath = path + file;

		/*println("Saving Coordinates:\t X = " + cfc.x_coord + "\t Y = " + cfc.y_coord);
		println("Saving coordinates file to:\t" + filePath + "\n");*/
		
	}

	/** Internal method that checks and/or creates the location file. */
	private void setLocation() {
		String path = GlobalConstants.USRDIR;
		String file = "_coordinates.ser";
		String filePath = path + file;
		boolean coordinatesFileExists = PathValidator.pathExists(filePath);
		
		if (coordinatesFileExists) {
			CustomFrameCoordinates cfc = (CustomFrameCoordinates)ObjectDeserializer.deserialize(file);			
			int xc = cfc.x_coord;
			int yc = cfc.y_coord;
		/*	
			println("GUI's Location setting from file:\t" + filePath);
			println("Setting GUI's location to: X = " + xc + "\t Y = " + yc);*/			
			this.setLocation(new Point(xc,yc));
		} else {
			/*println("Coordinates not found at:\t" + filePath + "\n");*/
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
	
	private final static void print(Object o) {
		System.out.print(String.valueOf(o));
	}
	
	private final static void println(Object o) {
		System.out.println(String.valueOf(o));
	}

	@Override
	public String toString() {
		return "Custom Frame";
	}
}// end class
