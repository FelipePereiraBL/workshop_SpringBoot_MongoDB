package com.felipe.course.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AutorDTO auto;
	
	public CommentDTO()
	{
		
	}
	public CommentDTO(String text, Date date, AutorDTO auto) 
	{
		super();
		this.text = text;
		this.date = date;
		this.auto = auto;
	}
	
	public String getText() 
	{
		return text;
	}
	public void setText(String text) 
	{
		this.text = text;
	}
	
	public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public AutorDTO getAuto()
	{
		return auto;
	}
	public void setAuto(AutorDTO auto)
	{
		this.auto = auto;
	}

}
