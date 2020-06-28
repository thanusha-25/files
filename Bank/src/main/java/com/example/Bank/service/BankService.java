package com.example.Bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.Dao.BankDao;
import com.example.Bank.Entity.Customer;

@Service
public class BankService {

	@Autowired
	private BankDao dao;
	
	public String addNewUser(Customer cust)
	{
		return dao.addCustomer(cust);
	}
}
