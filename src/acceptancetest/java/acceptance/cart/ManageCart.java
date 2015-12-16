package acceptance.cart;

import acceptance.HomeDriver;
import acceptance.driver.*;
import acceptance.factory.ListToBook;
import acceptance.factory.PurchaseToBook;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class ManageCart {
    private FirefoxDriver firefoxDriver = new FirefoxDriver();

    private AddBookDriver addBookDriver = new AddBookDriver(firefoxDriver);
    private LoginDriver loginDriver = new LoginDriver(firefoxDriver);
    private SearchBookDriver searchBookDriver = new SearchBookDriver(firefoxDriver);
    private HomeDriver homeDriver = new HomeDriver(firefoxDriver);
    private BookDriver bookDriver = new BookDriver(firefoxDriver);
    private CartDriver cartDriver = new CartDriver(firefoxDriver);

    private List<String> firstBook;
    private List<String> bookToRemove;

    @Given("^My cart contains$")
    public void my_cart_contains(List<List<String>> purchases) throws
            Throwable {
        homeDriver.setUp();
        loginDriver.loginAs(LoginDriver.logisticManagerUsername, LoginDriver.logisticManagerPassword);
        List<String> firstPurchase = purchases.get(1);
        List<String> secondPurchase = purchases.get(2);
        firstBook = PurchaseToBook.from(firstPurchase, "MC1");
        bookToRemove = PurchaseToBook.from(secondPurchase, "MC2");
        addBookDriver.addBook(firstBook);
        addBookDriver.addBook(bookToRemove);
        loginDriver.logout();
        loginDriver.loginAs(LoginDriver.customerUsername, LoginDriver
                .customerPassword);
        searchBookDriver.openBookDetails(ListToBook.ISBNOf(firstBook));
        bookDriver.addToCart(firstBook);
        searchBookDriver.openBookDetails(ListToBook.ISBNOf(bookToRemove));
        bookDriver.addToCart(bookToRemove);
    }

    @When("^I remove the first book purchase$")
    public void i_remove_the_book_purchase_from_my_cart()
            throws
            Throwable {
        cartDriver.visitCart();
        cartDriver.removePurchaseOf(bookToRemove.get(0));
    }


    @When("^I modify the quantity of the book \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_modify_the_quantity_of_the_book_to(String bookTitle, String
            newBookQuantity) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The cart should contains just the first book$")
    public void the_cart_should_contains() throws Throwable {
        cartDriver.visitCart();
        cartDriver.assertPurchaseTitleExists(firstBook.get(1));
        cartDriver.assertPurchaseTitleDoesntExists(bookToRemove.get(1));
        loginDriver.logout();
        homeDriver.tearDown();
    }
}
