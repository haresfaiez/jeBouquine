package jebouquine.infrastructure.bookshelf;

import bookshelf.domain.Book;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookByISBN(String ISBN);
}
