<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.dba.*"%>
<%@ include file="header.jsp"%>

<div class="container" align="center">
	<div class='grid-container'>
		<div class='grid-20'>
			<table class='table table-striped table-hover '>
				<tbody>
					<tr>
						<td><h1>For user:</h1></td>
							<td><h1>${user}</h1></td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td><h3>Database Selected:</h3></td> -->
<%-- 						<td><h3>${db}</h3></td> --%>
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td><h3>Table Selected:</h3></td> -->
<%-- 						<td><h3>${table}</h3></td> --%>
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td><h3>Column Selected:</h3></td> -->
<%-- 						<td><h3>${column}</h3></td> --%>
<!-- 					</tr> -->
				</tbody>
			</table>
		</div>
		<div class='grid-70'>
		<div>
		<br>
		<h3>update privilege options</h3>
		<h3>of database "${db}", of table "${table}", of column "${column}"</h3>
		</div>
			<form method="post"
				action="/FebflixDBA/servlet/columnprivileges?user=${user}&dbs=${db}&table=${table}&column=${column}">
				<table class='table table-striped table-hover '>
					<tbody>
						<tr>
							<th></th>
							<th>&nbsp;</th>
						</tr>
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
							<td>&nbsp;<input type='hidden' name='cp_user'
								value='${user}' /><input type='hidden' name='cp_db'
								value='${db}' /><input type='hidden' name='cp_table'
								value='${table}' /><input type='hidden' name='cp_column'
								value='${column}' /></td>
							<td><button class='btn btn-success' type='submit'
									name='grant' value='grant'>GRANT</button>&nbsp;
								<button class='btn btn-danger' type='submit' name='revoke'
									value='revoke'>REVOKE</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>