package com.training.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DataConnect {
	private static Connection con;
	private DataConnect() 
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineDepartmentStore","root","mysql");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConection()
	{
		DataConnect d=new DataConnect();
		return con;
	}
	public static void main(String[] args) {
		getConection();
	}
}
