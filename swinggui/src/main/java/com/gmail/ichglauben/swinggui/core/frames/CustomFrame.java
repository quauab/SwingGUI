package com.gmail.ichglauben.swinggui.core.frames;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.gmail.ichglauben.serialmanager.core.deserializer.ObjectDeserializer;
import com.gmail.ichglauben.serialmanager.core.serializer.ObjectSerializer;
import com.gmail.ichglauben.serialmanager.core.utils.PathValidator;
import com.gmail.ichglauben.serialmanager.core.utils.constants.GlobalConstants;
import com.gmail.ichglauben.swinggui.core.frames.coordinates.CustomFrameCoordinates;
import com.gmail.ichglauben.swinggui.core.panels.CustomPanel;

/**
 * <h2>Custom JFrame</h2>
 * <div>
 * 		<b>Class Dependencies:</b>&nbsp; SerialManager, PathValidator<br>
 * 		<b>Description:</b>&nbsp; Extends JFrame with a built-in mechanism for remembering it's last location at run-time.
 * </div>
 * 	@see javax.swing.JFrame
 * 	@see java.awt.BorderLayout
 * 	@see java.awt.Toolkit
 * 	@author Rick Walker
 * 	@version 0.1
 * 	@since 11/14/2015
 */
public abstract class CustomFrame extends JFrame {
	private String coordinatesPath = GlobalConstants.USRDIR;
	private String coordinatesFile = "_coordinates.ser";
	private String coordinatesFilePath = coordinatesPath + coordinatesFile;
	
	/**
	 * Overloaded CustomPanel argument constructor
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
	 * Overloaded JComponent argument constructor
	 * 
	 * @param controls
	 *            The child JComponent that provides the GUI controls
	 */
	public CustomFrame(JComponent controls) {
		super();
		setIconImage(wi);
		new BorderLayout();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
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
	 * Overloaded empty constructor
	 */
	public CustomFrame() {
		super();
		setIconImage(wi);
		new BorderLayout();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
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
	 * Internal method calls ObjectSerializer
	 */
	private void saveLocation() {
		ObjectSerializer.serialize(new CustomFrameCoordinates(this.getX(), this.getY()),"_coordinates");	
	}

	/** Internal method that checks for and creates the _coordinates.ser file.
	 *  @throws NullPointerException */
	private void setLocation() throws NullPointerException {	
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
		saveLocation();
		this.dispose();
		System.exit(0);
	}

	/** This variable contains the path to the window's icon image. */
	private final static java.net.URL path = (CustomFrame.class.getResource("/appicon.gif") == null)
			? CustomFrame.class.getResource("/medium.gif") : CustomFrame.class.getResource("/appicon.gif");
	
	/** @see java.awt.Toolkit */
	private final static Image wi = Toolkit.getDefaultToolkit().createImage(path);
	
	@Override
	public String toString() {
		return "Abstract Custom Frame";
	}
}