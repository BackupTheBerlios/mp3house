/*
 * Created on May 20, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.actions;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bs.ejb.UsersRemote;
import com.bs.ejb.UsersRemoteHome;
import com.bs.forms.SubscribeForm;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class SubscribeAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		SubscribeForm sform = (SubscribeForm)form;
		
		Hashtable ht = new Hashtable();
		ht.put(Context.INITIAL_CONTEXT_FACTORY,
			"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
		
		Context ctx = new InitialContext(ht);
		Object ref = ctx.lookup("java:comp/env/ejb/Users");
		UsersRemoteHome remoteHome = (UsersRemoteHome)
			PortableRemoteObject.narrow(ref, UsersRemoteHome.class);
		
		UsersRemote remote = remoteHome.create(null,
				sform.getUserName()
				,sform.getFullName(),
				sform.getPass1(),
				sform.getEmail());
		
		return mapping.findForward("successSubscribe");
	}
	
}
