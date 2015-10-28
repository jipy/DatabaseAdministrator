package com.dba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean loginCheck=(boolean)session.getAttribute("login");
		if (loginCheck != true) {
			// already logged out
		} else {
			// invalidate all sessions
			Connection connection=(Connection) session.getAttribute("connection");
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.invalidate();
		}
		// redirect to /servlet/index
		response.sendRedirect("/FebflixDBA/index.jsp");
	}
}
