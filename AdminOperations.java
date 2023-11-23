package com.training.service;

import com.training.dao.AdminOperationDao;
import com.training.pojo.*;

import java.sql.SQLException;
import java.util.*;

public class AdminOperations 
{		AdminOperationDao admindao;
		private List<ProductPojo>productlist;
		private Scanner sc;
		public AdminOperations()
		{
			admindao=new AdminOperationDao();
			productlist=new ArrayList<ProductPojo>();
			sc=new Scanner(System.in);
			/*productmap=new HashMap<Integer,ProductPojo>();
			ProductPojo p1=new ProductPojo();
			p1.setCategory("electronics");
			p1.setItemName("laptop");
			p1.setProductid(101);
			p1.setProductName("laptop");
			p1.setBuyingPrice(25000);
			p1.setSellingprice(35000);
			p1.setAvailableQuntity(5);
			productmap.put(101,p1);
			ProductPojo p2=new ProductPojo();
			p2.setCategory("fruits");
			p2.setItemName("apple");
			p2.setProductid(102);
			p2.setProductName("apple");
			p2.setBuyingPrice(80);
			p2.setSellingprice(120);
			p2.setAvailableQuntity(6);
			productmap.put(102,p2);
			ProductPojo p3=new ProductPojo();
			p3.setCategory("fruits");
			p3.setItemName("orange");
			p3.setProductid(103);
			p3.setProductName("orange");
			p3.setBuyingPrice(40);
			p3.setSellingprice(60);
			p3.setAvailableQuntity(4);
			productmap.put(103,p3);*/
		}
		public void insertDetails() throws SQLException
		{
			System.out.println("Enter the products u want to be add ");
			int noofproducts=sc.nextInt();
			for(int x=0;x<noofproducts;x++)
			{
				ProductPojo product=new ProductPojo();
				System.out.println("Enter the category");
				//String cata=sc.next();
				product.setCategory(sc.next());
				System.out.println("item name");
				product.setItemName(sc.next());
				System.out.println("buying price");
			//	product.setSellingprice(sc.nextDouble());
				double price=sc.nextDouble();
				product.setBuyingPrice(price);
				product.setSellingprice(price);
				System.out.println("Enter the product id ");
				int productid=sc.nextInt();
				product.setProductid(productid);
				System.out.println("Enter the product name");
				product.setProductName(sc.next());
				System.out.println("Available quantity");
				product.setAvailableQuntity(sc.nextInt());
				//ProductPojo product1=new ProductPojo(cata);
				productlist.add(product);
				//productmap.put(product1);
			}
			admindao.insetProduct(productlist);
		}
	/*	public void calculateSellingPrice()
		{
			Set<Map.Entry<Integer,ProductPojo>>map=productmap.entrySet();
			for(Map.Entry<Integer,ProductPojo>productmap:map)
			{
				productmap.getValue().setSellingprice(productmap.getValue().getBuyingPrice()*0.5+productmap.getValue().getBuyingPrice());
			}
			
		}*/
		public void ListProducts() throws SQLException
		{   
			/*Set<Map.Entry<Integer,ProductPojo>>map=productmap.entrySet();
			for(Map.Entry<Integer,ProductPojo>productmap:map)
			{
				System.out.println("product name : "+productmap.getValue().getProductName());
				System.out.println("product available stock : "+productmap.getValue().getAvailableQuntity());
				System.out.println("product selling price : "+productmap.getValue().getSellingprice());*/
			admindao.listProducts();
				
		}
		public void ListProductsByCategory() throws SQLException
		{   
			
			System.out.println("Enter the category u want to search");
			String category=sc.next();
			/*Set<Map.Entry<Integer,ProductPojo>>map=productmap.entrySet();
			System.out.println(" products related to this category");
			for(Map.Entry<Integer,ProductPojo>productmap:map)
			{
				if(productmap.getValue().getCategory().equals(category))
				{
					
					System.out.println(productmap.getValue().getProductName());
				}
			}*/
			admindao.searchByCategory(category);
		}
		public void ListProductsByName() throws SQLException
		{
			System.out.println("Enter the product name u want to search");
			String name=sc.next();
			/*Set<Map.Entry<Integer,ProductPojo>>map=productmap.entrySet();
			System.out.println(" products related to your search");
			for(Map.Entry<Integer,ProductPojo>productmap:map)
			{
				if(productmap.getValue().getProductName().equals(name))
				{
					
					System.out.println(productmap.getValue().getProductName());
					System.out.println(productmap.getValue().getSellingprice());
					break;
				}
				else
				{
					System.out.println("There is no product like this");
				}
			}*/
			admindao.searchByName(name);
		}
		public void totalAmount() throws SQLException
		{
			double total=0;
			/*Set<Map.Entry<Integer,ProductPojo>>map=productmap.entrySet();
			for(Map.Entry<Integer,ProductPojo>productmap:map)
			{
				total=total+productmap.getValue().getBuyingPrice();
				
			}*/
			admindao.totalSpendAmount();
			//System.out.println("Total amount spend on products : "+total);
		}
		public void displayProfitByCategory() throws SQLException
		{ 
			System.out.println("Enter the category u want to show the profit");
			//double profit=0;
			String cat=sc.next();
			/*Set<Map.Entry<Integer,ProductPojo>>map=productmap.entrySet();
			for(Map.Entry<Integer,ProductPojo>productmap:map)
			{
				if(productmap.getValue().getCategory().equals(cat))
				{
					profit=profit+productmap.getValue().getSellingprice()-productmap.getValue().getBuyingPrice();
				}
						
			}
			System.out.println("profit of "+cat +"is : "+profit);*/
			admindao.displayProfitByCategory(cat);
		}
		/*public void sortByprice()
		{
			Set<Map.Entry<Integer,ProductPojo>> map=productmap.entrySet();
			map.stream().sorted(new SortByPriceComparator()).forEach(n->
			{
				System.out.println("product name"+n.getValue().getProductName());
				System.out.println("price : "+n.getValue().getSellingprice());
			});
			
		}*/
		

}

