/*
 * Created on Feb 15, 2004 7:00:22 PM
 * GGSong.java
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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Gets the song and saves in the right place
 */
public class GGSongRetriever {
	
	private static final Logger log = Logger.getLogger("org.gg.GGSongRetriever");
	
	public static boolean getSong(GGSong ggsong){
		
		URL furl;
		String toRequest = ggsong.getUrlToDownload();
		String[] cookies = GG.COOKIES;
				
		//log.info("Request : " + toRequest);
		try {
			furl = new URL(toRequest);
			HttpURLConnection.setFollowRedirects(true);
			HttpURLConnection furlConnection = 
				(HttpURLConnection) furl.openConnection();
								
			
			// doOutput must be set before connecting
			furlConnection.setAllowUserInteraction(true);
			furlConnection.setUseCaches(false);
			furlConnection.setDoOutput(true);
			furlConnection.setRequestProperty("Cookie", cookies[0]);
			furlConnection.setRequestProperty("Cookie", cookies[1]);
			furlConnection.connect();
			
			
			// Look At the headers
			Map headerMap1 = furlConnection.getHeaderFields();

			BufferedReader in = new BufferedReader(
				new InputStreamReader(furlConnection.getInputStream()));
			String inputLine;
			String downURL = "";
			while ((inputLine = in.readLine()) != null){
				if(Pattern.matches(".*URL=.*", inputLine)){
					Pattern pat = Pattern.compile(".*URL=(.*)\"");
					Matcher mat = pat.matcher(inputLine);
					mat.find();
					downURL = mat.group(1);
					break;
				}
			}
			in.close();
			
			furl = new URL(downURL);
			furlConnection = 
				(HttpURLConnection) furl.openConnection();
			
			
			// doOutput must be set before connecting
			furlConnection.setAllowUserInteraction(true);
			furlConnection.setUseCaches(false);
			furlConnection.setDoOutput(true);
			furlConnection.setRequestProperty("Cookie", GG.COOKIES[0]);
			furlConnection.setRequestProperty("Cookie", GG.COOKIES[1]);
			furlConnection.connect();
			int responseCode = furlConnection.getResponseCode();
			if(responseCode == 503){
				return false;
			}else{
				log.finest("RC: "+ggsong.getId()+" - "+responseCode);
			}
			
			Thread.sleep(GG.GG_SLEEP);
			String songName = ggsong.getName();
			
			// Get the Stream from URL
			String tmpFileName = GG.GG_DIR+"/"+songName+".mp3";
			File tmpFile = new File(tmpFileName); 
			InputStream inS = furlConnection.getInputStream();
			log.finest("CL: "+ggsong.getId()+" - "
					+furlConnection.getContentLength());
			
			BufferedInputStream bis = new BufferedInputStream(inS);
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tmpFile));
			byte[] buff = new byte[2048];
			int bytesRead;

			// Simple read/write loop.
			while(-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			
			bis.close();
			bos.close();
			
			// Check the Size of the Downloaded file
			if(tmpFile.length() != furlConnection.getContentLength()){
				log.finest("FS: "+ggsong.getId()+" - "
						+furlConnection.getContentLength()
						+"/"+tmpFile.length());
				return false;
			}
			
			log.info(tmpFileName+" dowloaded");
			
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		} catch (InterruptedException e) {
			return false;
		}
		return true;
	}
}
