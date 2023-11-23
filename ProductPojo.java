package com.training.pojo;

public class ProductPojo extends Item{
	private int productid;
	public ProductPojo()
	{
		
	}
	public ProductPojo(int productid,String productName,int availableQuntity)
	{
		super();
		this.productid=productid;
		this.productName=productName;
		this.availableQuntity=availableQuntity;
		
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice1(double price)
	{
		this.sellingprice=price;
	}
	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice+(sellingprice *0.5);
	}
	private String productName;
	private double sellingprice;
	private int availableQuntity;
	public int getAvailableQuntity() {
		return availableQuntity;
	}
	public void setAvailableQuntity(int availableQuntity) {
		this.availableQuntity = availableQuntity;
	}
	
	

}