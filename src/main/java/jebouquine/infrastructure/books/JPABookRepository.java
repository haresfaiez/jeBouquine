package jebouquine.infrastructure.books;

import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.infrastructure.books.model.BookEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class JPABookRepository implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Book> findBookByISBN(String ISBN) {
        return Optional
                .of(entityManager.find(BookEntity.class, ISBN))
                .map(bookEntity -> Optional.of(bookEntity.createBook()))
                .get();
    }

    @Override
    public void addBook(Book expectedBook) {
        entityManager.persist(new BookEntity(expectedBook));
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        TypedQuery<BookEntity> query = entityManager
                .createNamedQuery("BookEntity.searchByTitle", BookEntity.class);
        query.setParameter("bookTitle", title);
        return  query
                .getResultList()
                .stream()
                .map(bookEntity -> bookEntity.createBook())
                .collect(Collectors.toList());
    }

}
