package com.library.books.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RentalDto {
	@JsonProperty("id")
	private int bookId;
	
	@JsonProperty("name")
	private String rentername;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getRentername() {
		return rentername;
	}

	public void setRentername(String rentername) {
		this.rentername = rentername;
	}

	public RentalDto(int bookId, String rentername) {
		super();
		this.bookId = bookId;
		this.rentername = rentername;
	}

	public RentalDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
