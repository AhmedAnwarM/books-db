package com.elmasarany.books.boundary;

import com.elmasarany.books.InvalidBookException;
import com.elmasarany.books.control.BooksController;
import com.elmasarany.books.entity.Book;
import com.elmasarany.utility.DiskUtils;
import com.elmasarany.utility.exception.DiskWriteException;

import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

/**
 * @author Ahmed El Masarany
 */
public class BooksInterface {
    private static final Logger LOGGER = Logger.getLogger(DiskUtils.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    private static BooksController ctrl;

    public static void main(String[] args) throws InvalidBookException {
        ctrl = new BooksController();
        int selection = 0;
        while (selection != 5) {
            System.out.println("==== Book Manager ====" +
                               ("1) View all books") +
                               "(2) Add a book" +
                               "(3) Edit a book" +
                               "(4) Search for a book" +
                               "(5) Save and exit" +
                               "Choose [1-5]: ");
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    print(ctrl.getAllBooks());
                    break;
                case 2:
                    Book newBook = readBook();
                    ctrl.addBook(newBook);
                    break;
                case 3:
                    Book updatedBook = readBook();
                    Long id = updatedBook.getId();
                    ctrl.updateBook(id, updatedBook);
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    saveAndExit();
                    break;
                default:

            }
        }
    }

    private static void search() throws InvalidBookException {
        System.out.println("Select search criteria...\n" +
                           "(1) book name\n" +
                           "(2) author name\n" +
                           "(3) book description\n" +
                           "(4) book ID");
        int selection = scanner.nextInt();

        Book result = null;
        switch (selection) {
            case 1:
                String name = scanner.nextLine();
                print(ctrl.searchByName(name));
                break;
            case 2:
                String author = scanner.nextLine();
                print(ctrl.searchByAuthor(author));
                break;
            case 3:
                String descrption = scanner.nextLine();
                print(ctrl.searchByDescription(descrption));
                break;
            case 4:
                Long id = scanner.nextLong();
                print(ctrl.getById(id));
                break;
            default:
                System.out.println("Invalid selection...");
        }
    }

    private static void saveAndExit() {
        try {
            ctrl.saveAndExit();
            System.out.println("Saved successfully. Exiting...");
        } catch (DiskWriteException e) {
            System.out.println(
                    "Failed to update database with the changes you made... Please check the attached error and try again");
            LOGGER.log(SEVERE, e.getMessage(), e);
        }
    }

    private static void print(Set<Book> books) {
        books.forEach(BooksInterface::print);
    }

    private static void print(Book book) {
        System.out.println(book.toString());
    }

    private static Book readBook() {
        System.out.println("Enter book ID: ");
        Long bookId = scanner.nextLong();

        System.out.println("Enter book name: ");
        String bookName = scanner.nextLine();

        System.out.println("Enter book author: ");
        String author = scanner.nextLine();

        System.out.println("Enter book description: ");
        String bookDescription = scanner.nextLine();

        return new Book(bookId, bookName, author, bookDescription);
    }
}
