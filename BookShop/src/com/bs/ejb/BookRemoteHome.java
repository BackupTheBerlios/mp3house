/*
 * Created on Jun 17, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.ejb;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public interface BookRemoteHome extends EJBHome{
	
	public BookRemote create(Integer id,
			String title,
			String isbn,
			Integer cost) throws CreateException, RemoteException;
	
	public BookRemote findByPrimaryKey(Integer id) throws FinderException, RemoteException;
	
	public Collection findAll() throws FinderException, RemoteException;
	
	public Collection giveAll() throws FinderException, RemoteException;

}
