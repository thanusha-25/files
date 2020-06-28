package com.example.Bank.Entity;

public class UserDetails {

	private String username;
	private String pswd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public UserDetails(String username, String pswd) {
		super();
		this.username = username;
		this.pswd = pswd;
	}
	public UserDetails()
	{
		
	}
	
}
