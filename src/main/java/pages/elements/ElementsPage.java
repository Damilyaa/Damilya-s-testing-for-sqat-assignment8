package pages.elements;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.JavaScriptUtils;

public class ElementsPage extends BasePage {

    private static final Logger logger =
            LogManager.getLogger(ElementsPage.class);

    private final By webTablesMenuItem =
            By.xpath("//li[@id='item-3']/span[text()='Web Tables']");
    private final By linksMenuItem =
            By.xpath("//li[@id='item-5']/span[text()='Links']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage clickWebTables() {
        logger.info("Clicking Web Tables menu item");

        WebElement item = find(webTablesMenuItem);
        JavaScriptUtils.scrollToElementJS(driver, item);
        click(webTablesMenuItem);

        return new WebTablesPage(driver);
    }


}
