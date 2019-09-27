package com.elmasarany.utility.exception;

import com.elmasarany.utility.exception.base.BooksAppException;

/**
 * @author Ahmed El Masarany
 */
public class DiskWriteException extends BooksAppException {
    public DiskWriteException() {
    }

    public DiskWriteException(String message) {
        super(message);
    }

    public DiskWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
