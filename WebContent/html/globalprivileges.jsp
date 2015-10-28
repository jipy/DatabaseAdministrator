<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ page import="com.dba.*"%>

<body>
	<div class="container" align="center">
		<div class='grid-container'>
			<div class='grid-20'>
				<table class='table table-striped table-hover '>
					<tbody>
						<tr>
							<td><h1>For user:</h1></td>
							<td><h1>${user}</h1></td>
						</tr>
					</tbody>
				</table>

			</div>
			<div class='grid-70'>
				&nbsp; &nbsp; &nbsp;
				<div>
					<h3>Update privilege options on</h3>
					<h3>all databases:</h3>
					<br>
				</div>
				<form method="post"
					action="/FebflixDBA/servlet/globalprivileges?user=${user}">
					<table class='table table-striped table-hover '>
						<tbody>

							<tr>
								<td>SELECT</td>
								<td><input type='checkbox' name='select' value='select' /></td>
							</tr>
							<tr>
								<td>INSERT</td>
								<td><input type='checkbox' name='insert' value='insert' /></td>
							</tr>
							<tr>
								<td>UPDATE</td>
								<td><input type='checkbox' name='update' value='update' /></td>
							</tr>
							<tr>
								<td>DELETE</td>
								<td><input type='checkbox' name='delete' value='delete' /></td>
							</tr>
							<tr>
								<td>REFERENCES</td>
								<td><input type='checkbox' name='references'
									value='references' /></td>
							</tr>
							<tr>
								<td>CREATE</td>
								<td><input type='checkbox' name='create' value='create' /></td>
							</tr>
							<tr>
								<td>DROP</td>
								<td><input type='checkbox' name='drop' value='drop' /></td>
							</tr>
							<tr>
								<td>ALTER</td>
								<td><input type='checkbox' name='alter' value='alter' /></td>
							</tr>
							<tr>
								<td>INDEX</td>
								<td><input type='checkbox' name='index' value='index' /></td>
							</tr>
							<tr>
								<td>TRIGGER</td>
								<td><input type='checkbox' name='trigger' value='trigger' /></td>
							</tr>
							<tr>
								<td>&nbsp;<input type='hidden' name='gp_user'
									value='${user}' /></td>
								<td><button class='btn btn-success' type='submit'
										name='grant' value='grant'>GRANT</button>&nbsp;
									<button class='btn btn-danger' type='submit' name='revoke'
										value='revoke'>REVOKE</button></td>
							</tr>
						</tbody>
					</table>
				</form>
				<div>
					<br>
					<h3>OR select more detailed option</h3>
					<br>
				</div>
				<form method="get" action='/FebflixDBA/servlet/dbprivileges'>
					<select name='dbs'>
						<c:forEach items="${databases}" var="database">
							<option value="${database}">${database}</option>
						</c:forEach>
					</select> <input type="hidden" name="user" value="${user}" />
					<button class='btn btn-info' type='submit'>Select Database</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
<%@ include file="footer.jsp"%>