package acceptance.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class BookDriver {

    private FirefoxDriver firefoxDriver;

    public BookDriver(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
    }

    public void addToCart(List<String> book) {
        WebElement addToCartLink = firefoxDriver.findElementById("add-to-cart");
        addToCartLink.click();
    }
}
