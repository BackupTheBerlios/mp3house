<%@page 
language="java" 
import="java.sql.*, com.bs.common.DBUtil, java.util.*, javax.naming.*, com.bs.ejb.*,
javax.rmi.PortableRemoteObject,
com.bs.common.*"
%>
<jsp:include page="header.jsp">
	<jsp:param name="pagetitle" value="Book Store for Dummies"/>
	<jsp:param name="subtitle" value="Showing Books"/>
</jsp:include>

<%
		Hashtable ht = new Hashtable();
		ht.put(Context.INITIAL_CONTEXT_FACTORY,
			"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
		
		Context ctx = new InitialContext(ht);
		Object ref = ctx.lookup("java:comp/env/ejb/Books");
		BookRemoteHome remoteHome = (BookRemoteHome)
			PortableRemoteObject.narrow(ref, BookRemoteHome.class);
		Collection c = remoteHome.giveAll();
		Iterator i = c.iterator();

%>
<table>
<tr><td>ID</td><td>Name</td><td>ISBN</td><td>Cost</td></tr>
<% while(i.hasNext()){
	Book b = (Book) i.next();
 %>
<tr>
<td><%=b.getId()%></td>
<td><%=b.getTitle()%></td>
<td><%=b.getIsbn()%></td>
<td><%=b.getCost()%></td>
</tr>
<% }
%>
</table>

<jsp:include page="footer.jsp"/>