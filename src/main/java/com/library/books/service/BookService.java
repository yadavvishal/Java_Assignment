package com.library.books.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.books.dto.BookDto;
import com.library.books.model.Author;
import com.library.books.model.Book;
import com.library.books.repository.AuthorRepository;
import com.library.books.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	
	public void createBookEntry(BookDto bookDto) throws RuntimeException {
		
		Optional<Author> author= authorRepository.findById(bookDto.getAuthorId());
		if(author.isEmpty()) {
			throw new RuntimeException();
		}
		
		Book book = new Book();
		Author obj = author.get();
		book.setAuthor(obj);
		book.setTitle(bookDto.getTitle());
		book.setIsbn(bookDto.getIsbn());
		book.setPublicationYear(bookDto.getPublicationYear());
		
		bookRepository.save(book);
	}
	
	public void updateBookEntry(int id, BookDto bookDto) {
		Book existBook = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Data not Found" + id));
		Optional<Author> author= authorRepository.findById(bookDto.getAuthorId());
		if(!author.isEmpty()) {
			
			Author obj = author.get();
			existBook.setAuthor(obj);
		}
		
		
		existBook.setTitle(bookDto.getTitle());
		
		existBook.setIsbn(bookDto.getIsbn());
		existBook.setPublicationYear(bookDto.getPublicationYear());
		bookRepository.save(existBook);
	}
	public Book getBookEntryById(int id) {
		return bookRepository.findById(id).orElse(null);
	}
	public void deleteBookEntryById(int id) {
		bookRepository.deleteById(id);
	}
}

