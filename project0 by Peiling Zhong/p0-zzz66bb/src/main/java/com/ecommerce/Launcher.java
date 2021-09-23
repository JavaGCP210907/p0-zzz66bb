package com.ecommerce;


import java.sql.SQLException;

import com.ecommerce.models.Menu;
import com.ecommerce.utils.DataConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		try {
			DataConnectionUtil.getConnection();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Database connection failed.");
		}
		
		Menu m = new Menu();
		m.displayMenu();
	}

}


