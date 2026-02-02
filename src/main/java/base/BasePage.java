package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        WebElement el = find(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void pressKey(By locator, Keys key) {
        find(locator).sendKeys(key);
    }

    protected boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
