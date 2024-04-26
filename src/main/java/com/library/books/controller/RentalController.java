/*
package com.library.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.books.model.Rental;
import com.library.books.repository.RentalRepository;
import com.library.books.service.RentalService;

public class RentalController {
	@Autowired
	private RentalService RentalService;
	
	 @PostMapping("/create")
	 public ResponseEntity<?> createRental(@RequestBody Rental rental) {
	        
	        rentalService.createRentalEntry(rental);
	        return ResponseEntity.status(HttpStatus.CREATED).body("success");
	        
	    }
	 
	 @PostMapping("/update/{id}")
	 public ResponseEntity<?> updateAuthor(@PathVariable("id") Long id, @RequestBody Rental rental){
		 RentalService.updateRentalEntry(id, rental);
		 return ResponseEntity.status(HttpStatus.OK).body("success");
	 }
	 
	 @PostMapping("/read/{id}")
	 public ResponseEntity<?> readRental( Long id){
		 Rental rental = RentalService.getRentalEntryById(id);
		 return ResponseEntity.status(HttpStatus.OK).body(rental);
	 }
	 
	 @PostMapping("/delete/{id}")
	 public ResponseEntity<?> deleteRental( Long id){
		 rentalService.deleteRentalEntryById(id);
		 return ResponseEntity.status(HttpStatus.OK).body("deleted");
	 }
}
*/

package com.library.books.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.books.dto.RentalDto;
import com.library.books.model.Book;
import com.library.books.model.Rental;
import com.library.books.repository.RentalRepository;
import com.library.books.service.RentalService;


import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
	@Autowired
    private  RentalService rentalService;

    @PostMapping("/rent")
    public String rentBook(@RequestBody RentalDto rentalDto) {
    	return rentalService.rentBook(rentalDto);
    	
    }
    @GetMapping("/retrieve/{id}")
    public String retrieveBook(@PathVariable("id") int bookId) {
    	return rentalService.retrieveBook(bookId);
    }
    @GetMapping("/books")
    public List<Rental> getAllRentalBooks(){
    	return rentalService.getAllRental();
    }
    
    @GetMapping("/available")
    public List<Book> getAvailableBooksForRent(){
    	return rentalService.availabeBooksForRent();
    }
}

    