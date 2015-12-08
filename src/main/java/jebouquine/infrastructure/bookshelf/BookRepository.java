package jebouquine.infrastructure.bookshelf;

import jebouquine.domain.bookshelf.Book;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookByISBN(String ISBN);
}
