/*
 * Created on Jun 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
			HttpServletResponse res) throws IOException, ServletException{
		req.getSession(true).setAttribute("uname",
				req.getParameter("username"));
		log((String) req.getParameter("username"));
		log(req.getSession().getId());
		RequestDispatcher rp = 
			getServletContext().getRequestDispatcher("/index.jsp");
		rp.forward(req, res);
	}
}
