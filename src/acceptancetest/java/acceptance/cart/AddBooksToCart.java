package acceptance.cart;

import acceptance.HomeDriver;
import acceptance.driver.*;
import acceptance.factory.ListToBook;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class AddBooksToCart {
    private FirefoxDriver firefoxDriver = new FirefoxDriver();

    private AddBookDriver addBookDriver = new AddBookDriver(firefoxDriver);
    private LoginDriver loginDriver = new LoginDriver(firefoxDriver);
    private SearchBookDriver searchBookDriver = new SearchBookDriver(firefoxDriver);
    private HomeDriver homeDriver = new HomeDriver(firefoxDriver);
    private BookDriver bookDriver = new BookDriver(firefoxDriver);
    private CartDriver cartDriver = new CartDriver(firefoxDriver);

    //actor
    String username;
    String password;
    //books
    List<String> firstBook;
    List<String> secondBook;

    @Given("^I am the customer$")
    public void i_am_the_customer(List<List<String>> actor) throws Throwable {
        homeDriver.setUp();
        username = actor.get(1).get(0);
        password = actor.get(1).get(1);
    }

    @Given("^The books I want to buy are$")
    public void the_books_I_want_to_buy_are(List<List<String>> books)
            throws Throwable {
        loginDriver.loginAs(LoginDriver.logisticManagerUsername, LoginDriver.logisticManagerPassword);
        firstBook = books.get(1);
        secondBook = books.get(2);
        addBookDriver.addBook(firstBook);
        addBookDriver.addBook(secondBook);
        loginDriver.logout();
        loginDriver.loginAs(username, password);
    }

    @When("^I add them to my cart$")
    public void i_add_them_to_my_cart() throws Throwable {
        searchBookDriver.openBookDetails(ListToBook.ISBNOf(firstBook));
        bookDriver.addToCart(firstBook);
        searchBookDriver.openBookDetails(ListToBook.ISBNOf(secondBook));
        bookDriver.addToCart(secondBook);
    }

    @Then("^I should find these purchases in my cart$")
    public void I_should_find_these_entries_in_my_cart
            (List<List<String>> purchases) throws Throwable {
        cartDriver.visitCart();
        cartDriver.assertPurchaseExists(purchases.get(1));
        cartDriver.assertPurchaseExists(purchases.get(2));
    }

    @Then("^the total price should be \"([^\"]*)\"$")
    public void the_total_price_should_be(String expectedSum) throws Throwable {
        cartDriver.assertPurchasesSumIs(expectedSum);
        loginDriver.logout();
        homeDriver.tearDown();
    }

    @When("^I come back to a new shopping session$")
    public void i_come_back_to_a_new_shopping_session() throws Throwable {
        loginDriver.logout();
        loginDriver.loginAs(username, password);
    }

}
