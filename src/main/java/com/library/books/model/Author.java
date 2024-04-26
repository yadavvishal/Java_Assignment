package com.library.books.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class Author {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	 private String name;
	 private String biography;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public Author(int id, String name, String biography) {
		super();
		this.id = id;
		this.name = name;
		this.biography = biography;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	    
    
}
