<%@page
%>
<jsp:include page="header.jsp">
	<jsp:param name="pagetitle" value="Book Store for Dummies"/>
	<jsp:param name="subtitle" value="Login"/>
</jsp:include>

<form action="LoginServlet" method="post">
<table>
<tr>
	<td>UserName</td>
	<td><input type="text" name="username"/></td>
</tr>
<tr>
	<td>Password</td>
	<td><input type="text" name="password"/></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="Submit">
	</td>
</tr>
</form>
<jsp:include page="footer.jsp"/>