/*
 * Created on Feb 15, 2004 4:05:36 PM
 * Util.java
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * A Samll Utility Class
 */
public class Util {
	
	/**
	 * Gets back the main Properties Object
	 * 
	 * @return prop Main Properties Object
	 */
	public static Properties getMainProperties(){
		Properties prop = new Properties();
		FileInputStream propFile = null;
		try {
			propFile = new FileInputStream("conf/user.properties");
			prop.load(propFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static void saveProperties(){
		Properties prop = getMainProperties();
		prop.setProperty("gg.username", GG.GG_UID);
		prop.setProperty("gg.password", GG.GG_PASS);
		prop.setProperty("gg.dir.save", GG.GG_DIR);
		prop.setProperty("gg.nod", String.valueOf(GG.NOD));
		prop.setProperty("gg.nor", String.valueOf(GG.NOR));
		try {
			prop.store(new FileOutputStream("conf/user.properties"), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkURL(String urlStr) throws GGException{
		URL url;
		try {
			url = new URL(urlStr);
		} catch (MalformedURLException e) {
			throw new GGException(GGErrorCodes.GG_URL_MALFORMED);
		}
		URLConnection urlConnection = null;
		try {
			urlConnection = url.openConnection();
		} catch (IOException e1) {
			throw new GGException(GGErrorCodes.GG_URL_UNABLE_TOOPEN_CONNECTION);
		}
	}
	
}
