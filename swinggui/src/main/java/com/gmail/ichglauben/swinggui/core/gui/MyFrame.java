package com.gmail.ichglauben.swinggui.core.gui;

import javax.swing.JComponent;

import com.gmail.ichglauben.swinggui.core.frames.CustomFrame;

public class MyFrame extends CustomFrame {
	public MyFrame() {
		super();
	}
	
	public MyFrame(MyPanel mp) {
		super(mp);
		mp.setFrame(this);
	}
	
	public MyFrame(JComponent jc) {
		super(jc);
	}
	
	public void exitProg() {
		super.exitProg();
	}

	public void setTitle(String title) {
		super.setTitle(title);
	}
	
	public String toString() { return "Custom JFrame"; }
}
