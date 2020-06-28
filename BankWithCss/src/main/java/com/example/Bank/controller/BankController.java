package com.example.Bank.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Bank.Entity.Account;
import com.example.Bank.Entity.Customer;
import com.example.Bank.Entity.UserDetails;
import com.example.Bank.service.BankService;

@Controller
public class BankController {

	@Autowired
	private BankService service;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/signup")
	public String signup(Model theModel)
	{
		Customer customer=new Customer();
		theModel.addAttribute("newCustomer",customer);
		return "signup";
	}
	
	@GetMapping("/login")
	public String login(Model theModel)
	{
	theModel.addAttribute("user",new UserDetails());
	return "login";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("newCustomer") Customer customer,Errors errors)
	{
		if(errors.hasFieldErrors())
			return "failure";
		else
		return service.addNewUser(customer);
	
	}
	
	@PostMapping("/checkLogin")
	public String checkLogin(@ModelAttribute("user")UserDetails cust,Model theModel)
	{
		theModel.addAttribute("validUser", cust.getUsername());
		return service.validateLogin(cust);	
	}
	
	@PostMapping("/success")
	public String success(@ModelAttribute("user")UserDetails user)
	{
		return "success";
	}
	
	
	@RequestMapping("/viewProfile/{user}")
	public String viewProfile(@PathVariable("user")String username,Model theModel)
	{
		return service.viewProfile(username, theModel);
	}
	
	@RequestMapping("/viewBalance/{user}")
	public String viewBalance(@PathVariable("user") String username,Model theModel)
	{
		return service.viewBalance(username,theModel);
	}
	
	@RequestMapping("/withdrawAmount/{user}")
	public String withdrawAmount(@PathVariable("user")String username,Model theModel)
	{
		theModel.addAttribute("username",username);
		return "withdraw-page";
	}
	
	@PostMapping("withdrawAmount/{user}")
	public String withdraw(@PathVariable("user")String username,@RequestParam("balance")String balance,Model theModel)
	{
		return service.withdraw(username,balance,theModel);
	}
	
	@RequestMapping("deposit/{user}")
	public String deposit(@PathVariable("user")String username,Model theModel)
	{
		theModel.addAttribute("username",username);
		return "deposit-page";
	}
	
	@PostMapping("deposit/{user}")
	public String depositAmount(@PathVariable("user")String username,@RequestParam("balance")String balance,Model theModel)
	{
		return service.deposit(username,balance,theModel);
	}
	
	@RequestMapping("/accountSummary/{user}")
	public String accountSummary(@PathVariable("user")String username,Model theModel)
	{
		return service.accountHistory(username,theModel);
	}
	
}
