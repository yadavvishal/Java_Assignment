package com.library.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.model.*;
import com.library.books.repository.AuthorRepository;
import com.library.books.service.AuthorService;


@RestController
@RequestMapping("/author")
public class AuthorController {

	private final AuthorService authorService;
	public AuthorController(AuthorService authorService) {
		this.authorService=authorService;
	}
	
	 @PostMapping("/create")
	 public ResponseEntity<?> createAuthor(@RequestBody Author author) {
	        
	        authorService.createAuthorEntry(author);
	        return ResponseEntity.status(HttpStatus.CREATED).body("success");
	        
	    }
	 
	 @PostMapping("/update/{id}")
	 public ResponseEntity<?> updateAuthor(@PathVariable("id") int id, @RequestBody Author author){
		 authorService.updateAuthorEntry(id, author);
		 return ResponseEntity.status(HttpStatus.OK).body("success");
	 }
	 
	 @PostMapping("/read/{id}")
	 public ResponseEntity<?> readAuthor(@PathVariable("id") int id){
		 Author author = authorService.getAuthorEntryById(id);
		 return ResponseEntity.status(HttpStatus.OK).body(author);
	 }
	 
	 @PostMapping("/delete/{id}")
	 public ResponseEntity<?> deleteAuthor(@PathVariable("id") int id){
		 authorService.deleteAuthorEntryById(id);
		 return ResponseEntity.status(HttpStatus.OK).body("deleted");
	 }
	 @GetMapping("/books/{id}")
	 public List<Book> getAllBooks(@PathVariable("id") int authorId){
		 return authorService.getAllBook(authorId);
	 }
}
