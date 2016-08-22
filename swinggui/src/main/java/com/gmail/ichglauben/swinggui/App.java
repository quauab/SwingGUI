package com.gmail.ichglauben.swinggui;

import javax.swing.SwingUtilities;

import com.gmail.ichglauben.serialmanager.core.deserializer.ObjectDeserializer;
import com.gmail.ichglauben.serialmanager.core.serializer.ObjectSerializer;
import com.gmail.ichglauben.swinggui.core.frames.coordinates.CustomFrameCoordinates;
import com.gmail.ichglauben.swinggui.core.gui.MyFrame;
import com.gmail.ichglauben.swinggui.core.gui.MyPanel;

public class App {
	public static void run1() {
		ObjectSerializer.serialize(new CustomFrameCoordinates(34,443), "_coordinates_test");
		
		CustomFrameCoordinates cfc = ((CustomFrameCoordinates)ObjectDeserializer.deserialize("_coordinates_test.ser"));
		
		System.out.println(cfc.x_coord + " " + cfc.y_coord);
	}
	
	public static void run2() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MyFrame(new MyPanel());
			}
		});
	}
	
	public static void main(String[] args) {
		run2();
	}
}
