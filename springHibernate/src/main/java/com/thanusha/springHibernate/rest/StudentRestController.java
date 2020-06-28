package com.thanusha.springHibernate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.thanusha.springHibernate.dao.StudentDAO;
import com.thanusha.springHibernate.dao.Student;
@RestController
public class StudentRestController {
	
	private StudentDAO studentDao;
	
	@Autowired
	public StudentRestController(StudentDAO studentDao)
	{
		this.studentDao=studentDao;
	}
	@GetMapping("/hi")
	public String hello()
	{
		return "hello";
	}
	
	@GetMapping("/students")
	public List<Student> findAll()
	{ 
		return studentDao.findAll();
	}
    
	@GetMapping("/students/{studentId}")
	public Student findById(@PathVariable int studentId)
	{
		Student student=studentDao.findById(studentId);
		if(student==null)
			throw new RuntimeException("no student witht that id");
		else
				return student;
		
	}
	
	@PostMapping("/student")
	public String add(@RequestBody Student stu)
	{
		return studentDao.add(stu);
		
	}
	
	@GetMapping("/remove/{studentId}")
	public String delete(@PathVariable int studentId)
	{
		return studentDao.remove(studentId);
				
	}
	@GetMapping("/update")
	public String update(@RequestBody Student stu)
	{
		return studentDao.update(stu);
		
	}
}
