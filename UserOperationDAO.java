package com.training.dao;

import java.sql.*;
import java.util.*;

import com.training.connect.DataConnect;
import com.training.pojo.ProductPojo;
import com.training.service.SortByPriceComparator;

public class UserOperationDAO {
	private Connection con;
	private PreparedStatement stat;
	private Scanner sc;
	private List<ProductPojo>productlist;
	private List<ProductPojo> cartlist;
	public UserOperationDAO()
	{
		super();
		sc=new Scanner(System.in);
		con=DataConnect.getConection();
		productlist=new ArrayList<>();
		cartlist=new ArrayList<ProductPojo>();
		try {
			stat=con.prepareStatement("select * from Product");
			ResultSet result=stat.executeQuery();
			while(result.next())
			{
				//System.out.println("selling price : "+result.getDouble(3));
				ProductPojo product=new ProductPojo();
				product.setProductid(result.getInt(1));
				product.setProductName(result.getString(2));
				product.setSellingprice1(result.getDouble(3));
				product.setAvailableQuntity(result.getInt(4));
				product.setItemName(result.getString(5));
				product.setCategory(result.getString(6));
				product.setBuyingPrice(result.getDouble(7));
				productlist.add(product);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void listProducts() throws SQLException {
		
		for(ProductPojo p :productlist)
		{
			System.out.println("Product id : "+p.getProductid());
			System.out.println("Product name : "+p.getProductName());
			System.out.println("price : "+p.getSellingprice());
			System.out.println("-------------------------------");
		}
	}
	public void listProductsByName()
	{
		System.out.println("enter product name");
		String name=sc.next();
		boolean found=false;
		for(ProductPojo p:productlist)
		{
			if(p.getProductName().equalsIgnoreCase(name))
			{
				found=true;
				System.out.println("product id : "+p.getProductid());
				System.out.println(("product name : "+p.getProductName()));
				System.out.println("price : "+p.getSellingprice());
			}
			
		}
		if(!found)
		{
			System.out.println("product is not avialable");
		}
		
	}
	public void listProductById()
	{
		boolean found=false;
		System.out.println("enter product id");
		int id=sc.nextInt();
		for(ProductPojo p:productlist)
		{
			if(p.getProductid()==id)
			{
				found=true;
				System.out.println("product id : "+p.getProductid());
				System.out.println(("product name : "+p.getProductName()));
				System.out.println("price : "+p.getSellingprice());
			}
		}
		if(!found)
		{
			System.out.println("No matching product try another id");
		}
	}
	public void sortByPrice()
	{
		productlist.stream().sorted(new SortByPriceComparator()).forEach(n->
		{
			System.out.println("product name "+n.getProductName());
			System.out.println("Product price "+n.getSellingprice());
			System.out.println("------------------------------------");
		});
		
	}
	public void sortByCategory()
	{
		System.out.println("enter the category u want search");
		String cat=sc.next();
		boolean found=false;
		found=productlist.stream().anyMatch(s->s.getCategory().equalsIgnoreCase(cat));
		productlist.stream().filter(str->str.getCategory().equals(cat)).forEach(s->
		{
			System.out.println("Product name :"+s.getProductName());
			System.out.println("Price of product: "+s.getSellingprice());
			System.out.println("available quantity : "+s.getAvailableQuntity());
			System.out.println("------------------------------------------");
		});
	if(!found)
	{
		System.out.println("No matching category!!!!!!!");
	}
	}
	public void PurchaseItem(int bonus,String username) {
		String ch="y";
		while(ch.equalsIgnoreCase("y"))
		{
		System.out.println("enter the product");
		String product=sc.next();
		
		boolean found=false;
		
		for(ProductPojo p:productlist)
		{
			if(p.getProductName().equalsIgnoreCase(product))
			{
				cartlist.add(p);
				found=true;
			}	
		}
		if(!found)
		{
			System.out.println("no matching product!!!! try another name");
		}
		else
		{
			System.out.println("product add sucessfully");
		}
		System.out.println("you want to add more products to cart y/n");
		ch=sc.next();
		}
		double total=0.0;
		System.out.println("*******Bill*******");
		for(ProductPojo c:cartlist)
		{
			
			System.out.println("Product name : "+c.getProductName());
			System.out.println("Price : "+c.getSellingprice());
			System.out.println("------------------");
			total=total+c.getSellingprice();
		}
		int supercoin=(bonus/20);
		 total=total-supercoin;
		System.out.println("--Total--: "+total);
		try {
			stat=con.prepareStatement("update  user set welcomebonus="+0+" where user_name='"+username+"'");
			int rs=stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
