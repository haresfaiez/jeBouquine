package acceptance.books.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddBookDriver {

    //TODO: externalize the informations below
    public static final String HOME_URL = "http://localhost:8080/jebouquine";

    private FirefoxDriver firefoxDriver;

    public void setUp() {
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(HOME_URL);
    }

    public void tearDown() {
        firefoxDriver.quit();
    }

    public void loginAs(String username, String password) {
        WebElement loginLink = firefoxDriver.findElementById("login");
        loginLink.click();
        WebElement usernameField = firefoxDriver.findElementById("username");
        usernameField.sendKeys(username);
        WebElement passwordField = firefoxDriver.findElementById("password");
        passwordField.sendKeys(password);
        WebElement submitButton = firefoxDriver.findElementById("submit");
        submitButton.click();
    }

    public void fillBookForm(String ISBN, String title, String price, String summary, String author) {
        WebElement addBookLink = firefoxDriver.findElementById("add-book");
        addBookLink.click();
        WebElement ISBNField = firefoxDriver.findElementById("book-isbn");
        ISBNField.sendKeys(ISBN);
        WebElement titleField = firefoxDriver.findElementById("book-title");
        titleField.sendKeys(title);
        //TODO:fill the whole form
    }

    public void submitBookForm() {
        WebElement submitButton = firefoxDriver.findElementById("book-submit");
        submitButton.click();
    }

    public void openBookDetails(String ISBN) {
        WebElement searchBookField = firefoxDriver.findElementById
                ("book-search");
        searchBookField.sendKeys(ISBN);
        WebElement searchBookByISBNRadio = firefoxDriver.findElementById("search-book-by-isbn");
        searchBookByISBNRadio.click();
        WebElement searchBookButton = firefoxDriver.findElementById
                ("book-search-submit");
        searchBookButton.click();
    }

    public void logout() {
        WebElement logoutLink = firefoxDriver.findElementById("logout");
        logoutLink.click();
    }

    public String bookISBN() {
        WebElement bookISBNLabel = firefoxDriver.findElementById("book-isbn");
        return bookISBNLabel.getText();
    }

    public String bookTitle() {
        WebElement bookTitleLabel = firefoxDriver.findElementById("book-title");
        return bookTitleLabel.getText();
    }
}
