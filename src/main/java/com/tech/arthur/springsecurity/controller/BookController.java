package com.tech.arthur.springsecurity.controller;


import com.tech.arthur.springsecurity.model.books.Book;
import com.tech.arthur.springsecurity.repository.BookRepository;
import com.tech.arthur.springsecurity.repository.UserRepository;
import com.tech.arthur.springsecurity.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador responsável pela gestão de livros.
 * Disponibiliza endpoints para consultar e criar livros na API.
 */
@RestController
public class BookController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    /**
     * Endpoint para listar todos os livros disponíveis.
     *
     * @return Uma lista de objetos {@link Book}.
     */
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Endpoint para criar um novo livro.
     *
     * @param book Objeto contendo os dados do livro a ser criado.
     * @return Um {@link ResponseEntity} com o livro criado e o cabeçalho de localização.
     */
    @PostMapping("/books")
    public ResponseEntity<Optional<Book>> createBook(@Valid @RequestBody Book book) {
        Optional<Book> newBook = Optional.ofNullable(bookService.createNewBook(book));

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/users/" + newBook.get())
                .body(newBook);
    }
}
