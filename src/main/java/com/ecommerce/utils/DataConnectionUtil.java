package com.ecommerce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnectionUtil {
	
public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Postgresql Driver went wrong.");
		}
		
		
		
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=e-commerce";
		String username = "postgres";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
		
	}

}
