<%@page 
import="
	javax.servlet.*,
	javax.naming.*,
	java.sql.*,
	javax.sql.*,
	com.bs.common.DBUtil
	" 
%>
<html>
<head><title>Book Store</title></head>

<body>
<center><h1><font color='blue'>Book Store</font></h1></center>
<center><a href="">Login</a></center><br/>
<center><a href="subscribe.jsp">Subscribe</a></center>

<table>
<%! 
	ResultSet rs = null;
	String show;
%>

<%
Connection con = DBUtil.getConnection();
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from books");
while(rs.next()){
%>
<tr><td>
<%= rs.getString("title") %>
</td></tr>
<% } %>
</table>
</body>


</html>