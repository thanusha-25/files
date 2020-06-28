package com.thanusha.springHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DAOImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public DAOImpl(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}

	@Override
	@Transactional
	public List<Student> findAll() {
		Session currSession= entityManager.unwrap(Session.class);
		Query<Student> theStudent=currSession.createQuery("from Student",Student.class);
		List<Student> resStudent=theStudent.getResultList();
		return resStudent; 
	//	return null;
	}
    @Override
	@Transactional
	public Student findById(int id)
    {
		Session currSession=entityManager.unwrap(Session.class);
		String query="from Student s where s.id="+id;
		Query<Student> result=currSession.createQuery(query,Student.class);
		Student student=result.getSingleResult();
		return student;
	}



	@Override
	@Transactional
	public String add(Student s) {
		Session currSession=entityManager.unwrap(Session.class);
		String hql="insert into Student(id,name,email) "+"select "+s.getId()+","+s.getName()+","+s.getEmail()+" from s";
		Query result=currSession.createQuery(hql);
		int num=result.executeUpdate();
		if(num==1)
			return "added";
		else
		return null;
	}

	@Override
	@Transactional
	public String remove(int id) {
		Session currSession=entityManager.unwrap(Session.class);
		String query="delete from Student where id="+id;
		Query result=currSession.createQuery(query);
		int num=result.executeUpdate();
		if(num==1)
			return "deleted";
		else
			return "not";
	}
    
	@Override
	@Transactional
	public String update(Student stu) {
		Session currSession=entityManager.unwrap(Session.class);
		String query="update Student set name="+stu.getName()+","+"email="+stu.getEmail()+" where id="+stu.getId();
		Query result=currSession.createQuery(query);
		int num=result.executeUpdate();
		if(num==1)
			return "updated";
		else
		return "not";
	}

    

}
