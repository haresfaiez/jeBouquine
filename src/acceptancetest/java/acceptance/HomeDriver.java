package acceptance;

import org.openqa.selenium.firefox.FirefoxDriver;

public class HomeDriver {
    //TODO: externalize the informations below
    public static final String HOME_URL = "http://localhost:8080/jebouquine";

    private FirefoxDriver firefoxDriver;

    public HomeDriver(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
    }

    public void setUp() {
        firefoxDriver.get(HomeDriver.HOME_URL);
    }

    public void tearDown() {
        firefoxDriver.quit();
    }
}
