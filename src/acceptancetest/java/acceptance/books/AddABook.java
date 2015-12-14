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

public class AddABook {
    private FirefoxDriver firefoxDriver = new FirefoxDriver();

    private AddBookDriver addBookDriver = new AddBookDriver(firefoxDriver);
    private LoginDriver loginDriver = new LoginDriver (firefoxDriver);
    private SearchBookDriver searchBookDriver = new SearchBookDriver  (firefoxDriver);
    private HomeDriver homeDriver = new HomeDriver  (firefoxDriver);

    //actor
    String username;
    String password;
    String role;
    //book
    String ISBN;
    String title;
    String price;
    String summary;
    String author;

    @Given("^I am$")
    public void i_am(List<List<String>> actor) throws Throwable {
        homeDriver.setUp();
        username = actor.get(1).get(0);
        password = actor.get(1).get(1);
        role = actor.get(1).get(2);
        loginDriver.loginAs(username, password);
    }

    @Given("^I want to add the book$")
    public void i_want_to_add_the_book(List<List<String>> book) throws
            Throwable {
        ISBN = book.get(1).get(0);
        title = book.get(1).get(1);
        price = book.get(1).get(2);
        summary = book.get(1).get(3);
        author = book.get(1).get(4);
        addBookDriver.fillBookForm(ISBN, title, price, summary, author);
    }

    @When("^I add the book to the catalog$")
    public void i_add_the_book_to_the_catalog() throws Throwable {
        addBookDriver.submitBookForm();
    }

    @Then("^the book should be inserted$")
    public void the_book_should_be_inserted() throws Throwable {
        searchBookDriver.openBookDetails(ISBN);
        Assert.assertEquals(ISBN, searchBookDriver.bookISBN());
        Assert.assertEquals(title, searchBookDriver.bookTitle());
        //TODO:test the whole details
        loginDriver.logout();
        homeDriver.tearDown();
    }

}
