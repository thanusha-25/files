package com.example.Bank.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username")
	@Size(min=4,max=8,message="Username must be  between 4 and 8 characters")
	private String username;
	@Column(name="pswd")
	@Size(min=5,max=8,message="Username must be  between 4 and 8 characters")
	private String pswd;
	@Column(name="firstname")
	@Size(min=1,max=15,message="Username must be  between 4 and 8 characters")
	private String firstName;
	@Size(min=1,max=15,message="Username must be  between 4 and 8 characters")
	@Column(name="lastname")
	private String lastName;
	@Size(min=10,max=10,message="Username must be  between 4 and 8 characters")
	@Column(name="mobileNo")
	private String mobileNo;
	@Column(name="email")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Customer(int id,String username, String pswd, String firstName, String lastName, 
			String mobileNo) {
		super();
		this.id = id;
		this.username = username;
		this.pswd = pswd;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
	}
	public Customer() {
		super();
	}
	
	public Customer(String username, String pswd) {
		super();
		this.username = username;
		this.pswd = pswd;
	}
	
}
