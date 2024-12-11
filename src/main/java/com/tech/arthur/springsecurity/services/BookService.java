package com.tech.arthur.springsecurity.services;

import com.tech.arthur.springsecurity.model.books.Book;
import com.tech.arthur.springsecurity.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createNewBook(Book book){

        book.setAuthor(book.getAuthor());
        book.setTitle(book.getTitle());
        book.setDescription(book.getDescription());

        return bookRepository.save(book);


    }
}
