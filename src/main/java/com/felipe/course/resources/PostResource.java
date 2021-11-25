package com.felipe.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.felipe.course.domain.Post;
import com.felipe.course.resources.util.URL;
import com.felipe.course.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource
{
	@Autowired
	PostService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity< Post> findById(@PathVariable String id)
	{
		Post post=service.findById(id);
		
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value="/titleSearch")
	public ResponseEntity<List< Post>>findByIdTitle (@RequestParam(value = "text",defaultValue = "") String text)
	{
		text=URL.DecodeParam(text);
		
		List<Post> posts=service.findByTitle(text);
		
		return ResponseEntity.ok().body(posts);
	}	
}
