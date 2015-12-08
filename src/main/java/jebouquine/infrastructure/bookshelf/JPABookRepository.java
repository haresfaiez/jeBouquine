package jebouquine.infrastructure.bookshelf;

import bookshelf.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JPABookRepository implements BookRepository {
    @Override
    public Optional<Book> findBookByISBN(String ISBN) {
        return null;
    }
}
