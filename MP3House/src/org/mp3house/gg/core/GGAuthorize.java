/*
 * Created on Feb 15, 2004 3:58:36 PM
 * GGAuthorize.java
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

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Main Class to Get Authorized by the server
 */
public class GGAuthorize {
	
	private static final Logger log = 
		Logger.getLogger("org.mp3house.gg.core.GGAuthorize");
	
	private String[] cookies = new String[2];
	
	private boolean authorized = false;
	
	/**
	 * Constructor
	 *
	 */
	public GGAuthorize(){
		authorize();
	}
	
	/**
	 * Tells whether the the user is Authorized or not
	 * @return true if authorized else false
	 */
	public boolean isAuthorized(){
		return authorized;
	}
	
	/**
	 * Gets the Cookies if the User is Authorized, else
	 * throws exception
	 * @return cookies Array of Cookies gathered
	 * @throws GGException throws Unable to Authorize Exception
	 */
	public String[] getCookies() throws GGException{
		if(!authorized){
			throw new GGException(GGErrorCodes.GG_UNABLE_TO_AUTH);
		}
		return cookies;
	}
	
	/**
	 * Private method to do the authorization.
	 *
	 */
	private void authorize(){
		
		URL authURL = null;
		URL homeURL = null;
		URLConnection homeCon = null;
		
		String loginPage = GG.GG_LOGIN+"?ACCOUNT="+GG.GG_UID
			+"&PASSWORD="+GG.GG_PASS;
		String cookieString = "";
		String cookieString1 = "";
		
		try{
			homeURL = new URL(GG.GG_HOME);
			homeCon = homeURL.openConnection();
			
			// Look At the headers
			Map headerMap = homeCon.getHeaderFields();
			
			// Look for the Cookie
			if(headerMap.containsKey("Set-Cookie")){
				
				// this gets the exact value of the header
				// otherwise gets some formatted string
				cookieString = homeCon.getHeaderField("Set-Cookie");
				//log.finest("cookie1: "+cookieString);
				
				authURL = new URL(loginPage);
				HttpURLConnection.setFollowRedirects(false);
				HttpURLConnection loginCon = (HttpURLConnection) authURL.openConnection();
				
				// doOutput must be set before connecting
				loginCon.setAllowUserInteraction(true);
				loginCon.setUseCaches(false);
				loginCon.setDoOutput(true);
				loginCon.setRequestProperty("Cookie", cookieString);
				loginCon.connect();
				
				// Look At the headers
				Map headerMap1 = loginCon.getHeaderFields();
				
				cookieString1 = loginCon.getHeaderField("Set-Cookie");
				//log.finest("cookie2: "+cookieString1);
				if(!Pattern.matches(".*\\."+GG.GG_UID+"\\.\\d+.*", cookieString1)){
					return;
				}
				String location = loginCon.getHeaderField("Location");
				URL gotURL = new URL(location);
				HttpURLConnection gotCon = (HttpURLConnection) gotURL.openConnection();
				// doOutput must be set before connecting
				gotCon.setAllowUserInteraction(true);
				gotCon.setUseCaches(false);
				gotCon.setDoOutput(true);
				gotCon.setRequestProperty("Cookie", cookieString);
				gotCon.setRequestProperty("Cookie", cookieString1);
				
				gotCon.connect();
				
				// Got the Cookies
				cookies[0] = cookieString;
				cookies[1] = cookieString1;
				
			}else{
				log.info("Unable to find the Cookie");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		authorized = true;
	}
}
