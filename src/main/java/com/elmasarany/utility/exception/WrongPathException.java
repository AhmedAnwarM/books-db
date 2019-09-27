package com.elmasarany.utility.exception;

import com.elmasarany.utility.exception.base.BooksAppRuntimeException;

/**
 * @author Ahmed El Masarany
 */
public class WrongPathException extends BooksAppRuntimeException {
    public WrongPathException() {
    }

    public WrongPathException(String message) {
        super(message);
    }

    public WrongPathException(String message, Throwable cause) {
        super(message, cause);
    }
}
