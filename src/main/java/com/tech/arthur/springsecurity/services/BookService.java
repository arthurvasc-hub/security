package com.tech.arthur.springsecurity.services;

import com.tech.arthur.springsecurity.model.books.Book;
import com.tech.arthur.springsecurity.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço para gerenciar operações relacionadas a {@link Book}.
 *
 * Esta classe é responsável por manipular a criação de livros, interagindo com o repositório {@link BookRepository}.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Cria um novo livro no banco de dados.
     *
     * @param book objeto {@link Book} com os dados do livro a ser criado.
     * @return o livro criado com os dados persistidos no banco de dados.
     */
    public Book createNewBook(Book book){

        book.setAuthor(book.getAuthor());
        book.setTitle(book.getTitle());
        book.setDescription(book.getDescription());

        return bookRepository.save(book);
    }
}
