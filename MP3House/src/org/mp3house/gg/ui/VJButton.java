/*
 * Created on Oct 19, 2003 5:24:17 PM
 * VJButton.java
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
package org.mp3house.gg.ui;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/**
 * A simple extended Button
 */
public class VJButton extends JButton{
	
	public VJButton(String str){
		super(str);
		this.setPreferredSize(new Dimension(100, 20));
		this.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
	}
	
	public VJButton(Icon icon){
		super(icon);
		this.setPreferredSize(new Dimension(100, 20));
		this.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		
	}
	
	public VJButton(String str, Icon icon){
		super(str, icon);
		this.setPreferredSize(new Dimension(100, 20));
		this.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		
	}
	
}
