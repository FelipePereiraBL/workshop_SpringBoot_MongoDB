package com.felipe.course.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.course.domain.Post;
import com.felipe.course.repository.PostRepository;
import com.felipe.course.services.exception.ObjectNotFoundException;

@Service
public class PostService 
{
	@Autowired
	PostRepository repository;
	
	public Post findById(String id)
	{
		Optional<Post> post=repository.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
