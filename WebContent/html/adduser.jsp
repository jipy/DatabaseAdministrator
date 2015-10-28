<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ page import="com.dba.*"%>

<%
	String succeed = (String) session.getAttribute("succeed");
	if (succeed != null) {
		session.removeAttribute("succeed");
	}
%>
<div class="container" align="center">
	<div class='grid-80'>
		<div class='well'>
			<h3>Add User</h3>
			<%
					if (succeed != null) {
				%>
			<hr />
			<span style="color: red"><%=succeed%></span>
			<hr />
			<%
					}
				%>
			<form action="/FebflixDBA/servlet/adduser" method="post">
				<div class="login-row">
					<label>Enter user name:</label> <input type="text"
						name="newusername" required autofocus /> <br />
				</div>
				<div class="login-row">
					<label>Enter password:</label> <input type="password"
						name="newpass" required autofocus /> <br />
				</div>
				<div class="login-row">
					<input type="submit" value="ADD" class="login-button">
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>