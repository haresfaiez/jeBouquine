package acceptance.books.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddBookDriver {

    private FirefoxDriver firefoxDriver;

    public AddBookDriver(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
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

}
