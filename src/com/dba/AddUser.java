package com.dba;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUser() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Connection connection = null;
		connection = (Connection) session.getAttribute("connection");
		if (connection != null) {
			RequestDispatcher view = request
					.getRequestDispatcher("/html/adduser.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Connection connection = null;
		connection = (Connection) session.getAttribute("connection");
		String newUserName = request.getParameter("newusername");
		String newPassword = request.getParameter("newpassword");
		DatabaseFuncation dbaf = new DatabaseFuncation();
		boolean createUserResult=true;
		try {
			createUserResult = dbaf.createUser(newUserName, newPassword,
					connection);
			//session.setAttribute("createUserResult", createUserResult);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (createUserResult==false) {
			String succeed = "Successfully Added!";
			session.setAttribute("succeed", succeed);
			RequestDispatcher view = request
					.getRequestDispatcher("/html/adduser.jsp");
			view.forward(request, response);
		} else {
			String succeed = "You don't have enough privilege! OR User Already existed";
			session.setAttribute("succeed", succeed);
			RequestDispatcher view = request
					.getRequestDispatcher("/html/adduser.jsp");
			view.forward(request, response);
		}
	}
}
