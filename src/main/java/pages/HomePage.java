package pages;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.elements.ElementsPage;
import utility.JavaScriptUtils;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    private final By elementsCard = By.xpath("//h5[normalize-space()='Elements']");
    private final By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage goToElements() {
        logger.info("Navigating to Elements page");

        // 1) Убедимся, что мы точно на demoqa home
        if (!driver.getCurrentUrl().contains("demoqa.com")) {
            driver.get("https://demoqa.com");
        }

        var wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(15));

        // 2) Ждём, что карточка Elements появится
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(elementsCard));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(elementsCard));

        // 3) Скроллим к элементу (JS)
        org.openqa.selenium.WebElement card = find(elementsCard);
        utility.JavaScriptUtils.scrollToElementJS(driver, card);

        // 4) Кликаем (если обычный click не сработает — делаем JS click)
        try {
            click(elementsCard);
        } catch (Exception e) {
            utility.JavaScriptUtils.clickJS(driver, elementsCard);
        }

        return new pages.elements.ElementsPage(driver);
    }


}
