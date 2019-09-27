package com.elmasarany.books;

/**
 * @author Ahmed Anwar
 */
public class InvalidBookException extends Exception {
    public InvalidBookException() {
    }

    public InvalidBookException(String message) {
        super(message);
    }

    public InvalidBookException(String message, Throwable cause) {
        super(message, cause);
    }
}
