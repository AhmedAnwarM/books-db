package com.elmasarany.utility.exception;

import com.elmasarany.utility.exception.base.BooksAppRuntimeException;

/**
 * @author Ahmed El Masarany
 */
public class DiskReadException extends BooksAppRuntimeException {
    public DiskReadException() {
    }

    public DiskReadException(String message) {
        super(message);
    }

    public DiskReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
