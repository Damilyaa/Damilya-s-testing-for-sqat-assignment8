package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTestLogin {

    protected WebDriver driver;
    protected LoginPage loginPage;

    private static final Logger logger = LogManager.getLogger(BaseTestLogin.class);

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        logger.info("Opening SauceDemo login page");
        driver.get("https://www.saucedemo.com/");

        // ✅ ЭТО УБИРАЕТ NPE: BasePageLogin.driver null
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing browser");
        if (driver != null) driver.quit();
    }
}
