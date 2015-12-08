package jebouquine.infrastructure.bookshelf;

import jebouquine.domain.bookshelf.Book;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JPABookRepository implements BookRepository {
    @Override
    public Optional<Book> findBookByISBN(String ISBN) {
        return null;
    }
}
