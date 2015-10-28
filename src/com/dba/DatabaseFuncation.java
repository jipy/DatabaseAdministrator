package com.dba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseFuncation {

	public DatabaseFuncation() {

	}
	
	public ArrayList<String> getUsers(Connection connection)
			throws SQLException {
		String sql = "SELECT user FROM mysql.user WHERE Host='localhost' AND User != '' AND User != 'root' AND User != 'debian-sys-maint';";
		Statement getUsers = connection.createStatement();
		ResultSet result = getUsers.executeQuery(sql);

		ArrayList<String> ar = new ArrayList<String>();

		while (result.next()) {
			String user = result.getString(1);
			ar.add(user);
		}
		return ar;
	}

	public ArrayList<String> checkUserPriv(Connection connection,
			String username) throws SQLException {
		String sql = "Show Grants for'" + username + "'@'localhost';";
		Statement checkUserPriv = connection.createStatement();
		ResultSet result = checkUserPriv.executeQuery(sql);
		ArrayList<String> ar = new ArrayList<String>();

		while (result.next()) {
			String userPriv = result.getString(1);
			ar.add(userPriv);
		}
		return ar;
	}

	public ArrayList<String> getDatabases(Connection connection)
			throws SQLException {
		String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME !='information_schema'";

		Statement getDB = connection.createStatement();
		ResultSet result = getDB.executeQuery(sql);

		ArrayList<String> ar = new ArrayList<String>();

		while (result.next()) {
			String database = result.getString(1);
			ar.add(database);
		}
		return ar;
	}

	public ArrayList<String> getDBTables(String db, Connection connection)
			throws SQLException {
		String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='"
				+ db + "'";

		Statement getDBTables = connection.createStatement();
		ResultSet result = getDBTables.executeQuery(sql);

		ArrayList<String> ar = new ArrayList<String>();

		while (result.next()) {
			String databaseTable = result.getString(1);
			ar.add(databaseTable);
		}
		return ar;
	}

	public ArrayList<String> getDBTableColumns(String db, String table,
			Connection connection) throws SQLException {
		String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA='"
				+ db + "' AND TABLE_NAME='" + table + "'";

		Statement getDBTableColumns = connection.createStatement();
		ResultSet result = getDBTableColumns.executeQuery(sql);

		ArrayList<String> ar = new ArrayList<String>();

		while (result.next()) {
			String databaseTableColumn = result.getString(1);
			ar.add(databaseTableColumn);
		}
		return ar;
	}

	public boolean createUser(String username, String pass,
			Connection connection) throws SQLException {
		String sql = "CREATE USER '" + username
				+ "'@'localhost' IDENTIFIED BY '" + pass + "';";
		Statement newUser = connection.createStatement();
		boolean b = newUser.execute(sql);
		return b;
	}
}
