package utility;

import org.openqa.selenium.WebDriver;

public class Utility {

    public static void open(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
