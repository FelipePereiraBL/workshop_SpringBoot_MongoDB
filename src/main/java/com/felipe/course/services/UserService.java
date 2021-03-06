package com.felipe.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.course.domain.User;
import com.felipe.course.dto.UserDTO;
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
	
	public User insert(User obj)
	{
		return repository.insert(obj);
	}
	
	public void delete(String id)
	{
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj)
	{
		User newObj=findById(obj.getId());
		
		UpdateData(newObj,obj);
		return repository.save(newObj);
	}
	
	private void UpdateData(User newObj, User obj) 
	{
		newObj.setName(obj.getName());
    	newObj.setEmail(obj.getEmail());	
		
	}

	public User fromDTO(UserDTO objDTO)
	{
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}

}
