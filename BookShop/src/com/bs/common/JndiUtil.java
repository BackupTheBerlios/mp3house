/*
 * Created on Jun 18, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.common;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class JndiUtil {
	
	public static Context getInitialContext(){
		Context ctx = null;
		Hashtable ht = new Hashtable();
		ht.put(Context.INITIAL_CONTEXT_FACTORY,
				"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL,
				"t3://localhost:7001");
		try {
			ctx = new InitialContext(ht);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ctx;
	}
	
}
