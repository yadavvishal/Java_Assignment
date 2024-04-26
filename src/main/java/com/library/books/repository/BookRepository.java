package com.library.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.library.books.model.Book;
@Component
public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByAuthorId(int authorId);
}
