package com.elmasarany.books.boundary;

import com.elmasarany.books.control.BooksController;

/**
 * @author Ahmed El Masarany
 */
public class BooksInterface {

    private static BooksController ctrl;

    public static void main(String[] args) {
        ctrl = new BooksController();
        // TODO: All user actions
    }
}
