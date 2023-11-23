package com.training.menu;

import com.training.service.*;

import java.sql.SQLException;
import java.util.Scanner;


public class AdminMenu {
	AdminOperations admin=new AdminOperations();
	public void adminMenudisplay() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		String choice="y";
		while(choice.equals("y"))
		{
			System.out.println("1.insert products");
			System.out.println("2.list all the products");
			System.out.println("3.Search products by category");
			System.out.println("4.Search products by name");
			System.out.println("5.Total spended Amount");
			System.out.println("6.categorywise profit");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				admin.insertDetails();
				//admin.calculateSellingPrice();
				break;
			case 2:
				admin.ListProducts();
				break;
			case 3:
				admin.ListProductsByCategory();
				break;
			case 4:
				admin.ListProductsByName();
				break;
			case 5:
				admin.totalAmount();
				break;
			case 6:
				admin.displayProfitByCategory();
				break;
			case 7:
				System.exit(0);
			}
			System.out.println("do you want to continue y/n");
			choice=sc.next();
		}
	}

}