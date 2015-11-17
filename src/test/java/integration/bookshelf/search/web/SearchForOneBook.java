package integration.bookshelf.search.web;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchForOneBook {

    //TODO: mock the service layer: BookSearchService
    //TODO: use spring testing framework to have some fun

    @Given("^the catalog contains a book with ISBN \"([^\"]*)\" and title \"([^\"]*)\"$")
    public void the_catalog_contains_a_book_with_ISBN_and_title(String BookISBN, String bookTitle) throws Throwable {
        throw new PendingException();
    }

    @Given("^the catalog contains no books$")
    public void the_catalog_contains_no_books() throws Throwable {
        throw new PendingException();
    }

    @When("^we search for a book with ISBN \"([^\"]*)\" through the web UI$")
    public void we_search_for_a_book_with_ISBN_through_the_web_UI(String BookISBN) throws Throwable {
        throw new PendingException();
    }

    @Then("^we should get the book model$")
    public void we_should_get_the_book_model() throws Throwable {
        throw new PendingException();
    }

    @Then("^we should not get a book model$")
    public void we_should_not_get_a_book_model() throws Throwable {
        throw new PendingException();
    }


}
