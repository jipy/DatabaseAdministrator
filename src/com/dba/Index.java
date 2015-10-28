package com.dba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public Index() {
		super();
	}

	// need improve
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Connection connection = null;
		connection = (Connection) session.getAttribute("connection");
		if(connection != null){
			RequestDispatcher view = request
					.getRequestDispatcher("/FebflixDBA/html/scceed.jsp");
			view.forward(request, response);
		}
		else{
			RequestDispatcher view = request
					.getRequestDispatcher("/FebflixDBA/index.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String usernameVar = request.getParameter("username");
		String passwordVar = request.getParameter("password");
		HttpSession session= request.getSession();
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql:///", usernameVar,
					passwordVar);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		if (connection != null) {
			boolean loginCheck = true;
			session.setAttribute("login", loginCheck);
			session.setAttribute("connection", connection);
			response.sendRedirect("/FebflixDBA/html/scceed.jsp");
		} else {
			String loginErr = "Unvalid username or password.";
			session.setAttribute("login_Err", loginErr);
			RequestDispatcher view = request
					.getRequestDispatcher("/FebflixDBA/index.jsp");
			view.forward(request, response);
		}
	}
}
