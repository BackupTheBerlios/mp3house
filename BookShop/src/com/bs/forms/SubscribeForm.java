/*
 * Created on May 20, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class SubscribeForm extends org.apache.struts.action.ActionForm {
	
	private String userName, pass1, pass2, fullName, email;
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest req){
		
		ActionErrors errors = new ActionErrors();
		ActionError error = new ActionError("error.validation", "");
		errors.add(ActionErrors.GLOBAL_ERROR, error);

		return errors;
	}
	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return Returns the fullName.
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName The fullName to set.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return Returns the pass1.
	 */
	public String getPass1() {
		return pass1;
	}
	/**
	 * @param pass1 The pass1 to set.
	 */
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	/**
	 * @return Returns the pass2.
	 */
	public String getPass2() {
		return pass2;
	}
	/**
	 * @param pass2 The pass2 to set.
	 */
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	/**
	 * @return Returns the userName.
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest req){
		userName = pass1 = pass2 = fullName = email = null;
	}
}
