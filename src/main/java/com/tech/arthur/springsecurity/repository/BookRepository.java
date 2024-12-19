package com.tech.arthur.springsecurity.repository;

import com.tech.arthur.springsecurity.model.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade {@link Book}.
 *
 * Este repositório estende {@link JpaRepository}, fornecendo operações básicas de CRUD para a entidade {@link Book}.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
