package com.jpa.StandardJPA.contents;

import java.util.List;

public interface StudentService {


		public List<Student> getAll();
		public String delete(int id);
		public Student findById(Integer id);
		public Student findByName(String name);
	}

	

