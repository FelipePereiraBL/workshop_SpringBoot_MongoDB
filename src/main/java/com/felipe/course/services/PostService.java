package com.felipe.course.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post>findByTitle(String text)
	{
	    return repository.serachTitle(text);
	}
	
	public List<Post>fullsearch(String text,Date minDate,Date maxDate)
	{
		maxDate=new Date(maxDate.getTime()+24*60*60*1000);
		
	    return repository.fullSearch(text,minDate,maxDate);
	}

}
