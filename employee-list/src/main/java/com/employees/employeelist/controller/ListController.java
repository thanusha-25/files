package com.employees.employeelist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ListController {
	
	@Autowired
	private RestTemplate template;
	@GetMapping("/")
	public String invokeDisplay()
	{
		String url="http://DISPLAY-ALL/hello";
		return template.getForObject(url, String.class);
	}

}
