/*
 * Created on May 21, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.ejb;

import javax.ejb.EJBLocalObject;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public interface UsersLocal extends EJBLocalObject{
	
	public Integer getId();
	public void setId(Integer id);
	
	public String getUserName();
	public void setUserName(String userName);
	
	public String getFullName();
	public void setFullName(String fullName);
	
	public String getPassword();
	public void setPassword(String password);
	
	public String getEmail();
	public void setEmail(String email);
	
}
