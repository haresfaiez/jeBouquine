package jebouquine.domain.books;


import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookByISBN(String ISBN);
}
