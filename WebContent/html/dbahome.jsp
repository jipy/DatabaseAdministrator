<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp"%>

<!-- home  -->
<div class="container" align="center">
	<div class='grid-container'>
		<div class='grid-20'>
			<table class='table table-striped table-hover '>
				<tbody>
					<tr>
						<th><h1>Current Users:</h1></th>
					</tr>
					<c:forEach items="${users}" var="user">
						<tr>
							<td><a
								href='/FebflixDBA/servlet/globalprivileges?user=${user}'>${user}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</div>
<!-- home -->
<%@ include file="footer.jsp"%>