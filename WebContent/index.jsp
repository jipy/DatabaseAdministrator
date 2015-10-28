<%@ page import="com.dba.*"%>
<% 
    String loginErr = (String)session.getAttribute("login_Err");
    if(loginErr != null){
      session.removeAttribute("login_Err");
  }
  %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Febflix Database Administrator Home</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/FebflixDBA/css/style.css" type="text/css"
	media="all" />
<script type="text/javascript" src="/FebflixDBA/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/FebflixDBA/js/jquery-func.js"></script>
</head>
<body>
	<!-- Shell -->
	<div id="shell">
		<div id="header">
			<h1 id="logo">
				<a href="/FebflixDBA/index.jsp"></a>
			</h1>
			<br> <br> <br>
		</div>
		<!-- Login -->
		<div align="center" id="login">
			<br> <br> <br> <br> <br>
			<h1>Database Administrator Page</h1>
			<h1>Please Login</h1>
			<br>
			<%
          if(loginErr != null){
        %>
			<hr />
			<span style="color: red"><%= loginErr %></span>
			<hr />
			<%
          }
        %>
			<form action="/FebflixDBA/servlet/index" method="post">
				<div class="login-row">
					<label>Username </label> <input type="text" name="username"
						placeholder="Username" required autofocus /> <br />
				</div>
				<div class="login-row">
					<label>Password </label> <input type="password" name="password"
						placeholder="Password" required /> <br />
				</div>
				<div class="login-row">
					<input type="submit" value="Login" class="login-button">
				</div>
			</form>
			<br> <br>
		</div>
		<!-- end Login -->
		<br>
		<div align="center">
			<p>
				&copy; 2015 Fabflix. Designed by Group 8, CS122b, UCI. </a>
			</p>
		</div>
	</div>
	<!-- end Shell -->
</body>
</html>