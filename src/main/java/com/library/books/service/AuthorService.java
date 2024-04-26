package com.library.books.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.books.model.Author;
import com.library.books.model.*;
import com.library.books.repository.AuthorRepository;
import com.library.books.repository.BookRepository;
@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public void createAuthorEntry(Author author) {
	System.out.println(author.getName());
		authorRepository.save(author);
			
		
	}
	public void updateAuthorEntry(int id, Author author) {
		Author existAuthor = authorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Data not Found" + id));
		
		existAuthor.setName(author.getName());
		existAuthor.setBiography(author.getBiography());
		
	}
	public Author getAuthorEntryById(int id) {
		return authorRepository.findById(id).orElse(null);
	}
	public void deleteAuthorEntryById(int id) {
		authorRepository.deleteById(id);
	}
	public List<Book> getAllBook(int authorId){
		List<Book> books=bookRepository.findByAuthorId(authorId);
		return books;
	}
}
