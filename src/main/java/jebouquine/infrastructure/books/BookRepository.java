package jebouquine.infrastructure.books;

import jebouquine.domain.books.Book;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookByISBN(String ISBN);
}
