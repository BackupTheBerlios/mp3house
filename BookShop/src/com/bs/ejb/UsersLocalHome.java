/*
 * Created on May 21, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.ejb;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public interface UsersLocalHome extends EJBLocalHome {
	
	public UsersLocal create(Integer id,
			String userName,
			String fullName,
			String password,
			String email) throws CreateException;
	
	public UsersLocal findByPrimaryKey(Integer id) throws FinderException;
}
