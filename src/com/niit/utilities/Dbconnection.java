package com.niit.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection
{
		
		public static Connection connect() throws ClassNotFoundException, SQLException
		{
			String pwd;
			pwd = "password@123";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dairy_farm","root",pwd);
			System.out.println("Connection"+conn);
			return conn;
		}
}