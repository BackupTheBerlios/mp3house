/*
 * Created on Feb 17, 2004 7:57:54 PM
 * SongsTableModel.java
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

import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.table.AbstractTableModel;

import org.mp3house.gg.core.GGSong;


/**
 * Songs Table Model
 */
public class SongsTableModel extends AbstractTableModel {
	
	final String[] columnNames = {"SA", "Song ID", "Title", "Status"};
	private Vector data;
	private Class columnClasses[] = {Boolean.class, String.class,
		String.class, String.class};
	private HashMap songslist = new HashMap();
	private final static Logger log = Logger.getLogger("org.mp3house.gg.ui.SongsTableModel");

	/**
	 * Constructer
	 *
	 */
	public SongsTableModel() {
		data = new Vector();
	}
    
	/**
	 * Gets the Columns name
	 * @return column name 
	 */
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	/**
	 * Gets the Columns Class
	 * @return column class
	 */
	public Class getColumnClass(int c) {
		return columnClasses[c];
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() {
		return data.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() {
		return columnNames.length;
	}

	public boolean isCellEditable(int r, int c) {
		if(getColumnClass(c) == Boolean.class){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int arg0, int arg1) {
		return ( (Object[])data.elementAt(arg0))[arg1];
	}
	

	public void setValueAt(Object value, int row, int col) {
		if(((Object[])data.elementAt(0))[col] instanceof Integer
			&& !(value instanceof Integer)) {
			try {
				((Object[])data.elementAt(row))[col] = new Integer(value.toString());
				fireTableCellUpdated(row,col);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		else {
			((Object[])data.elementAt(row))[col] = value;
			//log.finest("Updating - "+"row:"+row+"col:"+col);
			fireTableCellUpdated(row, col);
		}
	}
	
	/**
	 * Adds an GGSong object
	 * 
	 * @param ggsong GGSong
	 */	
	public void addRow(GGSong ggsong){
		Object[] obj = {new Boolean(false),String.valueOf(ggsong.getId()),
			ggsong.getName(), ""};
		data.addElement(obj);
		songslist.put(String.valueOf(ggsong.getId()), ggsong);
		int size = getRowCount();
		fireTableRowsInserted(size-1,size-1);
	}
	
	public GGSong getGGSong(String id){
		return (GGSong)songslist.get(id);
	}
    
	public void removeRow(int rowNo){
		data.remove(rowNo);
		songslist.remove((((Object[])data.elementAt(rowNo))[1]).toString());
		fireTableRowsDeleted(rowNo,rowNo);
	}
	
	public void removeAll(){
		int dataSize = data.size();
		data.removeAllElements();
		songslist.clear();
		for(int i=0; i<data.size(); i++){
			fireTableRowsDeleted(i,i);
		}
	}
	
	/**
	 * Select all the songs in the model
	 *
	 */
	public void selectAllSongs(){
		for(int i=0; i<data.size(); i++){
			((Object[])data.elementAt(i))[0] = Boolean.TRUE;
			fireTableCellUpdated(i,0);
		}
	}
	
	/**
	 * Deselects All songs from the model
	 *
	 */
	public void deselectAllSongs(){
		for(int i=0; i<data.size(); i++){
			((Object[])data.elementAt(i))[0] = Boolean.FALSE;
			fireTableCellUpdated(i,0);
		}		
	}
	
	/**
	 * Gets the count of the selected songs
	 * @return count no of songs selected
	 */
	public int getSelectedSongsCount(){
		int count = 0;
		for(int i=0; i<data.size(); i++){
			if(((Object[])data.elementAt(i))[0] == Boolean.TRUE){
				count++;
			}
		}
		return count;
	}
	
	public GGSong[] getSelectedSongs(){
		int scount = getSelectedSongsCount();
		GGSong[] selectedSongs = new GGSong[scount];
		int j=-1;
		if(scount>=1){
			for(int i=0; i<data.size(); i++){
				if(((Object[])data.elementAt(i))[0] == Boolean.TRUE){
					selectedSongs[++j] = getGGSong(((Object[])data.elementAt(i))[1].toString());
				}
			}			
		}
		return selectedSongs;
	}
	
	public void setSongDownloadStatus(long sid, String dstatus){
		for(int i=0; i<data.size(); i++){
			if( new Integer(((Object[])data.elementAt(i))[1].toString()).longValue() == sid){
				((Object[])data.elementAt(i))[3] = dstatus;
				fireTableCellUpdated(i,3);
				break;
			}
		}		
	}

}
