package com.mycompany.dvdstore.dvdcore.entity;

import org.springframework.data.annotation.Id;

public class Movie {
	
	@Id
	private long id;
	private String title;
	private String genre;
	private String description;
	
	public Movie() {
	}
	
	public Movie(String title, String genre, String description) {
		this.title = title;
		this.genre = genre;
		this.description=description;
	}
	
	public Movie(Long id,String title, String genre, String description) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.description=description;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
