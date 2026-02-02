package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SearchPage;

public class BaseTestSearch {

    protected WebDriver driver;
    protected SearchPage searchPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // ✅ ЭТО УБИРАЕТ NPE: BasePageSearch.driver null
        searchPage = new SearchPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
