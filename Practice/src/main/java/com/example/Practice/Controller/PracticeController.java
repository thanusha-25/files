package com.example.Practice.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practice.Entity.User;
import com.example.Practice.service.PracticeService;


@Controller
public class PracticeController {

	@Autowired
	public PracticeService service;
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	@RequestMapping("/display")
	public String display(Model theModel)
	{
		List<User> list=service.displayAll();
		theModel.addAttribute("list",list);
		return "display";
	}
	@RequestMapping("/insert")
	public String insert(Model theModel)
	{
		User user=new User();
		theModel.addAttribute("newUser",user);
		return "insert";
	}
	
	@PostMapping("/save")
	   public String add(@Valid @ModelAttribute ("newUser") User user,BindingResult bindingResult)
	   {
           if(bindingResult.hasErrors())
        	   return "error";
           else
		 return  service.save(user);
		 
	   }
	
	@RequestMapping("/login")
	public String login(Model theModel)
	{
		User user=new User();
		theModel.addAttribute("newUser",user);
		return "login";
	}
	
	@RequestMapping("/check")
	public String check(@ModelAttribute("newUser")User user )
	{
		return service.check(user);
	}
}
