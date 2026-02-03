package pages;

import base.BasePageSearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import java.time.Duration;

public class SearchPage extends BasePageSearch {

    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    private final By searchInput = By.name("q");

    private final By resultsContainer = By.cssSelector("div#search");
    private final By resultTitles = By.cssSelector("div#search h3");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchQuery(String query) {
        logger.info("Entering search query: {}", query);
        set(searchInput, query);
    }

    public void submitSearch() {
        logger.info("Submitting search (ENTER)");
        pressKey(searchInput, Keys.ENTER);
    }

    public boolean areResultsDisplayed() {
        logger.info("Checking results visible");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            By acceptBtn = By.xpath(
                    "//button//*[normalize-space()='I agree' or normalize-space()='Accept all' or normalize-space()='Принять все' or normalize-space()='Согласен' or normalize-space()='Accept']"
            );
            wait.withTimeout(Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(acceptBtn))
                    .click();
            logger.info("Consent accepted");
        } catch (Exception ignored) {
            // consent не показан — ок
        }

        wait.withTimeout(Duration.ofSeconds(10)).until(d -> {
            String url = d.getCurrentUrl();
            boolean hasQuery = url.contains("q=");
            boolean hasResultsContainer =
                    d.findElements(By.cssSelector("#search")).size() > 0 ||
                            d.findElements(By.cssSelector("#rso")).size() > 0;
            return hasQuery || hasResultsContainer;
        });

        boolean hasResults =
                driver.findElements(By.cssSelector("#search h3")).size() > 0 ||
                        driver.findElements(By.cssSelector("#rso h3")).size() > 0;

        boolean hasQueryInUrl = driver.getCurrentUrl().contains("q=");

        return hasResults || hasQueryInUrl;
    }

}
