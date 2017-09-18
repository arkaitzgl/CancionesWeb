package com.ipartek.formacion.canciones.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static String url = "jdbc:mysql://192.168.0.42:3306/spoty";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "alumno";
	private static String password = "alumno";
	private static Connection con;

	public static Connection getConnection() {
		try {

			Class.forName(driverName);
			con = DriverManager.getConnection(url, username, password);

		} catch (SQLException ex) {
			System.out.println("Failed to create the database connection.");
			ex.printStackTrace();

		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}