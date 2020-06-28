package com.example.Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bank.Entity.Customer;
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
	public String login()
	{
		return "login";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("newCustomer") Customer customer)
	{
		
		return service.addNewUser(customer);
	}
	
}
