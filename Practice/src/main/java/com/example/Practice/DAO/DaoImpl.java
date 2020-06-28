package com.example.Practice.DAO;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Practice.Entity.User;

@Repository
@Transactional
public class DaoImpl implements PracticeDao{

	@Autowired
	EntityManager entityManager;
	@Override
	public List<User> findAll() {
		Query query=entityManager.createQuery("from User");
		List<User> users=query.getResultList();
		return users;
	}
	@Override
	public String save(User user) {
		String encryptPswd=BCrypt.hashpw(user.getPswd(), BCrypt.gensalt());
		Query query=entityManager.createNativeQuery("insert into user(id,pswd) values("+user.getId()+",'"+encryptPswd+"')");
		int num=query.executeUpdate();
		if(num==1)
		return "save";
		else
			return "display";

	}
	@Override
	public String check(User user) {
		Query query=entityManager.createQuery("select pswd from User where id="+user.getId());
		String pswd=(String) query.getSingleResult();
		if(BCrypt.checkpw(user.getPswd(), pswd))
			return "valid";
		else
		return "error";
	}
	
}
