<%@page 
import="
	javax.servlet.*,
	javax.naming.*,
	java.sql.*,
	javax.sql.*,
	com.bs.common.DBUtil,
	com.bs.common.BookBean
	" 
%>
<jsp:include page="header.jsp">
	<jsp:param name="pagetitle" value="Book Store for Dummies"/>
	<jsp:param name="subtitle" value="Home"/>
</jsp:include>

<jsp:useBean id="bb" class="com.bs.common.BookBean"/>

<jsp:setProperty name="bb" property="bookName" value="JSP Dev"/>
<jsp:getProperty name="bb" property="bookName"/>

<jsp:include page="footer.jsp"/>