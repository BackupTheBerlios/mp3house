/*
 * Created on Feb 16, 2004 7:57:47 PM
 * GGCategory.java
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

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mp3house.gg.ui.SongsTableModel;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 * Represents the Song Category.
 * It is a collection of GGSongs
 */
public class GGCategory {
	
	/**
	 * Represents the category id
	 */
	private long id;
	
	/**
	 * Represents the Category Link
	 */
	private String categoryLink;
	
	/**
	 * ArrayList of all the GGSongs found in this category
	 */
	private ArrayList ggsongs = new ArrayList();
	
	private SongsTableModel stm = null;
	
	private static final Logger log = Logger.getLogger("org.mp3house.gg.core.GGCategory");
	
	
	/**
	 * Constructor
	 * 
	 * @param url link to the category start page.
	 */
	public GGCategory(String url){
		categoryLink = url;
		walkThrough();
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param url link to the category
	 * @param stm SongsTableModel
	 */
	public GGCategory(String url, SongsTableModel stm){
		categoryLink = url;
		this.stm = stm;
		walkThrough();
		
	}
	
	/**
	 * Gets all the GGSong objects of this category
	 * 
	 * @return GGSong[] Array of GGSongs
	 */
	public GGSong[] getSongs(){
		return (GGSong[])ggsongs.toArray(new GGSong[ggsongs.size()]);
	}
	
	/**
	 * Gets the count of songs found in this category
	 * 
	 * @return count no of songs found in this category
	 */
	public int getSongCount(){
		return ggsongs.size();
	}
	
	/**
	 * Downloads the song represented by GGSong
	 * 
	 * @param ggsong GGSong
	 */
	public void downloadSong(GGSong ggsong){
		GGSongRetriever.getSong(ggsong);	
	}
	
	/**
	 * Downloads all the songs found in this category
	 *
	 */
	public void downloadAllSongs(){
		for(int i=0; i<ggsongs.size(); i++){
			GGSongRetriever.getSong(((GGSong)ggsongs.get(i)));
		}
	}
	
	/**
	 * Internal WalkThrough method which parsers the given
	 * url and created the GGSong Objects.
	 *
	 */
	private void walkThrough(){
		boolean followNext = false;
		boolean hasNext = true;
		String nextLink = categoryLink;
		
		NodeFilter filter = new NodeClassFilter (LinkTag.class);
		Parser parser = null;
		NodeList list = null;
		Pattern pat = null;
		Matcher mat = null;
		
		int skip = 0;
		
		while(hasNext){
			try {
				parser = new Parser (nextLink);
				list = parser.extractAllNodesThatMatch (filter);
				hasNext = false;
				for (int i = 0; i < list.size (); i++){
					Node linkNode = list.elementAt(i);
					String aLink = linkNode.getText();				
					if(Pattern.matches(".*http://web.music.coolgoose.com/music/song.php.*", aLink)){
						pat = Pattern.compile(".*(http://web.music.coolgoose.com/music/song.php\\?id=(\\d+))\".*");
						mat = pat.matcher(aLink);
						mat.find();
						String dLink = mat.group(1);
						GGSong ggsong = new GGSong(new Integer(mat.group(2)).longValue());
						
						//links.add(dLink);
						//songIDs.add(mat.group(2));
						ggsong.setName(linkNode.getChildren()
							.elementAt(0).getText());
						ggsongs.add(ggsong);
						if(stm!=null){
							stm.addRow(ggsong);
						}
					}else if(Pattern.matches(".*skip.*", aLink)){
						
						//log.finest(aLink);
						pat = Pattern.compile("\"(.*skip=(\\d+))\"");
						mat = pat.matcher(aLink);
						mat.find();
						if(skip+1 == Integer.parseInt(mat.group(2))){
							hasNext = true;
							nextLink = "http://as04.coolgoose.com"+mat.group(1);
							log.finest(nextLink);
						}
					}
				}
			}catch (ParserException e){
				e.printStackTrace ();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			skip++;
		}
	}
	
}
