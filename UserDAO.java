package com.training.dao;
import com.training.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.training.connect.DataConnect;
import com.training.pojo.UserPojo;
import com.training.menu.*;
public class UserDAO {
	private Connection con;
	private UserPojo user;
	private PreparedStatement stat;
	private List<UserPojo>userlist;
	UserMenu umenu=new UserMenu();
	AdminMenu admin=new AdminMenu();
	public UserDAO()
	{
		con=DataConnect.getConection();
		userlist=new ArrayList<>();
		try {
			stat=con.prepareStatement("select * from user");
			ResultSet r=stat.executeQuery();
			while(r.next())
			{
				user=new UserPojo();
				user.setUsername(r.getString(1));
				user.setPassword(r.getString(2));
				user.setUsertype(r.getString(3));
				user.setEmail(r.getString(4));
				user.setSupercoins(r.getInt(5));
				userlist.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void validateAdmin(String username, String password) throws SQLException
	{
		boolean found= false;
		for(UserPojo u:userlist)
		{
			if(u.getUsername().equals(username) && u.getPassword().equals(password)&&u.getUsertype().equals("admin"))
			{
				found=true;
				System.out.println("welcome to admin page");
				admin.adminMenudisplay();
			}
		}
		if(!found)
		{
			System.out.println("invalid user");
		}
		
	}
	
	public void insertUser(List<UserPojo> userlist) throws SQLException 
	{
		con.setAutoCommit(false);
		stat=con.prepareStatement("insert into user values(?,?,?,?,?)");
		for(UserPojo u:userlist)
		{
		stat.setString(1,u.getUsername());
		stat.setString(2,u.getPassword());
		stat.setString(3,"user");
		stat.setString(4, u.getEmail());
		stat.setInt(5,100);
		stat.addBatch();
		}
		int result[]=stat.executeBatch();
		if(result[0]>0)
		{
			System.out.println("sucessfully inserted");
		}
		con.setAutoCommit(true);
	}
	public void validateUser(String user, String pass) throws SQLException {
		boolean found= false;
		for(UserPojo u:userlist)
		{
			if(u.getUsername().equals(user) && u.getPassword().equals(pass)&&u.getUsertype().equals("user"))
			{
				found=true;
				int bonus=u.getSupercoins();
				String username=u.getUsername();
				umenu.userDisplayMenu(bonus,username);
			}
		}
		if(found)
		{
			System.out.println("welcome to online shop ");
		}
		else
		{
			
			System.out.println("invalid user");
		}
		
	}

}
