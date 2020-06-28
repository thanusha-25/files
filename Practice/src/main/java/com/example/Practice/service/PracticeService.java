package com.example.Practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Practice.Entity.*;
import com.example.Practice.DAO.DaoImpl;

@Service
public class PracticeService {

	@Autowired
	public DaoImpl dao;
	
	public List<User> displayAll()
	{
		return dao.findAll();
	}
	public String save(User user)
	{
		return dao.save(user);
	}
	public String check(User user)
	{
		return dao.check(user);
	}
}
