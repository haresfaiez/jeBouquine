package acceptance.user.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginDriver {

    //Logistic manager
    public static final String logisticManagerUsername = "faiez_logistic";
    public static final String logisticManagerPassword = "0000";

    private FirefoxDriver firefoxDriver;

    public LoginDriver(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
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

    public void logout() {
        WebElement logoutLink = firefoxDriver.findElementById("logout");
        logoutLink.click();
    }


}
