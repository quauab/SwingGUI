package com.gmail.ichglauben.swinggui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.gmail.ichglauben.serialmanager.core.deserializer.ObjectDeserializer;
import com.gmail.ichglauben.serialmanager.core.serializer.ObjectSerializer;
import com.gmail.ichglauben.swinggui.core.frames.coordinates.CustomFrameCoordinates;
import com.gmail.ichglauben.swinggui.core.gui.MyFrame;
import com.gmail.ichglauben.swinggui.core.gui.MyPanel;

public class App {
	public static void run1() {
		ObjectSerializer.serialize(new CustomFrameCoordinates(34, 443), "_coordinates_test");

		CustomFrameCoordinates cfc = ((CustomFrameCoordinates) ObjectDeserializer.deserialize("_coordinates_test.ser"));

		System.out.println(cfc.x_coord + " " + cfc.y_coord);
	}

	public static void run2() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final JComponent controls = new MyPanel();
				controls.setLayout(new BorderLayout());
				controls.setPreferredSize(new Dimension(300, 444));

				final MyFrame frame = new MyFrame(controls);

				final JLabel lblHead = new JLabel("This is the picture");
				JButton btnEnd = new JButton("End Prog");
				JPanel pnlHead = new JPanel();
				JPanel pnlButton = new JPanel();

				controls.add(pnlHead, BorderLayout.NORTH);
				controls.add(pnlButton, BorderLayout.SOUTH);

				pnlHead.add(lblHead);
				pnlButton.add(btnEnd);

				btnEnd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						try {
							Thread.currentThread().sleep(3000);
						} catch (InterruptedException ir) {

						}

						frame.exitProg();
					}
				});
				btnEnd.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent me) {
						lblHead.setText("Program Ending");

						controls.updateUI();
					}
				});
			}
		});
	}

	public static void run3() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final MyPanel controls = new MyPanel();
				controls.setLayout(new BorderLayout());
				controls.setPreferredSize(new Dimension(300, 444));

				final MyFrame frame = new MyFrame(controls);

				final JLabel lblHead = new JLabel("This is the picture");
				JButton btnEnd = new JButton("End Prog");
				JPanel pnlHead = new JPanel();
				JPanel pnlButton = new JPanel();

				controls.add(pnlHead, BorderLayout.NORTH);
				controls.add(pnlButton, BorderLayout.SOUTH);

				pnlHead.add(lblHead);
				pnlButton.add(btnEnd);

				btnEnd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						try {
							Thread.currentThread().sleep(3000);
						} catch (InterruptedException ir) {

						}

						frame.exitProg();
					}
				});
				btnEnd.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent me) {
						lblHead.setText("Program Ending");
						controls.updateUI();
					}
				});
			}
		});
	}

	public static void main(String[] args) {
		run3();
	}
}
