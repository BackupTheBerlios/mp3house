/*
 * Created on Feb 17, 2004 6:49:27 PM
 * GGTest.java
 * 
 * Copyright (C) 2003  MP3House Development Group
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 */
package org.mp3house.gg.bin;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.mp3house.gg.ui.GooseGet;

/**
 *
 */
public class GGRun {

	public static void main(String[] args) {
		
		// Get the System Look and Feel
		try {
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		// Instantiate the Gooseget main frame
		GooseGet ggget = new GooseGet();
		ggget.setSize(900, 600);
		
		// Keep in the middle of the Screen
		Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension swinSize = ggget.getSize();
		swinSize.height = ((swinSize.height > screenSize1.height) ?
			screenSize1.height : swinSize.height);
		swinSize.width = ((swinSize.width > screenSize1.width) ? 
			screenSize1.width : swinSize.width);
		ggget.setLocation((screenSize1.width - swinSize.width) / 2,
			(screenSize1.height - swinSize.height) / 2);
		ggget.setVisible(true);
		
	}
}
