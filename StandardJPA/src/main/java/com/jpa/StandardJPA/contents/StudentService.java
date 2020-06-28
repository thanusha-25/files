package com.jpa.StandardJPA.contents;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	private StudentDAOImpl studentDaoImpl;
	
	@Autowired
	public StudentService(StudentDAOImpl studentDaoImpl)
	{
		this.studentDaoImpl=studentDaoImpl;
	}
	
	@Transactional
	public List<Student> getAll()
	{
		return studentDaoImpl.getAll();
	}
	
	@Transactional
	public String remove(int id)
	{
		return studentDaoImpl.delete(id);
	}
	
	@Transactional
	public Student find(int id)
	{
		return studentDaoImpl.findById(id);
	}
}
