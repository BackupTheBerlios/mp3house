<%@page 
%>
<table width="100%" valign="top">
<tr><td>
	<a href="index.jsp">Home</a>
</td></tr>
<tr><td>
	<a href="showbooks.jsp">Show Books</a>
</td></tr>
<%
if(session.getAttribute("uname") == null){
%>
<tr><td>
	<a href="login.jsp">Login</a>
</td></tr>
<tr><td>
	<a href="subscribe.jsp">Subscribe</a>
</td></tr>
<%
}else {
%>
<tr><td>
	<a href="AddBook.jsp">Add Book</a>
</td></tr>
<tr><td>
	<a href="upload.jsp">Upload</a>
</td></tr>
<tr><td>
	<a href="LogoutServlet">Logout</a>
</td></tr>
<%}%>

</table>