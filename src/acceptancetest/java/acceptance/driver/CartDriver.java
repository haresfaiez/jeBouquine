package acceptance.driver;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class CartDriver {

    private FirefoxDriver firefoxDriver;

    public CartDriver(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
    }

    public void visitCart() {
        WebElement viewCartLink = firefoxDriver.findElementById("view-cart");
        viewCartLink.click();
    }

    public void assertPurchaseExists(List<String> purchase) {
        String bookTitle = purchase.get(0);
        //TODO:test also the price and the date
        String bookPrice = purchase.get(1);
        List<WebElement> purchasesTitles = firefoxDriver.findElementsById
                ("cart-view-book-title");
        Assert.assertTrue(purchasesTitles.stream()
                .anyMatch(webElement -> webElement.getText().equals(bookTitle)));
    }

    public void assertPurchasesSumIs(String expectedSum) {
        WebElement purchasesSum = firefoxDriver.findElementById("purchases-sum");
        Assert.assertEquals(expectedSum, purchasesSum.getText());
    }
}
