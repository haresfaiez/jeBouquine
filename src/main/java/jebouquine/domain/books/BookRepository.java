package jebouquine.domain.books;

import jebouquine.infrastructure.books.Book;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookByISBN(String ISBN);
}
