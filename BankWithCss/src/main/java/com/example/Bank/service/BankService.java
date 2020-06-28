package com.example.Bank.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import com.example.Bank.Dao.BankDao;
import com.example.Bank.Entity.Account;
import com.example.Bank.Entity.Customer;
import com.example.Bank.Entity.UserDetails;

@Service
public class BankService {

	@Autowired
	private BankDao dao;
	
	@Autowired
	BankService bank;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	String result;
	
	public String addNewUser( Customer cust)
	{
		result=dao.addCustomer(cust);
		if(result=="home")
		{
			String subject="Successfull Registration for bank portal...!!";
			String text="Hello "+cust.getUsername()+"...! \nWelcome to our online portal. \nYou have been registered successfully.\nHope you have a great day and enjoy our services..!! ";
			bank.sendMail(cust.getEmail(), "thanushareddy0305@gmail.com",subject,text);
//			System.out.println("hellllo....");
	   }
		return result;
	}

	public String validateLogin(UserDetails user)
	{
		String usr=user.getUsername();
		String pswd=user.getPswd();
		return dao.checkCustomer(usr, pswd);
	}
	
	public String viewProfile(String userName,Model theModel)
	{
		return dao.viewProfile(userName, theModel);
	}

	public String viewBalance(String username, Model theModel) {
		return dao.viewBalance(username, theModel);
	}


	public String withdraw(String username, String balance, Model theModel) {
		result=dao.withdrawAmount(username, balance, theModel);
		if(result=="success")
		{
			String accountNo=String.valueOf(theModel.getAttribute("accountNo"));
			String finalBalance=String.valueOf(theModel.getAttribute("balance"));
			String to=String.valueOf(theModel.getAttribute("email"));
			String subject="Transaction alert for your Bank Account";
			String text="Dear Customer, \n You have withdrawn Rs."+finalBalance+" from your account"+accountNo+".A/c Balance is Rs."+balance+".If you have any queries about this transaction,please reach out to our bank.\n This is an automated e-mail from an unattended mail box.Please do not reply to this email.";
			bank.sendMail(to, "thanushareddy0305@gmail.com",subject,text);
		}
		return result;
	}


	public String deposit(String username, String balance, Model theModel) {
		result=dao.depositAmount(username, balance, theModel);
		if(result=="success")
		{
			String accountNo=String.valueOf(theModel.getAttribute("accountNo"));
			String finalBalance=String.valueOf(theModel.getAttribute("balance"));
			String to=String.valueOf(theModel.getAttribute("email"));
			String subject="Transaction alert for your Bank Account";
			String text="Dear Customer, \n Your account "+accountNo+" is credited with Rs."+balance+".Current A/c Balance is Rs."+finalBalance+".If you have any queries about this transaction,please reach out to our bank.\n This is an automated e-mail from an unattended mail box.Please do not reply to this email.";
			bank.sendMail(to, "thanushareddy0305@gmail.com",subject,text);
		}
		return result;
	}


	public String accountHistory(String username, Model theModel) {	
		return dao.accountHistory(username,theModel);
	}
	
	public void sendMail(String to,String from,String subject,String text)
	{
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom(from);
		msg.setTo(to);
		msg.setText(text);
		msg.setSubject(subject);
		javaMailSender.send(msg);
	}
	
}
