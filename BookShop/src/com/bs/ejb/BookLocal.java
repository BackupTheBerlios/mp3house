/*
 * Created on Jun 17, 2004
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
public interface BookLocal extends EJBLocalObject{

	public Integer getId();
	public void setId(Integer id);
	
	public String getTitle();
	public void setTitle(String title);
	
	public String getIsbn();
	public void setIsbn(String isbn);
	
	public Integer getCost();
	public void setCost(Integer cost);
}
