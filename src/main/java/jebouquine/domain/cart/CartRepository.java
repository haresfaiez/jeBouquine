package jebouquine.domain.cart;

import jebouquine.domain.books.Book;

public interface CartRepository {
    void addBookToCart(Book expectedBook);
}
