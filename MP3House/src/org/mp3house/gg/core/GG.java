/*
 * Created on Feb 15, 2004 4:01:35 PM
 * GG.java
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
package org.mp3house.gg.core;

import java.util.Properties;

/**
 * Main Goose Get Class
 */
public class GG {
	
	public static String[] COOKIES;
	public static String GG_HOME, GG_LOGIN, GG_DIR, GG_UID, GG_PASS;
	public static int GG_SLEEP;
	
	public static String[] NOD_POS = {"1", "2", "3", "4", "5", "10"};
	public static int NOD;
	
	public static String[] NOR_POS = {"1", "2", "3", "4", "5", "10", 
			"20", "30", "50", "100", "500"};
	public static int NOR;
	
	/**
	 * Constructor
	 *
	 */
	static {
		
		// Load Global Variables
		Properties prop = Util.getMainProperties();
		GG_HOME = prop.getProperty("gg.home");
		GG_LOGIN = prop.getProperty("gg.login");
		GG_DIR = prop.getProperty("gg.dir.save");
		GG_UID = prop.getProperty("gg.username");
		GG_PASS = prop.getProperty("gg.password");
		GG_SLEEP = Integer.parseInt(prop.getProperty("gg.sleep"));
		NOD = Integer.parseInt(prop.getProperty("gg.nod"));
		NOR = Integer.parseInt(prop.getProperty("gg.nor"));

		//COOKIES = GGAuthorize.authorize();
		
		//GGCategory cat = new GGCategory("http://as04.coolgoose.com/go/music?c=10258");
		//cat.downloadAllSongs();
		
	}
	
}
