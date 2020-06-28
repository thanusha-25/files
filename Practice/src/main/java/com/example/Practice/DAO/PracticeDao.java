package com.example.Practice.DAO;

import java.util.List;

import com.example.Practice.Entity.User;

public interface PracticeDao {
public List<User> findAll();
public String save(User user);
public String check(User user);
}
