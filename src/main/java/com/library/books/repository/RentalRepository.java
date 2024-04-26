package com.library.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.library.books.model.Book;
import com.library.books.model.Rental;
@Component
public interface RentalRepository extends JpaRepository<Rental, Integer>{
	public boolean existsByBookId(int bookId);
	public void deleteByBookId(int bookId);
	public Rental getByBookId(int bookId);
}
