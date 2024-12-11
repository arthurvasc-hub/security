package com.tech.arthur.springsecurity.model.books;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "books")
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "bookId")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "books_seq", sequenceName = "books_seq", allocationSize = 1)
    private long bookId;


    private String title;


    private String author;


    private String description;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
