<%@page 
language="java"
session="true"
errorPage="error.jsp"
%>
<%@ taglib uri="/mytags" prefix="mytags" %>
<html>
<head>
	<title>
	<%= request.getParameter("pagetitle") %>
	</title>
	<link rel=stylesheet type="text/css" href="edoc.css">
</head>
<body>

<table align="top" width="100%">
	<tr bgcolor="#E2EFF9">
		<td>
			<b>Book Store for Dummies</b>
			<mytags:time/>
		</td>
		<td align="right">
			<%= (session.getAttribute("uname")==null)?"":session.getAttribute("uname").toString() %>
			<%= request.getParameter("subtitle")%>
		</td>
	</tr>
</table>

<table width="100%" height="100%" valign="top">
<tr>
	<td width="16%" height="100%" valign="top"  bgcolor="#E2EFF9">
		<jsp:include page="links.jsp"/>
	</td>
	<td valign="top">

