package com.library.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.dto.BookDto;
import com.library.books.model.Book;
import com.library.books.repository.BookRepository;
import com.library.books.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	 @PostMapping("/create")
	 public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) {
	        
	        bookService.createBookEntry(bookDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body("success");
	        
	    }
	 
	 @PostMapping("/update/{id}")
	 public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody BookDto bookDto){
		 bookService.updateBookEntry(id, bookDto);
		 return ResponseEntity.status(HttpStatus.OK).body("success");
	 }
	 
	 @PostMapping("/read/{id}")
	 public ResponseEntity<?> readBook(@PathVariable("id") int id){
		 Book book = bookService.getBookEntryById(id);
		 return ResponseEntity.status(HttpStatus.OK).body(book);
	 }
	 
	 @PostMapping("/delete/{id}")
	 public ResponseEntity<?> deleteBook( int id){
		 bookService.deleteBookEntryById(id);
		 return ResponseEntity.status(HttpStatus.OK).body("deleted");
	 }
	 
	 
	 
}
