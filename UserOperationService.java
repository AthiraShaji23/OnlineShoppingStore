package com.training.service;

import java.sql.SQLException;

import com.training.dao.UserOperationDAO;

public class UserOperationService {
	UserOperationDAO userdao=new UserOperationDAO();

		public void listDisplay() throws SQLException 
		{
		userdao.listProducts();	
		}
		public void searchByName()
		{
			userdao.listProductsByName();
		}
		public void searchByid()
		{
			userdao.listProductById();
		}
		public void sortByPrice()
		{
			userdao.sortByPrice();
		}
		public void sortByCategory()
		{
			
			userdao.sortByCategory();
		}
		public void purchaseItem(int bonus,String username)
		{
			userdao.PurchaseItem(bonus, username);
		}
	}
	
