package acceptance.books;

import acceptance.HomeDriver;
import acceptance.books.driver.AddBookDriver;
import acceptance.books.driver.SearchBookDriver;
import acceptance.user.driver.LoginDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SearchForABook {

    private FirefoxDriver firefoxDriver = new FirefoxDriver();

    private AddBookDriver addBookDriver = new AddBookDriver(firefoxDriver);
    private LoginDriver loginDriver = new LoginDriver (firefoxDriver);
    private SearchBookDriver searchBookDriver = new SearchBookDriver  (firefoxDriver);
    private HomeDriver homeDriver = new HomeDriver  (firefoxDriver);

    private String adminPassowd = "0000";
    private String adminUsername = "faiez_logistic";

    @Given("^the catalog contains these books$")
    public void the_catalog_contains_these_books(List<List<String>> books)
            throws Throwable {
        homeDriver.setUp();
        loginDriver.loginAs(adminUsername, adminPassowd);
        addBook(books.get(1));
        addBook(books.get(2));
        addBook(books.get(3));
    }

    private void addBook(List<String> book) {
        String ISBN = book.get(0);
        String title = book.get(1);
        String price = book.get(2);
        String summary = book.get(3);
        String author = book.get(4);
        addBookDriver.fillBookForm(ISBN, title, price, summary, author);
        addBookDriver.submitBookForm();
    }

    @When("^I search for a book with ISBN \"([^\"]*)\"$")
    public void i_search_for_a_book_with_ISBN(String ISBN) throws Throwable {
        searchBookDriver.openBookDetails(ISBN);
    }

    @Then("^I should get the book$")
    public void i_should_get_the_book(List<List<String>> book) throws Throwable {
        String ISBN = book.get(1).get(0);
        String title = book.get(1).get(1);
        String price = book.get(1).get(2);
        String summary = book.get(1).get(3);
        String author = book.get(1).get(4);
        Assert.assertEquals(ISBN, searchBookDriver.bookISBN());
        Assert.assertEquals(title, searchBookDriver.bookTitle());
        //TODO:test the whole details
        loginDriver.logout();
        homeDriver.tearDown();
    }

}
