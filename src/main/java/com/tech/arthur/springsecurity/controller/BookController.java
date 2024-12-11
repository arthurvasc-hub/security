package com.tech.arthur.springsecurity.controller;


import com.tech.arthur.springsecurity.model.books.Book;
import com.tech.arthur.springsecurity.repository.BookRepository;
import com.tech.arthur.springsecurity.repository.UserRepository;
import com.tech.arthur.springsecurity.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
   public UserRepository userRepository;

    @Autowired
    public BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks (){
        return bookRepository.findAll();
    }


    @PutMapping("/books")
    public ResponseEntity<Optional<Book>> createBook(@Valid @RequestBody Book book){
    Optional<Book> newBook = Optional.ofNullable(bookService.createNewBook(book));

    return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/users/" + newBook.get())
                .body(newBook);

    }

}
