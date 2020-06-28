package com.example.Bank.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="pswd")
	private String pswd;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="mobileNumber")
	private String mobileNo;
//	@Column(name="branchId")
//	private int branchId;
	
//	@OneToMany( mappedBy = "accountNo",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Account> accountNo;
	
//	public List<Account> getAccountNo() {
//		return accountNo;
//	}
//	public void setAccountNo(List<Account> accountNo) {
//		this.accountNo = accountNo;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
//	public int getBranchId() {
//		return branchId;
//	}
//	public void setBranchId(int branchId) {
//		this.branchId = branchId;
//	}
	public Customer(String username, String pswd, String firstName, String lastName, 
			String mobileNo) {
		super();
		//this.id = id;
		this.username = username;
		this.pswd = pswd;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
	}
	public Customer() {
		super();
	}
	
	
	
}
