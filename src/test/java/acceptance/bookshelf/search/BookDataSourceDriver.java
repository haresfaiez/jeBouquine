package acceptance.bookshelf.search;

import jebouquine.domain.bookshelf.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

public class BookDataSourceDriver {
    public final static String PERSISTENCE_UNIT_NAME = "jbp";

    private EntityManagerFactory entityManagerFactory;

    public void addBooks(List<Book> books) {
        final EntityManager entityManager =  this.entityManagerFactory
                .createEntityManager();
        final EntityTransaction bookInsertionTransaction = entityManager
                .getTransaction();
        bookInsertionTransaction.begin();
        books.stream().forEach(book -> entityManager.persist(book));
        bookInsertionTransaction.commit();
        entityManager.close();
    }

    public void setUpDatabase() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory
                (PERSISTENCE_UNIT_NAME);
    }

    public void tearDownDatabase() {
        this.entityManagerFactory.close();
    }


}
