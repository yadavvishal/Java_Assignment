package com.library.books.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDto {
	@JsonProperty("title")
	 private String title;
	
	@JsonProperty("isbn")
	  private String isbn;
	
	@JsonProperty("year")
	  private int publicationYear;
	
	@JsonProperty("id")
	private int authorId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public BookDto(String title, String isbn, int publicationYear, int authorId) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.authorId = authorId;
	}

	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
