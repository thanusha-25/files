package com.example.Bank.Dao;


import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.example.Bank.Entity.Account;
import com.example.Bank.Entity.Customer;
import com.example.Bank.Entity.History;
@Repository
@Transactional
public class BankDaoImpl implements BankDao{

	@Autowired
	EntityManager entity;

	
	@Override
	public String addCustomer(Customer cust) {
		String pswd=BCrypt.hashpw(cust.getPswd(), BCrypt.gensalt());
		String accNo=String.valueOf(Math.round(Math.random() * Math.pow(10, 15)));
//		System.out.println(cust.getEmail());
		Query query=entity.createNativeQuery("insert into customer(id,username,pswd,firstname,lastname,mobileNo,email) values("+cust.getId()+",'"+cust.getUsername()+"','"+pswd+"','"+cust.getFirstName()+"','"+cust.getLastName()+"','"+cust.getMobileNo()+"','"+cust.getEmail()+"')");    
		int num=query.executeUpdate();
		if(num==1)
		{
			query=entity.createNativeQuery("select accountNo from account");
			List<Account> accountList=query.getResultList();
			while(accountList.contains(accNo))
			{
				accNo=String.valueOf(Math.round(Math.random() * Math.pow(10, 15)));
			}
			Query query2=entity.createNativeQuery("select id from customer where username='"+cust.getUsername()+"'");
			List<Integer> id= query2.getResultList();
//			System.out.println(id);
			query2=entity.createNativeQuery("insert into account(accountNo,balance,id) values("+accNo+","+0+","+id.get(0)+")");
			 num=query2.executeUpdate();
			 if(num==1)
			 {
				 
				  return "home";
			 }
		}
	
		return "failure";
	}

	@Override
	public String checkCustomer(String usr, String pswd) {
		Query query=entity.createNativeQuery("select pswd from customer where username='"+usr+"'");
		List<String> result=query.getResultList();
		           if(result.size()==1)
		           {
		        	if (BCrypt.checkpw(pswd, result.get(0)))
		             return "login-success";
		           }
		return "failure";
		

	}

	

	@Override
	public String viewProfile(String username, Model theModel) {

		Customer user=new Customer();
		Query q = entity.createNativeQuery("SELECT c.username,c.firstname,c.lastname,c.mobileNo,c.id FROM customer c where c.username='"+username+"'");
		List<Object[]> users = q.getResultList();
		for (Object[] a : users) {
		   user.setUsername(String.valueOf(a[0]));
		   user.setFirstName(String.valueOf(a[1]));
		   user.setLastName(String.valueOf(a[2]));
		   user.setMobileNo(String.valueOf(a[3]));
		   user.setId(Integer.parseInt(String.valueOf(a[4])));
		}
		theModel.addAttribute("viewUser",user);
	    q=entity.createNativeQuery("select accountNo from account where id="+user.getId());
	    Object accountNo=q.getSingleResult();
	    theModel.addAttribute("accountNo",accountNo);
		return "display-profile";
	}

	@Override
	public String viewBalance(String username, Model theModel) {
		Query query=entity.createNativeQuery("select balance from account where id=(select id from customer where username='"+username+"'"+ ")");
		Object result=query.getSingleResult();
		int bal=Integer.parseInt(String.valueOf(result));
		theModel.addAttribute("viewBalance",bal);
		return "display-balance";
	}

	@Override
	public String withdrawAmount(String username, String amount, Model theModel){
		Query query=entity.createNativeQuery("select c.id from customer c where c.username='"+username+"'");
	int id=Integer.parseInt(String.valueOf(query.getSingleResult()));
	 query=entity.createNativeQuery("select c.email from customer c where c.username='"+username+"'");
	String email=(String.valueOf(query.getSingleResult()));
	theModel.addAttribute("email", email);
		query=entity.createNativeQuery("select balance,accountNo from account where id="+id);
		List<Object[]> users = query.getResultList();
		int prevBalance=0;
		String accountNo="";
		for (Object[] a : users) {
		   prevBalance=Integer.parseInt(String.valueOf(a[0]));
		   accountNo=(String.valueOf(a[1]));
		}
		int reqAmount=Integer.parseInt(amount);
		if(reqAmount<prevBalance)
		{	
			query=entity.createNativeQuery("update account set balance="+(prevBalance-reqAmount)+" where id="+id);
			if(query.executeUpdate()==1)
			{
				theModel.addAttribute("accountNo",accountNo);
				theModel.addAttribute("balance",(prevBalance-reqAmount));
				String activity="withdraw";
				query=entity.createNativeQuery("insert into history(activity,amount,balance,id,accountNo,date)values('"+activity+"',"+reqAmount+","+(prevBalance-reqAmount)+","+id+","+accountNo+",now())");
				query.executeUpdate();
			return "success";
			}
		}
		return "failure";
	}

	@Override
	public String depositAmount(String username, String balance, Model theModel) {
		Query query=entity.createNativeQuery("select c.id from customer c where c.username='"+username+"'");
	   int id=Integer.parseInt(String.valueOf(query.getSingleResult()));
	   query=entity.createNativeQuery("select c.email from customer c where c.username='"+username+"'");
		String email=(String.valueOf(query.getSingleResult()));
		theModel.addAttribute("email", email);
		query=entity.createNativeQuery("select balance,accountNo from account  where id="+id);
		List<Object[]> users = query.getResultList();
		int prevBalance=0;
		String accountNo="";
		for (Object[] a : users) {
		   prevBalance=Integer.parseInt(String.valueOf(a[0]));
		   accountNo=(String.valueOf(a[1]));
		}
		query=entity.createNativeQuery("update account set balance="+(Integer.parseInt(balance)+prevBalance)+" where id="+id);
		String activity="deposit";
		if(query.executeUpdate()==1)
		{
			theModel.addAttribute("accountNo",accountNo);
			theModel.addAttribute("balance",(prevBalance+Integer.parseInt(balance)));
			query=entity.createNativeQuery("insert into history(activity,amount,balance,id,accountNo,date)values('"+activity+"',"+balance+","+(Integer.parseInt(balance)+prevBalance)+","+id+","+accountNo+",now())");
			query.executeUpdate();
			
			return "success";
		}
		return "failure";
	}

	@Override
	public String accountHistory(String username, Model theModel) {
		Query query=entity.createNativeQuery("select id from customer where username='"+username+"'");
		int id=Integer.parseInt(String.valueOf(query.getSingleResult()));
		query=entity.createNativeQuery("select h.activity,h.amount,h.balance,h.date from history h where h.id="+id);
		List<Object[]> result=query.getResultList();
		List<History> historyList=new ArrayList<History>();
	
		for(Object a[]: result)
		{
    		History h=new History();
			h.setActivity(String.valueOf(a[0]));
			h.setAmount(Integer.parseInt(String.valueOf(a[1])));
			h.setBalance(Integer.parseInt(String.valueOf(a[2])));
			h.setDate(String.valueOf(a[3]));
			historyList.add(h);
		}
		theModel.addAttribute("list", historyList);
		return "display-summary";
	}

   
	
	
}
