package com.jpa.StandardJPA.contents;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

//import com.thanusha.springHibernate.dao.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;
	
	public StudentDAOImpl(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}
	
	@Override
	public List<Student> getAll() {
		Query query=entityManager.createQuery("from Student");
		List<Student> students=query.getResultList();
		return students;
	}

	@Override
	public String delete(int id) {
		Query query=entityManager.createQuery("delete from Student where id ="+id);
		int num=query.executeUpdate();
		if(num==1)
			return "deleted";
		else
			return "not deleted";
	}

	@Override
	public Student findById(Integer id) {
		Student student=entityManager.find(Student.class,id);
		return student;
	}

	@Override
	public Student findByName(String name) {

		String query="from Student s where s.name='"+name+"'";
		Student student=entityManager.createQuery(query,Student.class).getSingleResult();
			return student;
		
	}
	
	
}
