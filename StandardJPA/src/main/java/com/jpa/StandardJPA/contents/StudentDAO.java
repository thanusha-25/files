package com.jpa.StandardJPA.contents;

import java.util.*;

public interface StudentDAO {
	
	public List<Student> getAll();
	public String delete(int id);
	public Student findById(int id);
    public Student findByName(String name);
}
