/*
 * Created on May 21, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.ejb;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public interface UsersRemote extends EJBObject{
	
	public Integer getId() throws RemoteException;
	public void setId(Integer id) throws RemoteException;
	
	public String getUserName() throws RemoteException;
	public void setUserName(String userName) throws RemoteException;
	
	public String getFullName() throws RemoteException;
	public void setFullName(String fullName) throws RemoteException;
	
	public String getPassword() throws RemoteException;
	public void setPassword(String password) throws RemoteException;
	
	public String getEmail() throws RemoteException;
	public void setEmail(String email) throws RemoteException;
}
