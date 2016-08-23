package com.gmail.ichglauben.swinggui.core.panels;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Toolkit;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This class is a customized JPanel.
 * 
 * @author Rick Walker
 * @version 0.1
 * @since 3-12-2014
 * @see javax.swing.JPanel
 * @see java.awt.BorderLayout
 */
public abstract class CustomPanel extends JPanel {
	/**
	 * Single constructor, this class overrides the default JPanel layout in
	 * favour of BorderLayout.
	 */
	public CustomPanel() {
		super();
		this.setLayout(new BorderLayout());
	}

	/**
	 * Internal method updates the main panel's border title.
	 * 
	 * @param title
	 *            The String for the border title
	 */
	public void updateBorderTitle(String title) {
		setBorder(BorderFactory.createTitledBorder(title));
	}

	/**
	 * Internal method returns a custom JScrollPane.
	 * 
	 * @return JScrollPane
	 * @param component
	 *            The JComponent to add
	 */
	protected JScrollPane createComponent(JComponent component) {
		JScrollPane scroll = new JScrollPane(component);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension((this.getWidth()/2 + (this.getWidth()/4)), (this.getHeight()/3)));
		scroll.setMinimumSize(new Dimension(10, 10));
		return scroll;
	}

	@Override
	public String toString() {
		return "Abstract Custom JPanel";
	}
}