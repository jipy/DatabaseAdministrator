package com.dba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ColumnPrivileges extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ColumnPrivileges() 
    {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//HttpSession session = request.getSession(false);
		//Connection connection = (Connection) session.getAttribute("connection");
		//MovieDB movieDB = new MovieDB();
		
		String user = request.getParameter("user");
		String db 	= request.getParameter("dbs");
		String table = request.getParameter("table");
		String column = request.getParameter("column");
		
		request.setAttribute("user", user);
		request.setAttribute("db", db);
		request.setAttribute("table", table);
		request.setAttribute("column", column);
		request.getRequestDispatcher("/html/columnprivileges.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		Connection connection = (Connection) session.getAttribute("connection");
		
		String sql = "";
		String powers = "";
		
		String user = request.getParameter("cp_user");
		String db = request.getParameter("cp_db");
		String table = request.getParameter("cp_table");
		String column = request.getParameter("cp_column");
		
		if(request.getParameter("select") != null)
		{
			if(powers.equals(""))
				powers += "SELECT ("+column+")";
			else
				powers += ", SELECT ("+column+")";
		}
		if(request.getParameter("insert") != null)
		{
			if(powers.equals(""))
				powers += "INSERT ("+column+")";
			else
				powers += ", INSERT ("+column+")";
		}
		if(request.getParameter("update") != null)
		{
			if(powers.equals(""))
				powers += "UPDATE ("+column+")";
			else
				powers += ", UPDATE ("+column+")";
		}
		if(request.getParameter("delete") != null)
		{
			if(powers.equals(""))
				powers += "DELETE ("+column+")";
			else
				powers += ", DELETE ("+column+")";
		}
		if(request.getParameter("references") != null)
		{
			if(powers.equals(""))
				powers += "REFERENCES ("+column+")";
			else
				powers += ", REFERENCES ("+column+")";
		}
		if(request.getParameter("create") != null)
		{
			if(powers.equals(""))
				powers += "CREATE ("+column+")";
			else
				powers += ", CREATE ("+column+")";
		}
		if(request.getParameter("drop") != null)
		{
			if(powers.equals(""))
				powers += "DROP ("+column+")";
			else
				powers += ", DROP ("+column+")";
		}
		if(request.getParameter("alter") != null)
		{
			if(powers.equals(""))
				powers += "ALTER ("+column+")";
			else
				powers += ", ALTER ("+column+")";
		}
		if(request.getParameter("index") != null)
		{
			if(powers.equals(""))
				powers += "INDEX ("+column+")";
			else
				powers += ", INDEX ("+column+")";
		}
		if(request.getParameter("trigger") != null)
		{
			if(powers.equals(""))
				powers += "TRIGGER ("+column+")";
			else
				powers += ", TRIGGER ("+column+")";
		}
		
		if(request.getParameter("grant") != null)
			sql = "GRANT " + powers + " ON "+db+"."+table+" TO '" + user + "'@'localhost'"; 
		
		if(request.getParameter("revoke") != null)
			sql = "REVOKE " + powers + " ON "+db+"."+table+" FROM '" + user + "'@'localhost'"; 
		
		System.out.println(sql);
		try 
		{
			Statement grantRevoke = connection.createStatement();
			boolean b = grantRevoke.execute(sql);
			if(b == false)
			{
				response.sendRedirect("/FebflixDBA/html/scceed.jsp");
			}
			
		} 
		catch (SQLException e) 
		{
			response.sendRedirect("/FebflixDBA/html/failed.jsp");
			e.printStackTrace();
		}
	}

}