package com.dba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DBPrivileges extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DBPrivileges() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DatabaseFuncation dbaf = new DatabaseFuncation();
		HttpSession session = request.getSession(false);
		Connection connection = (Connection) session.getAttribute("connection");

		String user = request.getParameter("user");
		String db = request.getParameter("dbs");

		try {
			ArrayList<String> databaseTables = dbaf.getDBTables(db, connection);
			request.setAttribute("databaseTables", databaseTables);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("user", user);
		request.setAttribute("db", db);
		request.getRequestDispatcher("/html/dbprivileges.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Connection connection = (Connection) session.getAttribute("connection");

		String sql = "";
		String powers = "";

		String user = request.getParameter("dp_user");
		String db = request.getParameter("dp_db");
		
		if (request.getParameter("addmovie") != null) {
			
			if (powers.equals(""))
				powers += "execute on procedure add_movie";
			
			if(request.getParameter("grant") != null)
				sql = "GRANT " + powers + " to '"+ user + "'@'localhost';"; 
			
			if(request.getParameter("revoke") != null)
				sql = "REVOKE " + powers + " from '"+ user + "'@'localhost';"; 
			
			try {
				Statement grantRevoke = connection.createStatement();
				grantRevoke.execute("use moviedb;");
				boolean b = grantRevoke.execute(sql);
				if (b == false) {
					response.sendRedirect("/FebflixDBA/html/scceed.jsp");
				}

			} catch (SQLException e) {
				response.sendRedirect("/FebflixDBA/html/failed.jsp");
				e.printStackTrace();
			}
			}
		else {
			if (request.getParameter("select") != null) {
				if (powers.equals(""))
					powers += "SELECT";
				else
					powers += ", SELECT";
			}
			if (request.getParameter("insert") != null) {
				if (powers.equals(""))
					powers += "INSERT";
				else
					powers += ", INSERT";
			}
			if (request.getParameter("update") != null) {
				if (powers.equals(""))
					powers += "UPDATE";
				else
					powers += ", UPDATE";
			}
			if (request.getParameter("delete") != null) {
				if (powers.equals(""))
					powers += "DELETE";
				else
					powers += ", DELETE";
			}
			if (request.getParameter("references") != null) {
				if (powers.equals(""))
					powers += "REFERENCES";
				else
					powers += ", REFERENCES";
			}
			if (request.getParameter("create") != null) {
				if (powers.equals(""))
					powers += "CREATE";
				else
					powers += ", CREATE";
			}
			if (request.getParameter("drop") != null) {
				if (powers.equals(""))
					powers += "DROP";
				else
					powers += ", DROP";
			}
			if (request.getParameter("alter") != null) {
				if (powers.equals(""))
					powers += "ALTER";
				else
					powers += ", ALTER";
			}
			if (request.getParameter("index") != null) {
				if (powers.equals(""))
					powers += "INDEX";
				else
					powers += ", INDEX";
			}
			if (request.getParameter("trigger") != null) {
				if (powers.equals(""))
					powers += "TRIGGER";
				else
					powers += ", TRIGGER";
			}

			if (request.getParameter("grant") != null)
				sql = "GRANT " + powers + " ON " + db + ".* TO '" + user
						+ "'@'localhost'";

			if (request.getParameter("revoke") != null)
				sql = "REVOKE " + powers + " ON " + db + ".* FROM '" + user
						+ "'@'localhost'";
		

		System.out.println(sql);
		try {
			Statement grantRevoke = connection.createStatement();
			boolean b = grantRevoke.execute(sql);
			if (b == false) {
				response.sendRedirect("/FebflixDBA/html/scceed.jsp");
			}

		} catch (SQLException e) {
			response.sendRedirect("/FebflixDBA/html/failed.jsp");
			e.printStackTrace();
		}
		}
	}
}