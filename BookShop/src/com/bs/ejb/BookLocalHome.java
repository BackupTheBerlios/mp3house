/*
 * Created on Jun 17, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.ejb;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public interface BookLocalHome extends EJBLocalHome{
	public BookLocal create(Integer id,
			String title,
			String isbn,
			Integer cost) throws CreateException;
	
	public BookLocal findByPrimaryKey(Integer id) throws FinderException;
	
	public Collection findAll() throws FinderException;
	
	public Collection giveAll() throws FinderException;
}
