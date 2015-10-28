<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ page import="com.dba.*"%>

<!-- showuser -->
<div class="container" align="center">
	<div class='grid-20'>
		<table class='table table-striped table-hover '>
			<tbody>
				<tr>
					<th><h1>Current Users:</h1></th>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><a
							href='/FebflixDBA/servlet/showpriv?user=${user}'>${user}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<!-- showuser -->
<%@ include file="footer.jsp"%>