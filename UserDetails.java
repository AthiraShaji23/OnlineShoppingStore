package com.training.service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.training.dao.UserDAO;
import com.training.pojo.*;

public class UserDetails {
	private UserDAO userdao;
	private List<UserPojo>userlist;
	private Scanner sc;
	public UserDetails()
	{
		userdao=new UserDAO();
		sc=new Scanner(System.in);
		userlist=new LinkedList<UserPojo>();
	UserPojo user=new UserPojo();
	//UserPojo user1=new UserPojo("user1","user1");
	//UserPojo user2=new UserPojo("user2","user2");
	//userlist.add(admin);
	//userlist.add(user1);
	//userlist.add(user2);
	
	}
	
	public void acceptDetails() throws SQLException
	{
		//System.out.println("Enter the no.of users u have to add");
		//int noofusers=sc.nextInt();
		//for(int x=0;x<noofusers;x++)
		//{
			UserPojo u=new UserPojo();
			System.out.println("Enter the user name");
			u.setUsername(sc.next());
			System.out.println("Enter the passwod");
			u.setPassword(sc.next());
			System.out.println("Enter the emailid");
			u.setEmail(sc.next());
			u.setSupercoins(100);
			System.out.println("User get 100 super coins as welcome bonus");
			userlist.add(u);
		//}
		//System.out.println("User registered sucessfully");
		userdao.insertUser(userlist);
	}
	public void validateAdmin() throws SQLException
	{
		System.out.println("Enter the username");
		String username=sc.next();
		System.out.println("Enter the password");
		String password=sc.next();
		/*boolean found=false;
		if(username.equals("admin")&&password.equals("admin"))
		{
			System.out.println("welcome to admin page");
		}
		else
		{
		   found=userlist.stream().anyMatch(user-> user.getUsername().equals(username) && user.getPassword().equals(password));
				  if(!found)
				  {
					  System.out.println("incorrect username or password");
				  }
				  else
				  {
					  System.out.println("user login sucessfully");
				  }
		}*/
		userdao.validateAdmin(username,password);
	}
	public void validateUser() throws SQLException
	{
		System.out.println("Enter the username");
		String user=sc.next();
		System.out.println("Enter the passwrd");
		String pass=sc.next();
		userdao.validateUser(user,pass);
		
	}
		
	
}
