package com.felipe.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.course.domain.User;
import com.felipe.course.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository repository;
	
	public List<User> findAll()
	{
		return repository.findAll();
	}

}
