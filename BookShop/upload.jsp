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
	<jsp:param name="subtitle" value="Upload"/>
</jsp:include>

<form action="UploadServlet" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td>Select a file</td>
		<td><input type="file" name="fileName"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input type="submit" value="Upload"/></td>
	</tr>
</table>
</form>


<jsp:include page="footer.jsp"/>