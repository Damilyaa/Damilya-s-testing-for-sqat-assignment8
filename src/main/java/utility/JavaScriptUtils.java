package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptUtils {

    // ===== WebElement versions (у тебя уже это есть) =====
    public static void scrollToElementJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickWithJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // ===== By versions (ВАЖНО: добавляем чтобы твой старый код компилировался) =====
    public static void scrollToElementJS(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        scrollToElementJS(driver, element);
    }

    public static void clickJS(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        clickWithJS(driver, element);
    }

    // (опционально) иногда полезно, если обычный click не работает
    public static void clickAction(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        new Actions(driver).moveToElement(element).click().perform();
    }
}
