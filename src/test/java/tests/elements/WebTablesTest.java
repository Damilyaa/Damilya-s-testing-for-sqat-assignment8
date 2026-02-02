package tests.elements;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.HomePage;

@Listeners(TestListener.class)
public class WebTablesTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(WebTablesTest.class);

    @Test
    public void testEditWebTable() {
        logger.info("Test starting: testEditWebTable");

        // 1) Open DemoQA
        driver.get("https://demoqa.com");
        HomePage homePage = new HomePage(driver);

        // 2) Navigate: Home -> Elements -> Web Tables
        var elementsPage = homePage.goToElements();
        var webTablesPage = elementsPage.clickWebTables();

        logger.info("Navigating to Web Tables page");

        // 3) Edit user
        String email = "cierra@example.com";

        webTablesPage.clickEditButton(email);
        logger.info("Clicking edit button");

        webTablesPage.setFirstName("Damilya");
        logger.info("Setting the First Name");

        webTablesPage.setLastName("Amangeldykyzy");
        logger.info("Setting the Last Name");

        webTablesPage.setAge("20");
        logger.info("Setting the Age");

        webTablesPage.clickSubmitButton();
        logger.info("Clicking Submit button");

        // 4) Assert
        String actualName = webTablesPage.getTableFirstName(email);
        String expectedName = "Damilya";

        Assert.assertEquals(actualName, expectedName,
                "Actual and expected names do not match");
        logger.info("Assertion passed");
    }
}
