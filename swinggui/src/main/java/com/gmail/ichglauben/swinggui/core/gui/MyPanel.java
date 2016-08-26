package com.gmail.ichglauben.swinggui.core.gui;

import com.gmail.ichglauben.swinggui.core.panels.CustomPanel;

public class MyPanel extends CustomPanel {
	public MyPanel() {
		super();
	}
	
	public void setFrame(MyFrame frame) {
		super.setFrame(frame);
	}
	
	public void exitProg() {
		super.exitProg();
	}
	
	public void setTitle(String title) {
		super.setTitle(title);
	}
	
	public String toString() { return "Custom JPanel"; }
}
