
package com.example.Bank.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.example.Bank.Entity.Account;
import com.example.Bank.Entity.Customer;

public interface BankDao {

	public String addCustomer(Customer cust);
	public String checkCustomer(String usr, String pswd);
	public String viewProfile(String username,Model theModel);
	public String viewBalance(String username, Model theModel);
	public String withdrawAmount(String username,String amount,Model theModel);
	public String depositAmount(String username, String balance, Model theModel);
	public String accountHistory(String username, Model theModel);
}
