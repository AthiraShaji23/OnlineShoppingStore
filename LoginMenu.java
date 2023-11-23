package com.training.menu;
import com.training.service.*;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginMenu {
	
    public void loginMenuDisplay() throws SQLException
    {
    	UserDetails user =new UserDetails();
    	AdminMenu admin=new AdminMenu();
    	UserMenu op=new UserMenu();
    	 Scanner sc=new Scanner(System.in);
    	String choice="y";
    	int ch=0;
    	while(choice.equals("y"))
    	{
    		System.out.println("Welcome to online store");
    		System.out.println("1.login as admin");
    		System.out.println("2.login as user");
    		System.out.println("3.New registration");
    		System.out.println("4.Exit");
    		ch=sc.nextInt();
    		 
    		switch(ch)
    		{
    		case 1:
    			
    			user.validateAdmin();
    			//admin.adminMenudisplay();
    			break;
    		case 2:
    			
    			user.validateUser();
    			//op.userDisplayMenu();
    			break;
    		case 3:
    			
    			user.acceptDetails();
    			break;
    		case 4:
    			System.exit(0);
    		}
    		System.out.println("Do u want to cotinue(y/n)");
			choice=sc.next();
    	}
    }
	
}
