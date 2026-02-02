package tests.login;

import base.BaseTestLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTestLogin {
    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);

    @Test
    public void testLogin() {
        logger.info("Test starting: testLogin");
        logger.info("Navigating to Login page");
        logger.info("Setting username");
        loginPage.setUsernameField("standard_user");
        logger.info("Setting password");
        loginPage.setPasswordField("secret_sauce");
        logger.info("Clicking Login button");
        loginPage.clickLoginButton();

        assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "User was not redirected to inventory page after login");
        logger.info("Assertion passed");
    }
}
