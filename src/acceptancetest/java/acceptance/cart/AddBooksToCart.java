package acceptance.cart;

import acceptance.HomeDriver;
import acceptance.driver.AddBookDriver;
import acceptance.driver.LoginDriver;
import acceptance.driver.SearchBookDriver;
import cucumber.api.java.en.Given;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class AddBooksToCart {
    private FirefoxDriver firefoxDriver = new FirefoxDriver();

    private AddBookDriver addBookDriver = new AddBookDriver(firefoxDriver);
    private LoginDriver loginDriver = new LoginDriver(firefoxDriver);
    private SearchBookDriver searchBookDriver = new SearchBookDriver(firefoxDriver);
    private HomeDriver homeDriver = new HomeDriver(firefoxDriver);


    @Given("^the books I want to buy are$")
    public void the_books_I_want_to_buy_are(List<List<String>> books)
            throws Throwable {
        homeDriver.setUp();
        loginDriver.loginAs(LoginDriver.logisticManagerUsername, LoginDriver.logisticManagerPassword);
        addBookDriver.addBook(books.get(1));
        addBookDriver.addBook(books.get(2));
    }

}
