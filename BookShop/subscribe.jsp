<%@page 
import="
	javax.servlet.*,
	javax.naming.*,
	java.sql.*,
	javax.sql.*,
	com.bs.common.DBUtil
	" 
%>
<jsp:include page="header.jsp">
	<jsp:param name="pagetitle" value="Book Store for Dummies"/>
	<jsp:param name="subtitle" value="subscribe"/>
</jsp:include>

<%@ taglib uri="/html" prefix="html" %>
<%@ taglib uri="/bean" prefix="bean" %>
<center><h2>Subscription Page</h2></center>
<html:errors/><br/>
<table>
<html:form action="/subscribe.do" method="post">
<tr>
	<td>username</td>
	<td><html:text property="userName" value=""/></td>
</tr>
<tr>
	<td>password</td>
	<td><html:password property="pass1" value=""/></td>
</tr>
<tr>
	<td>password</td>
	<td><html:password property="pass2" value=""/></td>
</tr>
<tr>
	<td>Full Name</td>
	<td><html:text property="fullName" value=""/></td>
</tr>
<tr>
	<td>E-Mail</td>
	<td><html:text property="email" value=""/></td>
</tr>
<tr>
	<td colspan="2">
		<html:submit property="submit" value="Submit"/>
	</td>
</tr>
</html:form>

</table>
<jsp:include page="footer.jsp"/>