package com.training.pojo;

public class UserPojo {
	private String usertype;
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	private  String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private  String password;
	private  String email;
	private  int supercoins;
	public int getSupercoins() {
		return supercoins;
	}
	public void setSupercoins(int supercoins) {
		this.supercoins = supercoins;
	}
	public  UserPojo()
	{
		
	}
	public UserPojo(String username,String password)
	{
		this.username=username;
		this.password=password;
		//this.email=email;
	}
}
