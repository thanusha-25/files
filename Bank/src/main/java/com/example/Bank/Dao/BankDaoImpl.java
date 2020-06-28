package com.example.Bank.Dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Bank.Entity.Customer;
@Repository
@Transactional
public class BankDaoImpl implements BankDao{

	@PersistenceContext
	//@Autowired
	EntityManager entity;
	
	@Override
	public String addCustomer(Customer cust) {
//		Query query=entity.createNativeQuery("insert into customer(id,username,pswd,firstname,lastname,mobileNumber,branchId) values(0,"+cust.getUsername()+","+cust.getPswd()+","+cust.getFirstName()+"," +cust.getLastName()+","+cust.getMobileNo()+","+cust.getBranchId()+")");
//		int num=query.executeUpdate();
//		if(num==1)
//		return "success";
//		else
//		return "fail";
		entity.persist(cust);
		return "success";
	}

}
