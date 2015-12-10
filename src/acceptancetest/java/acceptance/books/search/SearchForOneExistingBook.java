package acceptance.books.search;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jebouquine.infrastructure.books.model.BookEntity;

import java.util.Map;
import java.util.Optional;

public class SearchForOneExistingBook {
    private WebDriver webDriver = new WebDriver();

    @Given("^the catalog contains these books$")
    public void the_catalog_contains_these_books(Map<String, String> booksMap)
            throws
            Throwable {
        //add initial books
    }

    @When("^I search for a book with ISBN \"([^\"]*)\"$")
    public void the_customer_search_for_the_book_by_ISBN(String bookISBN)
            throws Throwable {
        webDriver.findBookByISBN(bookISBN);
    }

    @Then("^I should get the book$")
    public void it_should_receive_the_book_details() throws Throwable {
        Optional<BookEntity> actualBook = webDriver.firstBookIfExists();
//        assertTrue(actualBook.isPresent() && actualBook.equals(expectedBook));
    }

    @Then("^I should get an missing book message$")
    public void we_should_not_get_a_book_instance() throws Throwable {
        throw new PendingException();
    }

    @Before
    public void setUp() {
        this.webDriver.setUp();
    }

    @After
    public void tearDown() {
        this.webDriver.tearDown();
    }

}