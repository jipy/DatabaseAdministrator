package com.dba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowPriv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowPriv() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Connection connection = null;
		connection = (Connection) session.getAttribute("connection");
		String user = request.getParameter("user");
		DatabaseFuncation dbaf=new DatabaseFuncation();
		try {
			ArrayList<String> result = dbaf.checkUserPriv(connection, user);
			request.setAttribute("userCheck", result);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/html/showpriv.jsp").forward(request,
					response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
