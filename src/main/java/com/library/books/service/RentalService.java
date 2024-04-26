
package com.library.books.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.books.dto.RentalDto;
import com.library.books.model.*;
import com.library.books.repository.BookRepository;
import com.library.books.repository.RentalRepository;

import jakarta.transaction.Transactional;

@Service
public class RentalService {
	@Autowired
	private RentalRepository rentalRepository;
	
	@Autowired
	private BookRepository bookRepository;
	 
		

	public String rentBook(RentalDto rentalDto) {
		int bookId = rentalDto.getBookId();
		Optional<Book> book= bookRepository.findById(bookId);
		boolean isPresent = rentalRepository.existsByBookId(bookId);
		if(isPresent) {
			return "book is already assign to anyone";
		}
		Rental rental = new Rental();
		Book obj= book.get();
		rental.setBook(obj);
		LocalDate rentDate = LocalDate.now();
		LocalDate returnDate= rentDate.plusDays(14);
		rental.setRentalDate(rentDate);
		rental.setReturnDate(returnDate);
		rental.setRenterName(rentalDto.getRentername());
		rentalRepository.save(rental);
		return "Book is successfully rented";
		
	}

	@Transactional
	public String retrieveBook(int bookId) {
		boolean isPresent = rentalRepository.existsByBookId(bookId);
		if(isPresent) {
			LocalDate today=LocalDate.now();
			LocalDate returnDate = (rentalRepository.getByBookId(bookId)).getReturnDate();
			
			rentalRepository.deleteByBookId(bookId);
			if(returnDate.isBefore(today)) {
				return "Book exceed the return date fine is imposed. Retrieve Successfully";
			}
			return "No fine is imposed. Retrieve successfully";
		}
		return "Given book is not rented";
	}
	public List<Rental> getAllRental(){
		return rentalRepository.findAll();
	}
	public List<Book> availabeBooksForRent(){
		List<Book> myBook = bookRepository.findAll();
		List<Rental> rentedBook = getAllRental(); 
		
		 List<Book> availableBooks = myBook.stream()
	                .filter(book -> !isBookRented(book, rentedBook))
	                .collect(Collectors.toList());

	        return availableBooks;
	}
	
	private boolean isBookRented(Book book, List<Rental> rentedBooks) {
        for (Rental rental : rentedBooks) {
            if (rental.getBook().getId() == book.getId()) {
                return true;
            }
        }
        return false;
    }
}


