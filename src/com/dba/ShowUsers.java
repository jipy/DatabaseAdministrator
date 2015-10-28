package com.dba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

public class ShowUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowUsers() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Connection connection = null;
		connection = (Connection) session.getAttribute("connection");
		if (connection != null) {
			RequestDispatcher view = request
					.getRequestDispatcher("/html/showusers.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		DatabaseFuncation dbaf = new DatabaseFuncation();
		HttpSession session = request.getSession(false);
		Connection connection = (Connection) session.getAttribute("connection");

		try {
			ArrayList<String> users = null;
			users=dbaf.getUsers(connection);
			if(users==null){
				response.sendRedirect("/FebflixDBA/html/failed.jsp");
			}
			request.setAttribute("users", users);
			request.getRequestDispatcher("/html/showusers.jsp").forward(
					request, response);
		} catch (SQLException e) {
			response.sendRedirect("/FebflixDBA/html/failed.jsp");
			e.printStackTrace();
		}
	}
}
