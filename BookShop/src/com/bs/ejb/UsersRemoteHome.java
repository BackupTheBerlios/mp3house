/*
 * Created on May 21, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.ejb;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public interface UsersRemoteHome extends EJBHome {
	
	public UsersRemote create(Integer id,
			String userName,
			String fullName,
			String password,
			String email) throws CreateException, RemoteException;
	
	public UsersRemote findByPrimaryKey(Integer id) throws FinderException, RemoteException;
	
}
