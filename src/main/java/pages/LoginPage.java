package pages;

import base.BasePageLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageLogin {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton   = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsernameField(String username) {
        logger.info("Setting username field");
        set(usernameField, username);
    }

    public void setPasswordField(String password) {
        logger.info("Setting password field");
        set(passwordField, password);
    }

    public void clickLoginButton() {
        logger.info("Clicking login button");
        click(loginButton);
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
}
