<%@page 
language="java" 
import="com.bs.common.DBUtil,
		java.sql.*"
errorPage="error.jsp"
%>

<html>
<head><title>My Books</title></head>
<body>
<%! 
ResultSet rs = null; 
Statement stmt = null;
Connection con = DBUtil.getConnection();
%>

<%

String qry = "select * from books order by id";
try{
	stmt = con.createStatement();
	rs = stmt.executeQuery(qry);
}catch(SQLException e){
	pageContext.getServletContext().log(e.getMessage());
}

%>
<table>
<tr><td>ID</td><td>Name</td><td>ISBN</td><td>Cost</td></tr>
<% while(rs.next()){ %>
<tr>
<td><%=rs.getInt("id")%></td>
<td><%=rs.getString("title")%></td>
<td><%=rs.getString("isbn")%></td>
<td><%=rs.getInt("cost")%></td>
</tr>
<% } 
	stmt.close();
	con.close();
%>
</table>
</body>
</html>