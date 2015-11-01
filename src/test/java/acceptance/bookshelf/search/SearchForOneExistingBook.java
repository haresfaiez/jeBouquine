package acceptance.bookshelf.search;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchForOneExistingBook {
//TODO:remove those comments


    @Given("^There is a book in the catalog with ISBN \"([^\"]*)\" and title \"([^\"]*)\"$")
    public void there_is_a_book_in_the_catalog_with_ISBN_and_title(String BookISBN, String bookTitle) throws Throwable {
        throw new PendingException();
    }

    @When("^The customer search for the book by ISBN \"([^\"]*)\"$")
    public void the_customer_search_for_the_book_by_ISBN(String BookISBN) throws Throwable {
        throw new PendingException();
    }

    @Then("^It should receive the book details$")
    public void it_should_receive_the_book_details() throws Throwable {
        throw new PendingException();
    }

    @Before
    public void setUpDatabase() {
    }

    @After
    public void tearDownDatabase() {
    }

}
