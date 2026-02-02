package pages.elements;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utility.JavaScriptUtils;


public class WebTablesPage extends HomePage {

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }
    private static final Logger logger =
            LogManager.getLogger(WebTablesPage.class);

    private By registrationFirstNameField = By.id("firstName");
    private By registrationLastNameField = By.id("lastName");
    private By registrationEmailField = By.id("userEmail");
    private By registrationAgeField = By.id("age");
    private By registrationSubmitButton = By.id("submit");

    public void clickEditButton(String email) {
        logger.info("Clicking edit table button");
        By editButton = By.id("edit-record-1");
        WebElement editBtn = find(editButton);
        JavaScriptUtils.scrollToElementJS(driver, editBtn);
        click(editButton);
    }

    public void setFirstName(String firstName) {
        logger.info("Setting First Name field");
        set(registrationFirstNameField, firstName);
    }

    public void setLastName(String lastName) {
        logger.info("Setting Last Name field");
        set(registrationLastNameField, lastName);
    }

    public void setAge(String age) {
        logger.info("Setting Age field");
        set(registrationAgeField, age);
    }

    public void clickSubmitButton() {
        logger.info("Clicking Submit button");
        click(registrationSubmitButton);
    }

    public String getTableFirstName(String email) {
        logger.info("Retrieving First Name field text");
        By tableFirstName = By.xpath("//div[text()='"+ email +"']//preceding::div[3]");
        return find(tableFirstName).getText();
    }




}
