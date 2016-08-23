package com.gmail.ichglauben.swinggui.core.frametests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.Test;

import com.gmail.ichglauben.swinggui.core.gui.MyFrame;

public class FrameTests {
	MyFrame mf;
	
	@Test
	public void testFrameStartStop() {
		assertTrue("Frame not null", null == mf);
		
		mf = new MyFrame();
		
		assertTrue("Frame is null", null != mf);
		assertFalse("Frame not null", null == mf);
		
		mf = null;
		
		assertTrue("Frame not null", null == mf);
	}
	
	@Test
	public void testFrameVisibility() {
		mf = new MyFrame();
		
		assertTrue("Frame not visible", mf.isVisible());
		assertTrue("Frame is null", null != mf);
		
		mf.setVisible(false);
		
		assertTrue("Frame visible", mf.isVisible() == false);
		
		mf.setVisible(true);
		
		assertTrue("Frame not visible", mf.isVisible());
				
		mf = null;	
		
		assertTrue("Frame not null", null == mf);
	}

}
