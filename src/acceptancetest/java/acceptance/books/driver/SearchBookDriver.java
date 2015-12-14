package acceptance.books.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchBookDriver {
    private FirefoxDriver firefoxDriver;

    public SearchBookDriver(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
    }

    public String bookISBN() {
        WebElement bookISBNLabel = firefoxDriver.findElementById("book-isbn");
        return bookISBNLabel.getText();
    }

    public String bookTitle() {
        WebElement bookTitleLabel = firefoxDriver.findElementById("book-title");
        return bookTitleLabel.getText();
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

}
