<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ page import="com.dba.*"%>
<div class="container" align="center">
	<div class='grid-container'>
		<div class='grid-20'>
			<table class='table table-striped table-hover '>
				<thead>
					<tr>
						<th><h1>Privileges of user "${user}"</h1></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><h3>${userCheck}</h3></th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>