<%@page 
language="java" 
import="java.sql.*, com.bs.common.DBUtil"
%>
<jsp:include page="header.jsp">
	<jsp:param name="pagetitle" value="Book Store for Dummies"/>
	<jsp:param name="subtitle" value="Showing Books"/>
</jsp:include>

<%
ResultSet rs = null; 
Statement stmt = null;
Connection con = DBUtil.getConnection();
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

<jsp:include page="footer.jsp"/>