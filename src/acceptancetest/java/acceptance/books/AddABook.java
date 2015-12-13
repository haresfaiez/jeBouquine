package acceptance.books;

import acceptance.books.driver.AddBookDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AddABook {

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
    //web driver
    AddBookDriver driver = new AddBookDriver();

    @Given("^I am$")
    public void i_am(List<List<String>> actor) throws Throwable {
        username = actor.get(1).get(0);
        password = actor.get(1).get(1);
        role = actor.get(1).get(2);
        driver.loginAs(username, password);
    }

    @Given("^I want to add the book$")
    public void i_want_to_add_the_book(List<List<String>> book) throws
            Throwable {
        ISBN = book.get(1).get(0);
        title = book.get(1).get(1);
        price = book.get(1).get(2);
        summary = book.get(1).get(3);
        author = book.get(1).get(4);
        driver.fillBookForm(ISBN, title, price, summary, author);
    }

    @When("^I add the book to the catalog$")
    public void i_add_the_book_to_the_catalog() throws Throwable {
        driver.submitBookForm();
    }

    @Then("^the book should be inserted$")
    public void the_book_should_be_inserted() throws Throwable {
        driver.openBookDetails(ISBN);
        Assert.assertEquals(ISBN, driver.bookISBN());
        Assert.assertEquals(title, driver.bookTitle());
        //TODO:test the whole details
    }

    @Before
    public void setUp() {
        driver.setUp();
    }

    @After
    public void tearDown() {
        driver.logout();
        driver.tearDown();
    }
}
