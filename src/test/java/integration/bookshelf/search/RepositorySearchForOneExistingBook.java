package integration.bookshelf.search;

import bookshelf.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.After;
import org.junit.Before;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RepositorySearchForOneExistingBook {
    //TODO:Make that path a system property
    public static final String FAKE_HIBERNATE_CONFIG_LOCATION = "integration/dataaccess/fake-hibernate.xml";
    private SessionFactory sessionFactory;

    private Book expectedBook;
    private Book retrievedBook;

    @Given("^There is a book in the catalog with ISBN \"([^\"]*)\" and title \"([^\"]*)\"$")
    public void there_is_a_book_in_the_catalog_with_ISBN_and_title(String BookISBN, String bookTitle) throws Throwable {
        this.expectedBook = Book.createBook(BookISBN, bookTitle);
        // add the book to the database
        final Session bookInsertionSession = this.sessionFactory.openSession();
        final Transaction bookInsertionTransaction = bookInsertionSession.getTransaction();
        bookInsertionTransaction.begin();
        bookInsertionSession.save(this.getExpectedBook());
        bookInsertionTransaction.commit();
        bookInsertionSession.close();
    }

    @When("^The customer search for the book by ISBN \"([^\"]*)\"$")
    public void the_customer_search_for_the_book_by_ISBN(String BookISBN) throws Throwable {
        final Session bookRetrieveSession = this.sessionFactory.openSession();
        Transaction bookRetrieveTransaction = bookRetrieveSession.getTransaction();
        bookRetrieveTransaction.begin();
        this.retrievedBook = bookRetrieveSession.load(Book.class, BookISBN);
        bookRetrieveTransaction.commit();
        bookRetrieveSession.close();
    }

    @Then("^It should receive the book details$")
    public void it_should_receive_the_book_details() throws Throwable {
        final Session bookRetrieveSession = this.sessionFactory.openSession();
        bookRetrieveSession.update(this.retrievedBook);
        assertThat(this.getExpectedBook()).isEqualToComparingFieldByField(this.getRetrievedBook());
        bookRetrieveSession.close();
    }

    @Before
    public void setUpDatabase() {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure(FAKE_HIBERNATE_CONFIG_LOCATION);
        hibernateConfiguration.addAnnotatedClass(Book.class);
        StandardServiceRegistryBuilder hibernateServiceRegistry = new StandardServiceRegistryBuilder();
        ServiceRegistry serviceRegistry =
                hibernateServiceRegistry.applySettings(hibernateConfiguration.getProperties()).build();
        this.sessionFactory = hibernateConfiguration.buildSessionFactory(serviceRegistry);
    }

    @After
    public void tearDownDatabase() {
        this.sessionFactory.close();
    }

    private Book getRetrievedBook() {
        return retrievedBook;
    }

    private Book getExpectedBook() {
        return expectedBook;
    }

}
