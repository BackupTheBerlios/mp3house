/*
 * Created on Feb 16, 2004 8:20:04 PM
 * GGErrorCodes.java
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

import java.util.HashMap;
import java.util.Map;

/**
 * Error Codes
 */
public class GGErrorCodes {
	
	private static final Map errorMessages = new HashMap();
	
	/**
	 * Error for Unknown GGException
	 */
	public static final int GG_UNKNOWN = 0;
	
	/**
	 * Error to say that unable to Authenticate to the server
	 */
	public static final int GG_UNABLE_TO_AUTH = 1;
	
	/**
	 * No net connection
	 */
	public static final int GG_NO_CONNECTION = 2;
	
	
	/**
	 * URL not found
	 */
	public static final int GG_URL_NOTFOUND = 100;

	/**
	 * Malformed URL
	 */
	public static final int GG_URL_MALFORMED = 101;	
	
	/**
	 * URL Unable to openconnection
	 */
	public static final int GG_URL_UNABLE_TOOPEN_CONNECTION = 102;	
	
	static {
		
		putErrorMessage(GG_UNKNOWN, "Unknown GG Error");
		putErrorMessage(GG_UNABLE_TO_AUTH,
			"unable to Authenticate to the server");
		putErrorMessage(GG_NO_CONNECTION, "No net connection");
		putErrorMessage(GG_URL_NOTFOUND, "URL not found");
		putErrorMessage(GG_URL_MALFORMED, "Malformed URL");
		putErrorMessage(GG_URL_UNABLE_TOOPEN_CONNECTION, "Unable to open connection to URL");
	}
	
	/**
	 * maps the error codes to the messages
	 * 
	 * @param code errorcode
	 * @param message message corresponding the error code.
	 */
	
	private static void putErrorMessage(int code, String message) {
		errorMessages.put(new Integer(code), message);
	}
	
	/**
	 * Gets the message corresponding the error code.
	 * 
	 * @param code error code
	 * @return msg error code message
	 */
	public static String getMessage(int code) {
		String msg = (String) errorMessages.get(new Integer(code));
		return msg != null ? msg : "";
	}
	
	/**
	 * Creates GGException with the given error code.
	 * 
	 * @param code error code
	 * @return GGException object.
	 */
	public static GGException createGGException(int code){
		return new GGException(code);
	}
}
