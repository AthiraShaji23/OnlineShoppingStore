package com.training.menu;


import com.training.service.*;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {
	public void userDisplayMenu(int bonus,String username) throws SQLException
	{	
		//AdminOperations a=new AdminOperations();
		UserOperationService user=new UserOperationService();
		Scanner sc=new Scanner(System.in);
		String choice="y";
		while(choice.equals("y"))
		{
			System.out.println("1.list products");
			System.out.println("2.Search products by name");
			System.out.println("3.search products by id");
			System.out.println("4.show price low to high");
			System.out.println("5.filter by category");
			System.out.println("6.buy product");
			
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				user.listDisplay();
				//a.ListProducts();
				break;
			case 2:
				user.searchByName();
				break;
			case 3:
			   //a.sortByprice();
				user.searchByid();
			   break;
			case 4:
				user.sortByPrice();
				break;
			case 5:
				user.sortByCategory();
				break;
			case 6:
				user.purchaseItem(bonus, username);
			    break;
			
			
			}
			System.out.println("do you want to continue y/n");
			choice=sc.next();
	}

}
}