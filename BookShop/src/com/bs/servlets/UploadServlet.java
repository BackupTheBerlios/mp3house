/*
 * Created on Jun 8, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class UploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, 
			HttpServletResponse res) throws IOException, ServletException{
		DiskFileUpload upload = new DiskFileUpload();
		List items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
		    FileItem item = (FileItem) iter.next();
			if (!item.isFormField()) {
			    String fieldName = item.getFieldName();
			    String fileName = item.getName();
			    if(fieldName.equals("fileName")){
			    	File file = new File(getServletConfig().getInitParameter("filedir")+"\\"+fileName);
			    	try {
						item.write(file);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			    }
			}
		}
		res.sendRedirect("upload.jsp");
	}
}
