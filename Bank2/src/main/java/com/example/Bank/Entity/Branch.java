package com.example.Bank.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class Branch {

	@Id
	@Column(name="branchId")
	private int branchId;
	@Column(name="branch_name")
	private String branchName;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zipcode")
	private int zipcode;
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branhId) {
		this.branchId = branhId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public Branch() {
		super();
	}
	public Branch(int branchId, String branchName, String city, String state, int zipcode) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	
}
