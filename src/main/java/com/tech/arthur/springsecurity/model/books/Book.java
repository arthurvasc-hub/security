package com.tech.arthur.springsecurity.model.books;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa a entidade Livro no sistema.
 *
 * Essa classe mapeia a tabela `books` no banco de dados e contém informações básicas sobre os livros.
 */
@Entity(name = "books")
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "bookId")
public class Book {

    /**
     * Identificador único do livro.
     * Gerado automaticamente através de uma sequência personalizada.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "books_seq", sequenceName = "books_seq", allocationSize = 1)
    private long bookId;

    /**
     * Título do livro.
     */
    private String title;

    /**
     * Autor do livro.
     */
    private String author;

    /**
     * Descrição do livro.
     */
    private String description;

    // Métodos getters e setters

    /**
     * Obtém o título do livro.
     *
     * @return título do livro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título do livro.
     *
     * @param title título a ser definido.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtém o autor do livro.
     *
     * @return autor do livro.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Define o autor do livro.
     *
     * @param author autor a ser definido.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Obtém a descrição do livro.
     *
     * @return descrição do livro.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição do livro.
     *
     * @param description descrição a ser definida.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
