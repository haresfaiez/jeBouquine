package jebouquine.domain.cart;

import jebouquine.domain.books.Book;

import java.util.List;

public interface Cart {
    void addBook(Book expectedBook);
    List<Purchase> purchases();
    void removeBook(Book expectedBook);
}
