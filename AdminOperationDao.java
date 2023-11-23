package com.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.training.connect.DataConnect;
import com.training.pojo.ProductPojo;
import com.training.pojo.UserPojo;

public class AdminOperationDao {
	private Connection con;
	private UserPojo user;
	private PreparedStatement stat;
	List<ProductPojo> productlist;
    public AdminOperationDao() 
	{
		con=DataConnect.getConection();
		user=new UserPojo();
		productlist=new ArrayList<>();
		try {
			stat=con.prepareStatement("select * from Product");
			ResultSet result=stat.executeQuery();
			while(result.next())
			{
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
    public void insetProduct(List<ProductPojo> productlist) throws SQLException
    {  
    	con.setAutoCommit(false);
    	stat=con.prepareStatement("insert into Product values(?,?,?,?,?,?,?)");
    	for(ProductPojo p :productlist)
    	{
    		stat.setInt(1,p.getProductid());
    		stat.setString(2, p.getProductName());
    		stat.setDouble(3,p.getSellingprice());
    		stat.setInt(4, p.getAvailableQuntity());
    		stat.setString(5,p.getItemName());
    		stat.setString(6,p.getCategory());
    		stat.setDouble(7,p.getBuyingPrice());
    		stat.addBatch();
    	}
    	int[] result=stat.executeBatch();
    	if(result[0]>0)
    	{
    		System.out.println("inserted");
    	}
    	else
    	{
    		System.out.println("unable to insert");
    	}
    	con.setAutoCommit(true);
    }
	public void listProducts() throws SQLException 
	{
	/*stat=con.prepareStatement("select * from Product");
	ResultSet result=stat.executeQuery();
	while(result.next())
	{
		System.out.println("product id : "+result.getInt(1));
		System.out.println("Product name : "+result.getString(2));
		System.out.println("Category : "+result.getString(6));
		System.out.println("Available quantity : "+result.getInt(4));
		System.out.println("Selling price : "+result.getDouble(3));
	}*/
		for(ProductPojo p:productlist)
		{
			System.out.println("product id : "+p.getProductid());
			System.out.println("Product name : "+p.getProductName());
			System.out.println("Category : "+p.getCategory());
			System.out.println("Available quantity : "+p.getAvailableQuntity());
			System.out.println("Selling price : "+p.getSellingprice());
			System.out.println("buyig price : "+p.getBuyingPrice());
			System.out.println("---------------------------------------");
		}
		
	}
	public void searchByCategory(String category) throws SQLException {
		stat=con.prepareStatement("select * from Product where category='"+category+"'");
		ResultSet res=stat.executeQuery();
		if(!res.next())
		{
			System.out.println("No category like this");
		}
		else
		{
		while(res.next())
		{
			System.out.println("Product name : "+res.getString(2));
			System.out.println("Product price : "+res.getString(3));
		}
		}
		
		
		
	}
	public void searchByName(String name) throws SQLException {
		boolean found =false;
		stat=con.prepareStatement("select * from Product where productname='"+name+"'");
		ResultSet res=stat.executeQuery();
		while(res.next())
		{
			found=true;
			System.out.println("Product name : "+res.getString(2));
			System.out.println("Product price : "+res.getString(3));
		}
		if(found==false)
		{
			System.out.println("No product like this");
		}
		
		
	}
	public void totalSpendAmount() throws SQLException {
		double total=0;
		stat=con.prepareStatement("select buyingprice from Product");
		ResultSet result=stat.executeQuery();
		while(result.next())
		{
			total=total+result.getDouble(1);
		}
		System.out.println("Total Amount Spended is : "+total);
		
	}
	public void displayProfitByCategory(String cat) throws SQLException {
		double profit=0.0;
		stat=con.prepareStatement("select sellingprice,buyingprice from Product where category='"+cat+"'");
		ResultSet result=stat.executeQuery();
		while(result.next())
		{
			profit=profit+result.getDouble(1)-result.getDouble(2);
		}
		System.out.println("Total Amount spend for category "+cat+" : "+profit);
	}
}
