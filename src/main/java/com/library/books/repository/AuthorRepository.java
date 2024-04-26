package com.library.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.library.books.model.Author;
@Component
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
