package com.example.Bank.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@Column(name="account no")
	private int accountNo;
	@Column(name="balance")
	private int balance;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable=false)
	private Customer userId;
	@Column(name="branch id")
	private int branchId;
	public Account() {
		super();
	}
	public Account(int accountNo, int balance, Customer userId, int branchId) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.userId = userId;
		this.branchId = branchId;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Customer getUserId() {
		return userId;
	}
	public void setUserId(Customer userId) {
		this.userId = userId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
}
