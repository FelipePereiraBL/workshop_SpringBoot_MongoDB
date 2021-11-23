package com.felipe.course.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.course.domain.User;
import com.felipe.course.dto.UserDTO;
import com.felipe.course.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource
{
	@Autowired
	UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll()
	{		
		List<User>list=service.findAll();
		
		List<UserDTO>listDto=list.stream().map(X->new UserDTO(X)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}

}
