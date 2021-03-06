package com.felipe.course.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipe.course.domain.Post;
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
	
	@GetMapping(value="/{id}")
	public ResponseEntity< UserDTO> findById(@PathVariable String id)
	{
		User user=service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@GetMapping(value="/{id}/posts")
	public ResponseEntity< List<Post>> findPosts(@PathVariable String id)
	{
		User user=service.findById(id);
		
		return ResponseEntity.ok().body(user.getPosts());
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO)
	{
		User user=service.fromDTO(objDTO);
		
		user=service.insert(user);
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity< Void> delete(@PathVariable String id)
	{
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objDTO,@PathVariable String id)
	{
		User user=service.fromDTO(objDTO);
		
		user.setId(id);
		user=service.update(user);
		
		return ResponseEntity.noContent().build();
	}
	
	

}
