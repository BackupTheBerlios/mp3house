/*
 * Created on Jun 20, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.vj.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Logger;


/**
 * DataBase Connection Pool Class.
 * It is a lazy connection pooler, means the connections are created
 * and pooled on the first request.
 * Uses a singleton pattern in the background. 
 */
public class ConnectionPool {
	
	// Single Instance of this Class
	static private ConnectionPool instance = null;
	
	// Driver name
	private String driverName;
	
	// JDBC URL
	private String jdbcurl;
	
	// UserName
	private String userName;
	
	// Password 
	private String password;
	
	// Connection Limit
	private int limit;
	
	// Connection Pool Properties
	private Properties p;
	
	// Pool Of Connections
	private Vector connections;
	
	// Database Driver
	private Driver driver = null;
	
	// Logger
	static private Logger log = Logger.getLogger("ConnectionPool"); 
	
	/**
	 * Constructor
	 * 
	 * @see #getInstance()
	 */
	private ConnectionPool(){
		
		connections = new Vector();
		
		// Load Properties File
		FileInputStream propFile = null;
		try {
			propFile = new FileInputStream("conf/DBPool.properties");
		} catch (FileNotFoundException e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		}
		p = new Properties();
		try {
			p.load(propFile);
		} catch (IOException e1) {
			log.severe(e1.getMessage());
			e1.printStackTrace();
		}
		
		// Load the properties to variables
		driverName = p.getProperty("db.pool.driver");
		userName = p.getProperty("db.pool.username");
		password = p.getProperty("db.pool.password", "");
		jdbcurl = p.getProperty("db.pool.jdbcurl");
		limit = Integer.parseInt(p.getProperty("db.pool.limit"));
		
		// Register the driver
		try {
			
			driver = (Driver)Class.forName(driverName).newInstance();
			DriverManager.registerDriver(driver);
			
			// Create an initial Connection
//			Connection con = DriverManager. 
//				getConnection(jdbcurl, userName, password);
//			connections.add(con);
			
			for(int i=0; i<limit; i++){
				Connection con = DriverManager.getConnection(jdbcurl, userName, password);
				connections.addElement(con);
			}
			
		} catch (InstantiationException e2) {
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Gets an Instance of the Class
	 * 
	 * @return instance ConnectionPool
	 */
	static public synchronized ConnectionPool getInstance(){
		if(instance == null){
			instance = new ConnectionPool();
		}
		return instance;
	}
	
	/**
	 * Gets a connection from the pool of Connections.
	 * 
	 * @return connection database connection
	 */
	public Connection getConnection(){
		Connection dbConnection = null;
		//log.finest(Integer.toString(connections.size()));
		dbConnection = (Connection)connections.firstElement();
		connections.remove(0);
		try {
			if (dbConnection.isClosed()) {
				dbConnection = getConnection();
			}else {
				dbConnection.getMetaData();
			}
		}
		catch (SQLException sqlE) {
			sqlE.printStackTrace();
			dbConnection = getConnection();
		}
		return dbConnection;
	}
	
	/**
	 * Collection back the Connection in to pool.
	 * This can be changed by creating a thread which always
	 * monitors Connections.
	 * 
	 * @param gotBackConnection Database Connection.
	 */
	public void giveBack(Connection gotBackConnection){
		if ( gotBackConnection != null ) {
			try {
				if ( !gotBackConnection.isClosed() ) {
					connections.addElement(gotBackConnection);
				}
			}catch (SQLException sqlE) {
				
			}
		}
	}
	
	/**
	 * Closes all connections.
	 * 
	 * @return true, if able to close all connection. false otherwise
	 */
	public synchronized void closeAllConnections(){
		for(int i=0; i<connections.size(); i++){
			try {
				((Connection)connections.get(i)).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connections = null;
			try {
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			instance = null;
		}
	}
}
