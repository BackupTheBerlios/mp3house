/*
 * Created on Jun 17, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.common;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Book implements Serializable {

	private int id;
	private String title, isbn, cost;
	
	public Book(int id, String title, String isbn, String cost){
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.cost = cost;
	}
	
	/**
	 * @return Returns the cost.
	 */
	public String getCost() {
		return cost;
	}
	/**
	 * @param cost The cost to set.
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}
	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return Returns the isbn.
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn The isbn to set.
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
