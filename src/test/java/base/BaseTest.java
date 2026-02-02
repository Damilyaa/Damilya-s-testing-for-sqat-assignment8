package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utility.Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public abstract class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");

        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        Utility.delay(1000);
        if (driver != null) {
            driver.quit();
        }
    }

    public String takeScreenshot(String testName) {
        if (driver == null) return null;

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // папка для скриншотов внутри target
            Path screenshotsDir = Path.of("target", "screenshots");
            Files.createDirectories(screenshotsDir);

            String safeName = testName == null ? "test" : testName.replaceAll("[^a-zA-Z0-9._-]", "_");
            Path dest = screenshotsDir.resolve(safeName + ".png");

            Files.copy(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
            return dest.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }
    }

}
