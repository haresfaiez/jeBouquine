package jebouquine.infrastructure.books;

import jebouquine.domain.books.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
@Transactional
public class JPABookRepository implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Book> findBookByISBN(String ISBN) {
        return Optional.of(entityManager.find(Book.class, ISBN));
    }

}
