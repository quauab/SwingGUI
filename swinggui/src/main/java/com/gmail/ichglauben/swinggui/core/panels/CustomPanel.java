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
 * <h2>Custom JPanel</h2>
 * <div>
 * 		<b>Class Dependencies:</b>&nbsp; none
 * 		<b>Description:</b>&nbsp; Extends JPanel and favors BorderLayout over the default FlowLayout.
 * </div>
 * <ul> 
 * 	<li>@author Rick Walker</li>
 *  <li>@version 0.1</li>
 *  <li>@since 3-12-2014</li>
 *  <li>@see javax.swing.JPanel</li>
 *  <li>@see java.awt.BorderLayout</li>
 * </ul>
 */
public abstract class CustomPanel extends JPanel {
	/**
	 * Single constructor, this class overrides JPanel's default layout in
	 * favor of BorderLayout.
	 */
	public CustomPanel() {
		super();
		this.setLayout(new BorderLayout());
	}

	/**
	 * Internal method updates the this panel's border title.
	 * 
	 * @param title
	 *            The String for the border title
	 */
	public void updateBorderTitle(String title) {
		setBorder(BorderFactory.createTitledBorder(title));
	}

	/**
	 * Internal method returns a JscrollPane populated with the component parameter.
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