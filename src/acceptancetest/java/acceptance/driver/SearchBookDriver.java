package acceptance.driver;

import org.junit.Assert;
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

    public String bookPrice() {
        WebElement bookPriceLabel = firefoxDriver.findElementById("book-price");
        return bookPriceLabel.getText();
    }

    public String bookSummary() {
        WebElement bookSummaryLabel = firefoxDriver.findElementById
                ("book-summary");
        return bookSummaryLabel.getText();
    }

    public String bookAuthor() {
       WebElement bookAuthorLabel = firefoxDriver.findElementById("book-author");
        return bookAuthorLabel.getText();
    }

    public void searchForBookByTitle(String title) {
        searchForBook(title, "search-book-by-title");
    }

    public String bookTitle() {
        WebElement bookTitleLabel = firefoxDriver.findElementById("book-title");
        return bookTitleLabel.getText();
    }

    public void openBookDetails(String ISBN) {
        searchForBook(ISBN, "search-book-by-isbn");
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

    public void assertBookExists(List<List<String>> book) {
        String ISBN = book.get(1).get(0);
        String title = book.get(1).get(1);
        String price = book.get(1).get(2);
        String summary = book.get(1).get(3);
        String author = book.get(1).get(4);
        Assert.assertEquals(ISBN, bookISBN());
        Assert.assertEquals(title, bookTitle());
        Assert.assertEquals(price, bookPrice());
        Assert.assertEquals(summary, bookSummary());
        Assert.assertEquals(author, bookAuthor());
    }
}
