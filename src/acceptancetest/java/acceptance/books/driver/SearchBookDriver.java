package acceptance.books.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

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
        searchForBook(ISBN, "search-book-by-isbn");
    }

    public void searchForBookByTitle(String title) {
        searchForBook(title, "search-book-by-title");
    }

    private void searchForBook(String value, String criteriaId) {
        WebElement searchBookField = firefoxDriver.findElementById
                ("book-search");
        searchBookField.sendKeys(value);
        WebElement searchBookByISBNRadio = firefoxDriver.findElementById(criteriaId);
        searchBookByISBNRadio.click();
        WebElement searchBookButton = firefoxDriver.findElementById
                ("book-search-submit");
        searchBookButton.click();
    }

    public Boolean searchResultContains(String bookTitle) {
        List<WebElement> searchResultBooks = firefoxDriver.findElementsById
                ("book-search-result-book-title");
        return searchResultBooks.stream()
                .anyMatch(webElement -> webElement.getText().equals(bookTitle));
    }

}
