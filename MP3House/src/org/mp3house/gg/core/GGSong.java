/*
 * Created on Feb 16, 2004 7:57:20 PM
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

/**
 * Represent a GG Song
 */
public class GGSong {
	
	private String name;
	private long id;
	private String urlToDownload;
	private long size;
	
	/**
	 * Constructor
	 * @param id songid
	 */
	public GGSong(long id){
		this.id = id;
	}
	
	/**
	 * Constructor
	 * 
	 * @param id song id
	 * @param name song name
	 */
	public GGSong(long id, String name){
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Constructor
	 * 
	 * @param id songid
	 * @param name songname
	 * @param size song size
	 */
	public GGSong(long id, String name, long size){
		this.id = id;
		this.name = name;
		this.size = size;
	}
	
	/**
	 * Returns the Song Identifier
	 * 
	 * @return id song id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Returns Song name
	 * 
	 * @return name song name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Returns the size
	 * 
	 * @return size song size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * Returns the URL to get the song
	 * 
	 * @return urlToDownload
	 */
	public String getUrlToDownload() {
		urlToDownload  = "http://as04.coolgoose.com/go/song?id="+id+"&get=bin";
		return urlToDownload;
	}

	/**
	 * Sets the Song ID
	 * @param l songid
	 */
	public void setId(long l) {
		id = l;
	}

	/**
	 * Sets the Name of the Song
	 * 
	 * @param string song name
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * 
	 * Sets the size of the song
	 * 
	 * @param l song size
	 */
	public void setSize(long l) {
		size = l;
	}

}
