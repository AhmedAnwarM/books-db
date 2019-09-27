package com.elmasarany.books.control;

import com.elmasarany.books.entity.Book;
import com.elmasarany.books.utility.DiskUtils;

import java.util.Set;

/**
 * @author Ahmed El Masarany
 */
public class BooksController {
    private Set<Book> books;

    public BooksController() {
        init();
    }

    private void init() {
        books = DiskUtils.readFromDisk();
    }

    public Set<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book newBook) {
        // TODO validate
        books.add(newBook);
    }

    public void updateBook(Long id, Book updatedBook) {
        // TODO: check if id exists
        books.add(updatedBook);
    }

    public Book searchByName(String partialName) {
        // TODO: Search for book
        return null;
    }

    public Book searchByAuthor(String partialAuthor) {
        // TODO: Search for book
        return null;
    }

    public Book searchByDescription(String partialDescription) {
        // TODO: Search for book
        return null;
    }

    public Book getById(Long id) {
        // TODO: Search for book
        return null;
    }

}
