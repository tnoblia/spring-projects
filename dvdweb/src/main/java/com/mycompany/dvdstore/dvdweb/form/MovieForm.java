package com.mycompany.dvdstore.dvdweb.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {
	
	private long id;
	
	@NotBlank
	@Size(max=20)
	private String title;
	
	@NotBlank
	@Size(max=20)
	private String genre;

	@Size(min=10,max=250)
	private String description;
	
	@Size(max=20)
	private String actorName;

	@Size(max=20)
	private String actorFirstName;
	
	
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
	
	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorFirstName() {
		return actorFirstName;
	}

	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}
	
}