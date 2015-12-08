package acceptance.bookshelf.search;

import jebouquine.domain.bookshelf.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Optional;

public class BookSearchWebDriver {

    //TODO: externalize the informations below
    public static final String HOME_URL = "http://localhost:8080/jebouquine";
    public static final String FIND_BOOK_BY_ISBN = "find-book-by-isbn";
    public static final String BOOK_SEARCH_RESULT_BOOK_TITLE =
            "result-book-title";

    private FirefoxDriver firefoxDriver;

    public BookSearchWebDriver() {
    }

    public void setUp () {
        firefoxDriver = new FirefoxDriver();
    }

    public void tearDown() {
        firefoxDriver.quit();
    }

    public void findBookByISBN(String bookISBN) {
        firefoxDriver.get(HOME_URL);
        WebElement element = firefoxDriver.findElement(By.id
                (FIND_BOOK_BY_ISBN));
        element.sendKeys(bookISBN);
        element.submit();
    }

    public Optional<Book> firstBookIfExists() {
        List<WebElement> bookSearchResultsTitles = firefoxDriver.findElements
                (By.id
                (BOOK_SEARCH_RESULT_BOOK_TITLE));
        return Optional.of(new Book("", bookSearchResultsTitles.get(0)
                .getText()));

    }
}
