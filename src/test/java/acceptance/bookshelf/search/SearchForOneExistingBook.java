package acceptance.bookshelf.search;

import bookshelf.domain.Book;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SearchForOneExistingBook {
    private BookDataSourceDriver bookDataSourceDriver = new BookDataSourceDriver();

    private Book expectedBook;
    private Optional<Book> retrievedBook;

    @Given("^the catalog contains these books$")
    public void the_catalog_contains_these_books(Map<String, String> booksMap)
            throws
            Throwable {
        List<Book> expectedBooksList = new ArrayList<>();
        booksMap.forEach((isbn, title) -> expectedBooksList.add(new Book(isbn,
                title)));
        this.bookDataSourceDriver.addBooks(expectedBooksList);
    }

    @When("^I search for a book with ISBN \"([^\"]*)\"$")
    public void the_customer_search_for_the_book_by_ISBN(String BookISBN) throws Throwable {
        throw new PendingException();
    }

    @Then("^I should get the book$")
    public void it_should_receive_the_book_details() throws Throwable {
        throw new PendingException();
    }

    @Then("^I should get an missing book message$")
    public void we_should_not_get_a_book_instance() throws Throwable {
        throw new PendingException();
    }

    @Before
    public void setUp() {
        this.bookDataSourceDriver.setUpDatabase();
    }

    @After
    public void tearDown() {
        this.bookDataSourceDriver.tearDownDatabase();
    }

}
