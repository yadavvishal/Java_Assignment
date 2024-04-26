package com.library.books.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity

public class Rental {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long id;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	 private Book book;
	private String renterName;
	 private LocalDate rentalDate;
	  private LocalDate returnDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getRenterName() {
		return renterName;
	}
	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}
	public LocalDate getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public Rental(Long id, Book book, String renterName, LocalDate rentalDate, LocalDate returnDate) {
		super();
		this.id = id;
		this.book = book;
		this.renterName = renterName;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}
	public Rental() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}
