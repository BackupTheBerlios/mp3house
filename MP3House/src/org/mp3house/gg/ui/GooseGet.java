/*
 * Created on Feb 16, 2004 10:35:27 PM
 * GooseGet.java
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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.util.logging.Logger;

import javax.help.CSH;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.mp3house.gg.core.GG;
import org.mp3house.gg.core.GGAuthorize;
import org.mp3house.gg.core.GGCategory;
import org.mp3house.gg.core.GGException;
import org.mp3house.gg.core.GGSong;
import org.mp3house.gg.core.GGSongRetriever;
import org.mp3house.gg.core.SimpleQueue;
import org.mp3house.gg.core.Util;

/**
 * Main Window for GooseGet
 */
public class GooseGet extends JFrame{
	
	private SongsTableModel stm;
	private TableSorter stmSorter;
	private JPasswordField password;
	private JTextField catURL, dirtosave, userName;
	private VJButton download;
	private JComboBox nofd, nor;
	private File file;
	private JLabel songsFound, songsDownloaded, songsDownloading, status;
	private static final Logger log = Logger.getLogger("org.mp3house.gg.ui.GooseGet");
	private Downloader downLoader;
	private boolean runThread = true;
	
	public GooseGet(){
		super("GooseGet v1.0");
		stm = new SongsTableModel();
		GG gg = new GG();
		downLoader = new Downloader();
		initGUI();
	}
	
	private void initGUI(){
		Container cpane = this.getContentPane();
		
		// Form Pane
		// Which contains the main input form
		JPanel formPane = new JPanel(false);

		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		formPane.setLayout(gl);

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 0.5;
		gc.weighty = 0;
		
		// Username
		JLabel usernameLabel = new JLabel("Username");
		gc.gridx = 0;
		gc.gridy = 0;
		gl.setConstraints(usernameLabel,gc);
		formPane.add(usernameLabel);
		
		userName = new JTextField(GG.GG_UID, 12);
		userName.setName("userName");
		gc.gridx = 0;
		gc.gridy = 1;
		gl.setConstraints(userName,gc);
		formPane.add(userName);		
		
		// Password
		JLabel passwordLabel = new JLabel("Password");
		gc.gridx = 0;
		gc.gridy = 2;
		gl.setConstraints(passwordLabel,gc);
		formPane.add(passwordLabel);
		
		password = new JPasswordField(GG.GG_PASS, 12);
		password.setName("password");
		gc.gridx = 0;
		gc.gridy = 3;
		gc.insets.bottom = 50;
		gl.setConstraints(password,gc);
		formPane.add(password);
		
		gc.insets.bottom = 0;
		// Category URL
		JLabel catLabel = new JLabel("Category URL");
		gc.gridx = 0;
		gc.gridy = 4;
		gl.setConstraints(catLabel,gc);
		formPane.add(catLabel);
		
		catURL = new JTextField(20);
		catURL.setName("category");
		gc.gridx = 0;
		gc.gridy = 5;
		gl.setConstraints(catURL,gc);
		formPane.add(catURL);
		
		// Directory to save songs
		JLabel dirLabel = new JLabel("Directory to save songs");
		gc.gridx = 0;
		gc.gridy = 6;
		gl.setConstraints(dirLabel,gc);
		formPane.add(dirLabel);
		
		dirtosave = new JTextField(GG.GG_DIR, 20);
		dirtosave.setName("directory");
		gc.gridx = 0;
		gc.gridy = 7;
		gl.setConstraints(dirtosave,gc);
		formPane.add(dirtosave);
		
		VJButton selectButton = new VJButton("select");
		gc.gridx = 0;
		gc.gridy = 8;
		gl.setConstraints(selectButton, gc);
		formPane.add(selectButton);
		
		// Show Songs
		VJButton showSongs = new VJButton("Show Songs");
		gc.gridx = 0;
		gc.gridy = 9;
		gc.insets.top = 50;
		gl.setConstraints(showSongs, gc);
		formPane.add(showSongs);
		
		
		
		
		// Songs Pane = navigational pane + songs table pane
		// Which shows the songs from a category in a table
		JPanel songsPane = new JPanel(new BorderLayout());
		
		// Navigational Panel
		JPanel navPane = new JPanel();
		
		VJButton selectAll = new VJButton("Select All");
		navPane.add(selectAll);
		VJButton deselectAll = new VJButton("Deselect All");
		navPane.add(deselectAll);
		download = new VJButton("Download");
		download.setActionCommand("download");
		navPane.add(download);
		download.setEnabled(false);
		VJButton helpButton = new VJButton("Help");
		navPane.add(helpButton);
		
		navPane.add(new JLabel("Threads"));
		nofd = new JComboBox(GG.NOD_POS);
		nofd.setSelectedItem(String.valueOf(GG.NOD));
		navPane.add(nofd);
		
		navPane.add(new JLabel("Retry"));
		nor = new JComboBox(GG.NOR_POS);
		nor.setSelectedItem(String.valueOf(GG.NOR));
		navPane.add(nor);		
		
		// Songs table Panel
		JPanel songsTablePane = new JPanel(new BorderLayout());
		
		stmSorter = new TableSorter(stm);
		JTable songsTable = new JTable(stmSorter);
		songsTable.getColumnModel().getColumn(0).setMaxWidth(25);
		songsTable.getColumnModel().getColumn(1).setMaxWidth(150);
		songsTable.getColumnModel().getColumn(3).setMinWidth(170);
		songsTable.getColumnModel().getColumn(3).setMaxWidth(210);
		
		JScrollPane songsScrollPane = new JScrollPane(songsTable);
		songsScrollPane.setHorizontalScrollBarPolicy(
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		songsTablePane.add(songsScrollPane, BorderLayout.CENTER);
		
		
		// Info Pane 
		// Gives the status information
		JPanel infoPane = new JPanel(new BorderLayout());
		infoPane.setPreferredSize(new Dimension(100, 20));
		songsFound = new JLabel("");
		status = new JLabel("");
		
		infoPane.add(songsFound);
		infoPane.add(status, BorderLayout.EAST);
		
		// Add to songs pane
		songsPane.add(navPane, BorderLayout.NORTH);
		songsPane.add(songsTablePane, BorderLayout.CENTER);
		songsPane.add(infoPane, BorderLayout.SOUTH);
		
		
		
		// Add the panes to the main container
		JSplitPane mpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
			formPane, songsPane);
		mpane.setOneTouchExpandable(true);
		mpane.setDividerLocation(180);
		mpane.setDividerSize(6);
		
		//mpane.add(songsPane);
		cpane.add(mpane);
		
		// Set the basic Frame closing properties
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		// Window Closing Event
        addWindowListener(
                new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent evt) {
                        exitForm(evt);
                    }
                });
		
		
		// Action Listeners
		showSongs.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(catURL == null || catURL.getText().equals("")){
						JOptionPane.showMessageDialog(null, 
						"Please give the URL to the Category",
						"GooseGet Error",
						JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						Util.checkURL(catURL.getText());
					} catch (GGException e1) {
						JOptionPane.showMessageDialog(null, 
						e1.getMessage(),
						"GooseGet Error",
						JOptionPane.ERROR_MESSAGE);
						return;
					}
					stm.removeAll();
					Thread adderThread = new Thread(){
						public void run(){
							
							// Pre setup
							download.setEnabled(false);
							songsFound.setText("");
							status.setText("Working...");
							
							GGCategory cat = new GGCategory(catURL.getText(), stm);
							
							// Post setup
							songsFound.setText("Songs Found: "+cat.getSongCount());
							status.setText("");
							download.setEnabled(true);
						}
					};
					adderThread.start();
				}
			});
		
		selectButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						final JFileChooser fc = new JFileChooser();
						fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						int retval = fc.showOpenDialog(GooseGet.this);
						if(retval == JFileChooser.APPROVE_OPTION){
							file = fc.getSelectedFile();
							dirtosave.setText(file.getAbsolutePath());
						}
					}
				});
		
		// Select all the songs in the table
		selectAll.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						stm.selectAllSongs();
					}
				});
		
		// deselect all the songs from the table
		deselectAll.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						stm.deselectAllSongs();
					}
				});
		
		// GooseGet Help Integration
		String hsName = "jhelpset.hs";
		HelpSet hs = null;
		HelpBroker hb = null;
		try {
			ClassLoader cl = GooseGet.class.getClassLoader();
			URL hsURL = HelpSet.findHelpSet(cl,hsName);
			hs = new HelpSet(null, hsURL);
		}catch (Exception ee) {
			log.warning("Helpset "+hsName+" not found");
		}
		hb = hs.createHelpBroker();
		helpButton.addActionListener(new CSH.DisplayHelpFromSource(hb));
		
		// Download
		download.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getActionCommand().equals("download")){
							
							// Check the Minimum Required things
							// Username , Password
							if(userName.getText().trim().equals("")){
								JOptionPane.showMessageDialog(null, 
										"Please give the Username",
										"GooseGet Warning",
										JOptionPane.WARNING_MESSAGE);
								return;
							}else if(String.valueOf(password.getPassword()).trim().equals("")){
								JOptionPane.showMessageDialog(null, 
										"Please give the password",
										"GooseGet Warning",
										JOptionPane.WARNING_MESSAGE);	
								return;
							}
							
							// Check the count of selected songs
							if(stm.getSelectedSongsCount()==0){
								JOptionPane.showMessageDialog(null, 
										"No Songs Selected",
										"GooseGet Warning",
										JOptionPane.WARNING_MESSAGE);	
								return;							
							}
							
							// Check the directory Availability
							if(dirtosave.getText().trim().equals("")){
								JOptionPane.showMessageDialog(null, 
										"Please select the download directory",
										"GooseGet Warning",
										JOptionPane.WARNING_MESSAGE);	
								return;							
							}else {
								file = new File(dirtosave.getText().trim());
								if(!file.isDirectory()){
									JOptionPane.showMessageDialog(null, 
											"Directory "+dirtosave.getText()
											+" not found",
											"GooseGet Warning",
											JOptionPane.WARNING_MESSAGE);	
									return;								
								}else if(!file.canWrite()){
									JOptionPane.showMessageDialog(null, 
											"Can not write to "+dirtosave.getText(),
											"GooseGet Warning",
											JOptionPane.WARNING_MESSAGE);	
									return;								
								}
							}
							
							// Check the Authorization
							// Set the Cookies of GG if Authorized
							// Setting these variables is Important
							// These will override the default configurations
							// Which is used in all the classes.
							GG.GG_UID = userName.getText().trim();
							GG.GG_PASS = String.valueOf(password.getPassword()).trim();
							GG.GG_DIR = dirtosave.getText().trim();
							GG.NOD = Integer.parseInt(nofd.getSelectedItem().toString());
							GG.NOR = Integer.parseInt(nor.getSelectedItem().toString());
							GGAuthorize ggauth = new GGAuthorize();
							try {
								GG.COOKIES = ggauth.getCookies();
								status.setText("Successfully Authoried");
							} catch (GGException e1) {
								JOptionPane.showMessageDialog(null, 
										"Unable to Authorize \n"+
										"Please check the Username and Password",
										"GooseGet Warning",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							// Save the properties back to conf
							Util.saveProperties();
							
							// Downloader Should Begin here
							downLoader.start();
							
						}else if(e.getActionCommand().equals("stop")){
							log.finest("Stopping..");
							runThread = false;
						}
						
					}
				});
		
	}
	
    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }
    
	class Downloader extends Thread {
		
		private SimpleQueue songsQ;
		private int runningThreads = 0;
		
		public void run(){
			download.setText("Stop");
			download.setActionCommand("stop");
			GGSong[] selSongs = stm.getSelectedSongs();
			songsQ = new SimpleQueue(selSongs.length);
			
			// Create a Queue
			for(int i=0; i<selSongs.length; i++){
				songsQ.enqueue(selSongs[i]);
			}
			
			// Create the first set of threads
			while(runThread && !songsQ.isEmpty() && runningThreads < GG.NOD){
				runSThread();
			}
		}
		
		private void checkDownloads(){
			if(runThread && !songsQ.isEmpty() && runningThreads < GG.NOD){
				runSThread();
			}
		}
		
		private void finished(){
			download.setText("Download");
			download.setActionCommand("download");
			download.setEnabled(true);
			runThread = true;
		}
		
		/**
		 * This is wrapper to a simple thread which gets downloads
		 * a song.
		 * Which Retries continiously.
		 *
		 */
		private void runSThread(){
			runningThreads++;
			Thread songDownloaderThread = new Thread(){
				public void run(){
					GGSong curSong = (GGSong)songsQ.dequeue();
					boolean sds = false;
					int retry = 0;
					while(sds == false && retry<=GG.NOR && runThread){
						if(retry>0){
							stm.setSongDownloadStatus(curSong.getId(), "Downloading..(retry "+retry+")");
						}else{
							stm.setSongDownloadStatus(curSong.getId(), "Downloading..");
						}
						
						sds = GGSongRetriever.getSong(curSong);
						if(!sds){
							stm.setSongDownloadStatus(curSong.getId(), "Retrying..");
							try {
								Thread.sleep(GG.GG_SLEEP);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							retry++;
						}
					}
					stm.setSongDownloadStatus(curSong.getId(), "Completed");
					runningThreads--;
					checkDownloads();
				}
			};
			songDownloaderThread.start();
		}
	}
	
}
