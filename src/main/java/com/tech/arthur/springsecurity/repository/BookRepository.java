package com.tech.arthur.springsecurity.repository;

import com.tech.arthur.springsecurity.model.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
