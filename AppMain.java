package com.training.client;

import java.sql.SQLException;

import com.training.menu.*;

public class AppMain extends Thread{
	public void run()
	{
		LoginMenu login;
		try
		{
			login=new LoginMenu();
			login.loginMenuDisplay();
			Thread.sleep(100);
		}
		catch(SQLException |InterruptedException e )
		{
			e.getMessage();
		}
		
	}
	public static void main(String[] args) throws SQLException {
		AppMain main=new AppMain();
		main.start();
		try {
			main.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
