package com.felipe.course.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipe.course.domain.Post;
import com.felipe.course.domain.User;
import com.felipe.course.dto.AutorDTO;
import com.felipe.course.repository.PostRepository;
import com.felipe.course.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner
{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception 
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//////////////////////////////////////////////
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		//////////////////////////////////////////////
		
		postRepository.deleteAll();
		
		Post post1=new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo, abraços !",new AutorDTO(maria));
		Post post2=new Post(null, sdf.parse("21/03/2018"), "Bom Dia !", "Acordei feliz hoje !",new AutorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
	}

}
