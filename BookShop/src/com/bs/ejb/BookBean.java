/*
 * Created on Jun 17, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.ejb;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.bs.common.Book;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public abstract class BookBean implements EntityBean{

	public Integer ejbCreate(Integer id,
			String title,
			String isbn,
			Integer cost) throws CreateException {
		setId(id);
		setTitle(title);
		setIsbn(isbn);
		setCost(cost);
		return null;
	}
	
	public void ejbPostCreate(Integer id,
			String title,
			String isbn,
			Integer cost) throws CreateException {
	}
	
	public abstract Integer getId();
	public abstract void setId(Integer id);
	
	public abstract String getTitle();
	public abstract void setTitle(String title);
	
	public abstract String getIsbn();
	public abstract void setIsbn(String isbn);
	
	public abstract Integer getCost();
	public abstract void setCost(Integer cost);
	
	public abstract ResultSet ejbSelectAll() throws FinderException;
	
	public Collection ejbHomeGiveAll(){
		Collection c = null;
		try{
			ResultSet rs = ejbSelectAll();
			while(rs.next()){
				Book b = new Book(rs.getInt("id"),
						rs.getString("title"),
						rs.getString("isbn"),
						rs.getString("cost"));
				c.add(b);
			}
		}catch(Exception e){
			
		}
		return c;
	}
	
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
