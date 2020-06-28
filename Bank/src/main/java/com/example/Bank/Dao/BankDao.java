package com.example.Bank.Dao;

import org.springframework.stereotype.Repository;

import com.example.Bank.Entity.Customer;

public interface BankDao {

	public String addCustomer(Customer cust);
	
}
