package com.felipe.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.course.domain.User;
import com.felipe.course.repository.UserRepository;
import com.felipe.course.services.exception.ObjectNotFoundException;

@Service
public class UserService 
{
	@Autowired
	UserRepository repository;
	
	public List<User> findAll()
	{
		return repository.findAll();
	}
	
	public User findById(String id)
	{
		Optional<User> user=repository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
