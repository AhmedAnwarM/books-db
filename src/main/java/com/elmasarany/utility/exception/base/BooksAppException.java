package com.elmasarany.utility.exception.base;

/**
 * @author Ahmed El Masarany
 */
public class BooksAppException extends Exception {
    public BooksAppException() {
    }

    public BooksAppException(String message) {
        super(message);
    }

    public BooksAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
