<%@page language="java" %>
<jsp:include page="header.jsp">
	<jsp:param name="pagetitle" value="Book Store for Dummies"/>
	<jsp:param name="subtitle" value="Add book"/>
</jsp:include>

<%@ taglib uri="/html" prefix="html" %>
<%@ taglib uri="/bean" prefix="bean" %>
<center><h2>Add Book</h2></center>
<html:errors/><br/>
<table>
<html:form action="/addbook.do" method="post">
<tr>
	<td>Book Title</td>
	<td><html:text property="bookTitle" value=""/></td>
</tr>
<tr>
	<td>ISBN</td>
	<td><html:text property="isbn" value=""/></td>
</tr>
<tr>
	<td>Cost</td>
	<td><html:text property="cost" value=""/></td>
</tr>
<tr>
	<td colspan="2">
		<html:submit property="submit" value="Submit"/>
	</td>
</tr>
</html:form>

</table>
<jsp:include page="footer.jsp"/>