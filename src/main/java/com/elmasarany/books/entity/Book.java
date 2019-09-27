package com.elmasarany.books.entity;

import java.util.Objects;

/**
 * @author Ahmed El Masarany
 */
public class Book {

    private Long id;
    private String name;
    private String author;
    private String description;

    public Book() {
    }

    public Book(Long id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book ID: " + id + "\n" +
               "Book Name: " + name + "\n" +
               "Book Author: " + author + "\n" +
               "Book Description: " + description + "\n";
    }
}
