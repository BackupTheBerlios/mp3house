/*
 * Created on Jun 17, 2004
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
public interface BookRemote extends EJBObject{
	public Integer getId() throws RemoteException;
	public void setId(Integer id) throws RemoteException;
	
	public String getTitle() throws RemoteException;
	public void setTitle(String title) throws RemoteException;
	
	public String getIsbn() throws RemoteException;
	public void setIsbn(String isbn) throws RemoteException;
	
	public Integer getCost() throws RemoteException;
	public void setCost(Integer cost) throws RemoteException;
}
