/*
 * Created on Jun 17, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.ejb;

import java.util.Collection;

import javax.ejb.EJBLocalObject;
import javax.ejb.FinderException;

import com.bs.common.Book;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public interface BooksCatalogLocal extends EJBLocalObject{
	public Book getBook(int id) throws FinderException;
	public Collection getBooks();
}
