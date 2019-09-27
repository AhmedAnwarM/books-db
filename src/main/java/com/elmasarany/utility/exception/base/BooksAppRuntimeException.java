package com.elmasarany.utility.exception.base;

/**
 * @author Ahmed El Masarany
 */
public abstract class BooksAppRuntimeException extends RuntimeException {
    public BooksAppRuntimeException() {
    }

    public BooksAppRuntimeException(String message) {
        super(message);
    }

    public BooksAppRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
