package integration.bookshelf.search.dataaccess;

import bookshelf.domain.Book;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchForASingleBookByISBN {

    //TODO:Make that path a system property
    public static final String FAKE_HIBERNATE_CONFIG_LOCATION = "integration/dataaccess/fake-hibernate.xml";
    private SessionFactory sessionFactory;

    private Book expectedBook;
    private Optional<Book> retrievedBook;

    @Given("^the data source contains a book with ISBN \"([^\"]*)\" and title \"([^\"]*)\"$")
    public void there_is_a_book_in_the_catalog_with_ISBN_and_title(String BookISBN, String bookTitle) throws Throwable {
        this.expectedBook = Book.createBook(BookISBN, bookTitle);
        // add the book to the database
        final Session bookInsertionSession = this.sessionFactory.openSession();
        final Transaction bookInsertionTransaction = bookInsertionSession.getTransaction();
        bookInsertionTransaction.begin();
        bookInsertionSession.save(this.expectedBook);
        bookInsertionTransaction.commit();
        bookInsertionSession.close();
    }

    @Given("^the data source contains a no books$")
    public void the_data_source_contains_a_no_books() throws Throwable {
    }

    @When("^we try to retrieve a book with ISBN \"([^\"]*)\" from the data source$")
    public void the_customer_search_for_the_book_by_ISBN(String BookISBN) throws Throwable {
        final Session bookRetrieveSession = this.sessionFactory.openSession();
        Transaction bookRetrieveTransaction = bookRetrieveSession.getTransaction();
        bookRetrieveTransaction.begin();
        this.retrievedBook = Optional.of(bookRetrieveSession.load(Book.class, BookISBN));
        bookRetrieveTransaction.commit();
        bookRetrieveSession.close();
    }

    @Then("^we should get the book instance$")
    public void it_should_receive_the_book_details() throws Throwable {
        final Session bookRetrieveSession = this.sessionFactory.openSession();
        bookRetrieveSession.update(this.retrievedBook.get());
        assertThat(this.expectedBook).isEqualToComparingFieldByField(this.expectedBook);
        bookRetrieveSession.close();
    }

    @Then("^we should not get a book instance$")
    public void we_should_not_get_a_book_instance() throws Throwable {
        //TODO:move that to a junit expected exception
        try {
            final Session bookRetrieveSession = this.sessionFactory.openSession();
            bookRetrieveSession.update(this.retrievedBook.get());
            assertThat(this.retrievedBook.get()).isNull();
            bookRetrieveSession.close();
        } catch (ObjectNotFoundException e) {
            retrievedBook = Optional.empty();
        }
        assertThat(this.retrievedBook.isPresent()).isFalse();
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


}
