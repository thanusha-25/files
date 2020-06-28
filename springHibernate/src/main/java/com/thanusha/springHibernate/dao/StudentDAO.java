package com.thanusha.springHibernate.dao;

import java.util.*;

public interface StudentDAO {

	public List<Student> findAll();
	public Student findById(int id);
	public String add(Student student);
	public String remove(int id);
	public String update(Student student);
}
