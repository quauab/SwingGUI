package com.gmail.ichglauben.swinggui.core.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.gmail.ichglauben.swinggui.core.frames.CustomFrame;
import com.gmail.ichglauben.swinggui.core.gui.MyFrame;
/**
 * <h2>Custom JPanel</h2>
 * <div>
 * 		<b>Class Dependencies:</b>&nbsp; none<br>
 * 		<b>Description:</b>&nbsp; Extends JPanel and favors BorderLayout over the default FlowLayout.
 * </div>
 * 	@author Rick Walker
 *  @version 0.1
 *  @since 3-12-2014
 *  @see javax.swing.JPanel
 *  @see java.awt.BorderLayout
 */
public abstract class CustomPanel extends JPanel {
	MyFrame frame;
	
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

	protected void exitProg() {
		try {
			frame.exitProg();
		} catch (NullPointerException npe) {
			throw new NullPointerException("frame is null");
		}
	}
	
	/**Setters*/
	
	protected void setFrame(MyFrame myFrame) {
		this.frame = myFrame;
	}
	
	@Override
	public String toString() {
		return "Abstract Custom JPanel";
	}
}