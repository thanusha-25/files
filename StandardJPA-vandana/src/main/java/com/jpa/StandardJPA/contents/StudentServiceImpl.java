package com.jpa.StandardJPA.contents;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDaoImpl;
	
	@Autowired
	public StudentServiceImpl(StudentDAO studentDaoImpl)
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
	
//	@Transactional
//	public Student find(int id)
//	{
//		return studentDaoImpl.findById(id);
//	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Student findById(Integer id) {
		return studentDaoImpl.findById(id);
	}

	@Override
	public Student findByName(String name) {
		return studentDaoImpl.findByName(name);
	}
}
