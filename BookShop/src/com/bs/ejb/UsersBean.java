/*
 * Created on May 21, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.ejb;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public abstract class UsersBean implements EntityBean{
	
	
	public Integer ejbCreate(Integer id,
			String userName,
			String fullName,
			String password,
			String email) throws CreateException {
		setId(id);
		setUserName(userName);
		setFullName(fullName);
		setPassword(password);
		setEmail(email);
		return null;
	}
	
	public void ejbPostCreate(Integer id,
			String userName,
			String fullName,
			String password,
			String email) throws CreateException {
	}
	
	public abstract Integer getId();
	public abstract void setId(Integer id);
	
	public abstract String getUserName();
	public abstract void setUserName(String userName);
	
	public abstract String getFullName();
	public abstract void setFullName(String fullName);
	
	public abstract String getPassword();
	public abstract void setPassword(String password);
	
	public abstract String getEmail();
	public abstract void setEmail(String email);
	
	

	/* (non-Javadoc)
	 * @see javax.ejb.EntityBean#setEntityContext(javax.ejb.EntityContext)
	 */
	public void setEntityContext(EntityContext arg0) throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.ejb.EntityBean#unsetEntityContext()
	 */
	public void unsetEntityContext() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.ejb.EntityBean#ejbRemove()
	 */
	public void ejbRemove() throws RemoveException, EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.ejb.EntityBean#ejbActivate()
	 */
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.ejb.EntityBean#ejbPassivate()
	 */
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.ejb.EntityBean#ejbLoad()
	 */
	public void ejbLoad() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.ejb.EntityBean#ejbStore()
	 */
	public void ejbStore() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}
}
