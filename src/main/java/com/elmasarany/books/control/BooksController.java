package com.elmasarany.books.control;

import com.elmasarany.books.InvalidBookException;
import com.elmasarany.books.entity.Book;
import com.elmasarany.utility.DiskUtils;
import com.elmasarany.utility.exception.DiskWriteException;

import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Ahmed El Masarany
 */
public class BooksController {
    private static final Logger LOGGER = Logger.getLogger(BooksController.class.getName());
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

    public void addBook(Book newBook) throws InvalidBookException {
        validateNewBook(newBook);
        books.add(newBook);
    }

    public void updateBook(Long id, Book updatedBook) throws InvalidBookException {
        validateUpdatedBook(updatedBook);
        books.removeIf(book -> book.getId().equals(id));
        books.add(updatedBook);
    }

    public Set<Book> searchByName(String partialName) {
        return books.stream().
                filter(book -> book.getName().contains(partialName)).
                collect(Collectors.toSet());
    }

    public Set<Book> searchByAuthor(String partialAuthor) {
        return books.stream().
                filter(book -> book.getAuthor().contains(partialAuthor)).
                collect(Collectors.toSet());
    }

    public Set<Book> searchByDescription(String partialDescription) {
        return books.stream().
                filter(book -> book.getDescription().contains(partialDescription)).
                collect(Collectors.toSet());
    }

    public Book getById(Long id) throws InvalidBookException {
        Optional<Book> first = books.stream().
                filter(book -> book.getId().equals(id)).
                findFirst();
        if (first.isPresent())
            return first.get();
        else
            throw new InvalidBookException("The ID you're using did not return any results");
    }

    public void saveAndExit() throws DiskWriteException {
        DiskUtils.writeToDisk(books);
    }

    private void validateNewBook(Book newBook) throws InvalidBookException {
        if (newBook == null || newBook.getAuthor() == null || newBook.getAuthor().isEmpty() || newBook.getName() == null
            || newBook.getName().isEmpty() || newBook.getDescription() == null || newBook.getDescription().isEmpty()
            || newBook.getId() == null)
            throw new InvalidBookException(
                    "The book you have entered is not valid... Please check the values you entered");
        if (books.stream().anyMatch(book -> book.getId().equals(newBook.getId())))
            throw new InvalidBookException("The book you're trying to add already exists in the database");

    }

    private void validateUpdatedBook(Book newBook) throws InvalidBookException {
        if (newBook == null || newBook.getAuthor() == null || newBook.getAuthor().isEmpty() || newBook.getName() == null
            || newBook.getName().isEmpty() || newBook.getDescription() == null || newBook.getDescription().isEmpty()
            || newBook.getId() == null)
            throw new InvalidBookException(
                    "The book you have entered is not valid... Please check the values you entered");
        if (books.stream().noneMatch(book -> book.getId().equals(newBook.getId())))
            throw new InvalidBookException("The book you're trying to edit does not exist in the database");
    }
}
