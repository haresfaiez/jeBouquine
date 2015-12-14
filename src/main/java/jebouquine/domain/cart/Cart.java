package jebouquine.domain.cart;

import jebouquine.domain.books.Book;

public interface Cart {
    void addBook(Book expectedBook);
}
